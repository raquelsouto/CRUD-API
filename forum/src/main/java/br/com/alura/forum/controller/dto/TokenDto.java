package br.com.alura.forum.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NotEmpty
@Getter
@Setter
public class TokenDto {

    private String token;
    private String tipo;
}
