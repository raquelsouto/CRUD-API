package br.com.alura.forum.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Resposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String mensagem;

	@ManyToOne
	private Topico topico;

	@CreationTimestamp
	private LocalDateTime dataCriacao;

	@ManyToOne
	private Usuario autor;
	private Boolean solucao = false;
}
