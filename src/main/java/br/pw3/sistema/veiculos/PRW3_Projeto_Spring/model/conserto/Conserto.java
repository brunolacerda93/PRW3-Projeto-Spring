package br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.conserto;

import br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.dto.AtualizaConsertoDTO;
import br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.dto.AtualizaConsertoEspecificoDTO;
import br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.dto.CadastroConsertoDTO;
import br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.mecanico.Mecanico;
import br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.veiculo.Veiculo;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "conserto")
@Entity(name = "Conserto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dataEntrada;
    private String dataSaida;

    @Embedded
    private Mecanico responsavel;
    @Embedded
    private Veiculo veiculo;

    private boolean ativo;

    public Conserto(CadastroConsertoDTO dados) {
        this.ativo = true;
        this.dataEntrada = dados.dataEntrada();
        this.dataSaida = dados.dataSaida();
        this.responsavel = new Mecanico(dados.responsavel());
        this.veiculo = new Veiculo(dados.veiculo());
    }

    public void atualizar(AtualizaConsertoDTO dados) {

        if (dados.dataEntrada() != null) {
            this.dataEntrada = dados.dataEntrada();
        }

        if (dados.dataSaida() != null) {
            this.dataSaida = dados.dataSaida();
        }

        if (dados.responsavel() != null) {
            this.responsavel.atualizar(dados.responsavel());
        }

        if (dados.veiculo() != null) {
            this.veiculo.atualizar(dados.veiculo());
        }
    }

    public void atualizarEspecifico(AtualizaConsertoEspecificoDTO dados) {
        if (dados.dataSaida() != null) {
            this.dataSaida = dados.dataSaida();
        }

        if (dados.nomeMecanico() != null) {
            this.responsavel.setNome(dados.nomeMecanico());
        }

        if (dados.anosExperienciaMecanico() != null) {
            this.responsavel.setAnosDeExperiencia(dados.anosExperienciaMecanico());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
