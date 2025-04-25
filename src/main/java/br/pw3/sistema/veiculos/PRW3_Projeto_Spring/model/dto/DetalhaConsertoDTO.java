package br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.dto;

import br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.conserto.Conserto;
import br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.mecanico.Mecanico;
import br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.veiculo.Veiculo;

public record DetalhaConsertoDTO(Long id, String dataEntrada, String dataSaida,
                                 Mecanico responsavel, Veiculo veiculo) {

    public DetalhaConsertoDTO(Conserto conserto) {
        this(conserto.getId(), conserto.getDataEntrada(), conserto.getDataSaida(), conserto.getResponsavel(), conserto.getVeiculo());
    }
}
