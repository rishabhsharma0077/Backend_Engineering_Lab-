package com.employee.mgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.employee.mgmt.entity.Employee;
import com.employee.mgmt.service.EmployeeService;



@Controller
public class EmployeeController {
	@Autowired
    private EmployeeService service;

    @GetMapping("/")
    public String home(Model model, @ModelAttribute("message") String message) {
        model.addAttribute("employees", service.getAll());
        model.addAttribute("message", message); // for success message
        return "index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee()); // ✅ This is required
        return "add"; // ✅ Should match "add.html"
    
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Employee emp, RedirectAttributes redirectAttrs) {
        service.save(emp);
        redirectAttrs.addFlashAttribute("message", "✅ Employee added successfully!");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("employee", service.getById(id));
        return "add";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttrs) {
        service.delete(id);
        redirectAttrs.addFlashAttribute("message", "🗑️ Employee deleted successfully!");
        return "redirect:/";
    }
}


