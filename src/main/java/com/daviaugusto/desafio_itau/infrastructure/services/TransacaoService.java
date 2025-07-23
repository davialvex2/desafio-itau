package com.daviaugusto.desafio_itau.infrastructure.services;

import com.daviaugusto.desafio_itau.infrastructure.entities.Transacao;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {

    List<Transacao> listaTransacao = new ArrayList<>();

    public void gravarTransacao(Transacao transacao){
        if(transacao.getDataHora().isAfter(OffsetDateTime.now())){
            throw new RuntimeException("A data está no futuro");
        }
        if(transacao.getValor()<0){
            throw new RuntimeException("O valor passado é menor que zero");
        }
            listaTransacao.add(transacao);
    }






}
