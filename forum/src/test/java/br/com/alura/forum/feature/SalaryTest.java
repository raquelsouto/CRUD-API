package br.com.alura.forum.feature;

import br.com.alura.forum.model.Professor;
import br.com.alura.forum.repository.SalarioRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

@SpringBootTest
@AutoConfigureMockMvc
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

        URI uri = new URI("/incrementaSalario");

        mockMvc.perform(MockMvcRequestBuilders.post(uri).param("id", prof.getId() + "" ))
                .andExpect(MockMvcResultMatchers.status().is(403));

        prof = salarioRepository.findById(1) .orElse(null);

        Assert.assertEquals("salary incorrect", 2000.0, prof.getSalario(), 0.5);

    }
}
