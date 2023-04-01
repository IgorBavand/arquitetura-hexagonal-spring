package com.hexagonal.example.example.arq.hexagonal.config;

import com.hexagonal.example.example.arq.hexagonal.adapters.outbound.EnderecoAdapter;
import com.hexagonal.example.example.arq.hexagonal.application.core.service.EnderecoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public EnderecoService enderecoService(EnderecoAdapter enderecoAdapter){
        return new EnderecoService(enderecoAdapter);
    }

}
