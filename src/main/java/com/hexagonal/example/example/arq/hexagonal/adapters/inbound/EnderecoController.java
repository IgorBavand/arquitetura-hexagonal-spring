package com.hexagonal.example.example.arq.hexagonal.adapters.inbound;

import com.hexagonal.example.example.arq.hexagonal.application.core.domain.Endereco;
import com.hexagonal.example.example.arq.hexagonal.application.core.domain.EnderecoFrete;
import com.hexagonal.example.example.arq.hexagonal.application.ports.in.EnderecoServicePort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/consulta-endereco")
@AllArgsConstructor
public class EnderecoController {

    private final EnderecoServicePort enderecoServicePort;

    @GetMapping("{cep}")
    public Endereco buscarEndereco(@PathVariable String cep) {
        return enderecoServicePort.buscarEndereco(cep);
    }

    @GetMapping("{cep}/calcular-frete")
    public EnderecoFrete calcularFrete(@PathVariable String cep) {
        return enderecoServicePort.calcularFrete(cep);
    }
}
