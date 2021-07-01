package br.com.alura.forum.exception.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ErroDeFormularioDto {

    private String campo;
    private String error;
}

//Representa o erro de algum campo e a mensagem de erro.