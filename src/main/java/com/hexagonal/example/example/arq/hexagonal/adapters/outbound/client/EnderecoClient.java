package com.hexagonal.example.example.arq.hexagonal.adapters.outbound.client;

import com.hexagonal.example.example.arq.hexagonal.application.core.domain.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "buscar-endereco", url = "${app.config.services.via-cep.url}")
public interface EnderecoClient {

    @GetMapping( "{cep}/json")
    ResponseEntity<Endereco> buscar(@PathVariable String cep);

}
