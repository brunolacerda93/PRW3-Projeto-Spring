package br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.repository;

import br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.conserto.Conserto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsertoRepository extends JpaRepository<Conserto, Long> {
}
