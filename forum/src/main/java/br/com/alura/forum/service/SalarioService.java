package br.com.alura.forum.service;

import br.com.alura.forum.feature.FeatureAssociation;
import br.com.alura.forum.feature.FeatureToggle;
import br.com.alura.forum.model.Professor;
import br.com.alura.forum.repository.SalarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalarioService {

    @Autowired
    SalarioRepository professorRepository;

    @FeatureAssociation(value = FeatureToggle.PROFESSOR_MANAGEMENT_FEATURE)
    public void incrementaSalario(Integer id) {
        Professor professor = professorRepository.findById(id).orElse(null);
        professor.setSalario(professor.getSalario() + professor.getSalario() * 0.1);
        professorRepository.save(professor);
    }
}
