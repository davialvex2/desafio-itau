package com.daviaugusto.desafio_itau.infrastructure.services;

import com.daviaugusto.desafio_itau.infrastructure.entities.Estatistica;
import com.daviaugusto.desafio_itau.infrastructure.entities.Transacao;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;


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

    public void deletarTransacoes(){
        listaTransacao.clear();
    }

    public List<Transacao> ultimasTransacoes(List<Transacao> lista){
        OffsetDateTime umMinutoTras = OffsetDateTime.now().minusMinutes(1);
        List<Transacao> listaTransacao = lista.stream().filter(x -> x.getDataHora().isAfter(umMinutoTras)).collect(Collectors.toList());
        return listaTransacao;
    }

    public Estatistica pegarEstatisticas(){

        List<Transacao> listaEstatistica =  ultimasTransacoes(listaTransacao);
        
        List<Double> listaDouble = listaEstatistica.stream().map(x -> x.getValor()).toList();

        DoubleSummaryStatistics stats = listaDouble.stream()
                .mapToDouble(Double::doubleValue)
                .summaryStatistics();

        Estatistica estatistica = new Estatistica(stats.getCount(), stats.getSum(), stats.getAverage(), stats.getMin(), stats.getMax());

        return estatistica;
    }







}
