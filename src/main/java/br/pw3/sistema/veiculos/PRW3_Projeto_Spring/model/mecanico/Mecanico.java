package br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.mecanico;

import br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.dto.MecanicoDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {

    private String nome;
    private String anosDeExperiencia;

    public Mecanico(MecanicoDTO dados) {
        this.nome = dados.nome();
        this.anosDeExperiencia = dados.anosDeExperiencia();
    }

    public void atualizar(MecanicoDTO dados) {

        if (dados.nome() != null) {
            this.nome = dados.nome();
        }

        if (dados.anosDeExperiencia() != null) {
            this.anosDeExperiencia = dados.anosDeExperiencia();
        }
    }

}
