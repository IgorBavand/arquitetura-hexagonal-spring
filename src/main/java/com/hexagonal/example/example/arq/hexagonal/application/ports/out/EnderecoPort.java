package com.hexagonal.example.example.arq.hexagonal.application.ports.out;

import com.hexagonal.example.example.arq.hexagonal.application.core.domain.Endereco;

public interface EnderecoPort {
    Endereco buscar(String cep);
}
