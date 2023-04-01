package com.hexagonal.example.example.arq.hexagonal.application.ports.in;

import com.hexagonal.example.example.arq.hexagonal.application.core.domain.Endereco;
import com.hexagonal.example.example.arq.hexagonal.application.core.domain.EnderecoFrete;

public interface EnderecoServicePort {

    Endereco buscarEndereco(String endereco);
    EnderecoFrete calcularFrete(String endereco);
}
