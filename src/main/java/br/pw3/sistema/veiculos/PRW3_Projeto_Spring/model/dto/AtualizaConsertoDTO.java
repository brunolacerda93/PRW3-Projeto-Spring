package br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.dto;

import jakarta.validation.constraints.NotNull;

public record AtualizaConsertoDTO(

        @NotNull
        Long id,

        String dataEntrada,

        String dataSaida,

        MecanicoDTO responsavel,

        VeiculoDTO veiculo) {
}
