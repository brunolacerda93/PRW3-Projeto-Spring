package br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record CadastroConsertoDTO(

        @NotBlank
        String dataEntrada,

        String dataSaida,

        @NotBlank
        @Valid
        MecanicoDTO responsavel,

        @NotBlank
        @Valid
        VeiculoDTO veiculo) {
}
