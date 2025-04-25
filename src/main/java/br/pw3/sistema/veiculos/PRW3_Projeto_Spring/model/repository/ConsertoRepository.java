package br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.repository;

import br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.conserto.Conserto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsertoRepository extends JpaRepository<Conserto, Long> {

    List<Conserto> findAllByAtivoTrue();
    Page<Conserto> findAllByAtivoTrue(Pageable pageable);
}
