package br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.dto;

import jakarta.validation.constraints.NotBlank;

public record VeiculoDTO(

        @NotBlank
        String marca,

        @NotBlank
        String modelo,

        @NotBlank
        String ano) {
}
