package br.com.alura.forum.repository;

import br.com.alura.forum.model.Curso;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class CursoRepositoryTest {

    @Autowired
    private CursoRepository cursoRepository;

    @Test
    public void deveriaCarregarUmCursoAoBuscarPeloNome() {
        String nomeCurso = "HTML 5";
        Curso curso = cursoRepository.findByNome(nomeCurso);
        Assert.assertNotNull(curso);
        Assert.assertEquals(nomeCurso, curso.getNome());
    }

    @Test
    public void NãodeveriaEncontrarEsseCurso() {
        String nomeCurso = "JPA";
        Curso curso = cursoRepository.findByNome(nomeCurso);
        Assert.assertNull(curso);
    }



}