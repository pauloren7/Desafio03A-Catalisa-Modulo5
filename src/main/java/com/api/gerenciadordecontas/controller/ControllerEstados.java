package com.api.gerenciadordecontas.controller;

import com.api.gerenciadordecontas.model.Estados;
import com.api.gerenciadordecontas.service.ServiceEstados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/estados")
@Validated
public class ControllerEstados {
    @Autowired
    private ServiceEstados serviceEstados;

    @GetMapping
    public ResponseEntity< List<Estados>> buscarTodos() {
        return ResponseEntity.ok( serviceEstados.buscarTodos());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity< Optional<Estados>> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok( serviceEstados.buscarId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity< Estados> cadastrar(@RequestBody Estados estados) {
        return ResponseEntity.ok( serviceEstados.cadastrar(estados));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity< Estados> alterar(@PathVariable Long id, @RequestBody Estados estados) {
        return ResponseEntity.ok( serviceEstados.alterar(estados));
    }

    @DeleteMapping(path = "/{id}")
    public String deletar(@PathVariable Long id) {
        serviceEstados.deletar(id);
        return "Deletado";
    }
}