package br.pw3.sistema.veiculos.PRW3_Projeto_Spring.controller;

import br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.conserto.Conserto;
import br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.dto.AtualizaConsertoDTO;
import br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.dto.CadastroConsertoDTO;
import br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.dto.DetalhaConsertoDTO;
import br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.dto.ListaConsertoDTO;
import br.pw3.sistema.veiculos.PRW3_Projeto_Spring.model.repository.ConsertoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/consertos")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizaConsertoDTO dados) {
        Conserto conserto = repository.getReferenceById(dados.id());
        conserto.atualizar(dados);
        return ResponseEntity.ok(new DetalhaConsertoDTO(conserto));
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroConsertoDTO dados,
                                              UriComponentsBuilder uriBuilder) {
        var conserto = new Conserto(dados);
        repository.save(conserto);
        var uri = uriBuilder.path("/consertos/{id}").buildAndExpand(conserto.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhaConsertoDTO(conserto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        Conserto conserto = repository.getReferenceById(id);
        // conserto.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getConsertoById(@PathVariable Long id) {
        Optional<Conserto> conserto = repository.findById(id);
        if (conserto.isPresent()) {
            return ResponseEntity.ok(new DetalhaConsertoDTO(conserto.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("listartodos")
    public ResponseEntity listar(Pageable pageable) {
        return ResponseEntity.ok(repository.findAll(pageable).stream().map(DetalhaConsertoDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("listartodosresumo")
    public ResponseEntity listarResumo() {
        return ResponseEntity.ok(repository.findAll().stream().map(ListaConsertoDTO::new).collect(Collectors.toList()));
    }

}
