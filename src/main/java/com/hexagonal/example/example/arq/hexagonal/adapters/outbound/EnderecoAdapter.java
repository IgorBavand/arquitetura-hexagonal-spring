package com.hexagonal.example.example.arq.hexagonal.adapters.outbound;

import com.hexagonal.example.example.arq.hexagonal.adapters.outbound.client.EnderecoClient;
import com.hexagonal.example.example.arq.hexagonal.application.core.domain.Endereco;
import com.hexagonal.example.example.arq.hexagonal.application.exception.BadRequestException;
import com.hexagonal.example.example.arq.hexagonal.application.ports.out.EnderecoPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EnderecoAdapter implements EnderecoPort {

    private final EnderecoClient enderecoClient;

    @Override
    public Endereco buscar(String cep) {
        try {
            return enderecoClient.buscar(cep).getBody();
        } catch (Exception ex) {
            throw new BadRequestException("O CEP informado é inválido.");
        }
    }
}
