package br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.dto;

import br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.conserto.Conserto;

public record ListaConsertoDTO(Long id, String dataEntrada, String dataSaida,
                               String nome, String marca, String modelo) {

    public ListaConsertoDTO(Conserto conserto) {
        this(conserto.getId(), conserto.getDataEntrada(), conserto.getDataSaida(),
                conserto.getResponsavel().getNome(), conserto.getVeiculo().getMarca(), conserto.getVeiculo().getModelo());
    }
}
