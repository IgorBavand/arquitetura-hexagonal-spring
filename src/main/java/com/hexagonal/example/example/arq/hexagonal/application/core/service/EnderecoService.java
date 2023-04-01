package com.hexagonal.example.example.arq.hexagonal.application.core.service;

import com.hexagonal.example.example.arq.hexagonal.application.core.domain.Endereco;
import com.hexagonal.example.example.arq.hexagonal.application.core.domain.EnderecoFrete;
import com.hexagonal.example.example.arq.hexagonal.application.ports.in.EnderecoServicePort;
import com.hexagonal.example.example.arq.hexagonal.application.ports.out.EnderecoPort;

import static com.hexagonal.example.example.arq.hexagonal.application.core.domain.constants.RegioesConstants.*;

public class EnderecoService implements EnderecoServicePort {

    private final EnderecoPort enderecoPort;

    public EnderecoService(EnderecoPort enderecoPort) {
        this.enderecoPort = enderecoPort;
    }

    @Override
    public Endereco buscarEndereco(String cep) {
        return enderecoPort.buscar(cep);
    }

    @Override
    public EnderecoFrete calcularFrete(String cep) {
        var informacoes = enderecoPort.buscar(cep);

        var enderecoFrete = EnderecoFrete.of(informacoes);

        if (NORDESTE.stream().anyMatch(regiao -> regiao.equals(informacoes.getUf()))) {
            enderecoFrete.setFrete(VALOR_FRETE_NORDESTE);
        } else if (NORTE.stream().anyMatch(regiao -> regiao.equals(informacoes.getUf()))) {
            enderecoFrete.setFrete(VALOR_FRETE_NORTE);
        }else if (CENTRO_OESTE.stream().anyMatch(regiao -> regiao.equals(informacoes.getUf()))) {
            enderecoFrete.setFrete(VALOR_FRETE_CENTRO_OESTE);
        } else if (SUDESTE.stream().anyMatch(regiao -> regiao.equals(informacoes.getUf()))) {
            enderecoFrete.setFrete(VALOR_FRETE_SUDESTE);
        } else if (SUL.stream().anyMatch(regiao -> regiao.equals(informacoes.getUf()))) {
            enderecoFrete.setFrete(VALOR_FRETE_SUL);
        }

        return enderecoFrete;
    }
}
