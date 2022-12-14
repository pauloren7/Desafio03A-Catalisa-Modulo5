package com.api.gerenciadordecontas.controller;

import com.api.gerenciadordecontas.model.ResponseUsuarios;
import com.api.gerenciadordecontas.model.Usuarios;
import com.api.gerenciadordecontas.service.ServiceUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/usuarios")
public class ControllerUsuarios {
    @Autowired
    private ServiceUsuarios serviceUsuarios;

    @GetMapping
    public ResponseEntity<List<ResponseUsuarios>> buscarTodos() {
        return ResponseEntity.ok(serviceUsuarios.buscarTodos());
    }

    @GetMapping(path = "/{codigo}")
    public ResponseEntity<Optional<Usuarios>> buscarPorId(@PathVariable Long codigo) {
        return ResponseEntity.ok(serviceUsuarios.buscarId(codigo));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> cadastrar(@Valid @RequestBody Usuarios usuarios) {
        return ResponseEntity.ok(serviceUsuarios.cadastrar(usuarios));
    }

    @PatchMapping(path = "/{codigo}")
    public ResponseEntity<Usuarios> alterar(@PathVariable Long codigo, @RequestBody Usuarios usuarios) {
        return ResponseEntity.ok(serviceUsuarios.alterar(usuarios, codigo));
    }

    @DeleteMapping(path = "/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deletar(@PathVariable Long codigo) {
        serviceUsuarios.deletar(codigo);
        return "Deletado";
    }
}
