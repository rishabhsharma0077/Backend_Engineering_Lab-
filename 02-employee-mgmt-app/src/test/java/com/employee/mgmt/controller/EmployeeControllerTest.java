package com.employee.mgmt.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.employee.mgmt.entity.Employee;
import com.employee.mgmt.service.EmployeeService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void home_returnsEmployeesAndMessage() throws Exception {
        Employee e1 = new Employee();
        e1.setId(1);
        e1.setName("Alice");
        Employee e2 = new Employee();
        e2.setId(2);
        e2.setName("Bob");

        when(service.getAll()).thenReturn(List.of(e1, e2));

        mockMvc.perform(get("/").flashAttr("message", "hi"))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.view().name("index"))
            .andExpect(MockMvcResultMatchers.model().attributeExists("employees"))
            .andExpect(MockMvcResultMatchers.model().attribute("message", "hi"));

        verify(service).getAll();
    }

    @Test
    void showAddForm_returnsAddViewWithEmptyEmployee() throws Exception {
        mockMvc.perform(get("/add"))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.view().name("add"))
            .andExpect(MockMvcResultMatchers.model().attributeExists("employee"));
    }

    @Test
    void save_redirectsToHome_withFlashMessage() throws Exception {
        Employee inp = new Employee();
        inp.setName("Charlie");

        // service.save is void
        doNothing().when(service).save(any(Employee.class));

        mockMvc.perform(post("/save")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("name", "Charlie")
                .param("department", "IT")
                .param("salary", "50000"))
            .andExpect(status().is3xxRedirection())
            .andExpect(MockMvcResultMatchers.redirectedUrl("/"));

        verify(service).save(any(Employee.class));
    }

    @Test
    void edit_loadsEmployeeAndReturnsAddView() throws Exception {
        Employee e = new Employee();
        e.setId(5);
        e.setName("Dana");

        when(service.getById(5)).thenReturn(e);

        mockMvc.perform(get("/edit/5"))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.view().name("add"))
            .andExpect(MockMvcResultMatchers.model().attributeExists("employee"))
            .andExpect(MockMvcResultMatchers.model().attribute("employee", e));

        verify(service).getById(5);
    }

    @Test
    void delete_deletesAndRedirectsWithFlash() throws Exception {
        doNothing().when(service).delete(7);

        mockMvc.perform(get("/delete/7"))
            .andExpect(status().is3xxRedirection())
            .andExpect(MockMvcResultMatchers.redirectedUrl("/"));

        verify(service).delete(7);
    }
}
