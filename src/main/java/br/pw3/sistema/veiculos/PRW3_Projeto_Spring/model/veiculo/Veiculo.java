package br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.veiculo;

import br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.dto.VeiculoDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {

    private String marca;
    private String modelo;
    private String ano;

    public Veiculo(VeiculoDTO dados) {
        this.marca = dados.marca();
        this.modelo = dados.modelo();
        this.ano = dados.ano();
    }

    public void atualizar(VeiculoDTO dados) {

        if (dados.marca() != null) {
            this.marca = dados.marca();
        }

        if (dados.modelo() != null) {
            this.modelo = dados.modelo();
        }

        if (dados.ano() != null) {
            this.ano = dados.ano();
        }
    }

}
