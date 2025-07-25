package com.daviaugusto.desafio_itau.infrastructure.controller;


import com.daviaugusto.desafio_itau.infrastructure.entities.Estatistica;
import com.daviaugusto.desafio_itau.infrastructure.entities.Transacao;
import com.daviaugusto.desafio_itau.infrastructure.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    TransacaoService transacaoService;


    @PostMapping
    public ResponseEntity<Void> gravarTrasacao(@RequestBody Transacao transacao){
        transacaoService.gravarTransacao(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarTrasacoes(){
        transacaoService.deletarTransacoes();
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Estatistica> pegarEstatistica(){
        return ResponseEntity.ok(transacaoService.pegarEstatisticas());
    }

}
