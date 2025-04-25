package br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.dto;

import jakarta.validation.constraints.NotBlank;

public record MecanicoDTO(

        @NotBlank
        String nome,

        String anosDeExperiencia) {
}
