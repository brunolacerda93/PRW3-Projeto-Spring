package br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.dto;

import jakarta.validation.constraints.NotNull;

public record AtualizaConsertoEspecificoDTO(

        @NotNull
        Long id,

        String dataSaida,

        String nomeMecanico,

        String anosExperienciaMecanico) {
}
