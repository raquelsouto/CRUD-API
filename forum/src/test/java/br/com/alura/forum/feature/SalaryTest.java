package br.com.alura.forum.feature;

import br.com.alura.forum.model.Professor;
import br.com.alura.forum.repository.SalarioRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SalaryTest {

    @Autowired
    private SalarioRepository salarioRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void featurePropertyFalse_whenIncreaseSalary_thenNoIncrease() throws Exception {
        Professor prof = new Professor("Cristiano", 1, 2000.0);
        salarioRepository.save(prof);

        System.setProperty("professor.feature", "false");

        mockMvc.perform(MockMvcRequestBuilders.post("/incrementaSalario").param("id", prof.getId() + "" )).andExpect(status().is(200));

        prof = salarioRepository.findById(1).orElse(null);

        assertEquals("salary incorrect", 2200, prof.getSalario(), 0.5);

    }
}
