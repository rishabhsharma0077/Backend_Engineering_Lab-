package in.ait;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import in.ait.entity.Expense;
import in.ait.repository.ExpenseRepository;
import in.ait.service.ExpenseServiceImpl;

@ExtendWith(MockitoExtension.class)
class ExpenseServiceTest {

    @Mock
    private ExpenseRepository repo;

    @InjectMocks
    private ExpenseServiceImpl service;

    @Test
    void testAddExpense() {
        Expense exp = new Expense();
        exp.setTitle("Books");
        exp.setCategory("Study");
        exp.setAmount(400);

        when(repo.save(exp)).thenReturn(exp);

        Expense saved = service.addExpense(exp);

        assertEquals("Books", saved.getTitle());
        verify(repo, times(1)).save(exp);
    }

    @Test
    void testGetAllExpenses() {
        Expense e1 = new Expense();
        e1.setTitle("Tea");
        e1.setCategory("Food");
        e1.setAmount(50);

        Expense e2 = new Expense();
        e2.setTitle("Bus");
        e2.setCategory("Travel");
        e2.setAmount(80);

        List<Expense> list = Arrays.asList(e1, e2);

        when(repo.findAll()).thenReturn(list);

        List<Expense> result = service.getAllExpenses();

        assertEquals(2, result.size());
        verify(repo, times(1)).findAll();
    }
}
