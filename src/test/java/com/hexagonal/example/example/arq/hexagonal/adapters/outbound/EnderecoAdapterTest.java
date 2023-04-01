package com.hexagonal.example.example.arq.hexagonal.adapters.outbound;

import com.hexagonal.example.example.arq.hexagonal.adapters.outbound.client.EnderecoClient;
import com.hexagonal.example.example.arq.hexagonal.application.core.domain.Endereco;
import com.hexagonal.example.example.arq.hexagonal.application.exception.BadRequestException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EnderecoAdapterTest {

    @InjectMocks
    private EnderecoAdapter enderecoAdapter;

    @Mock
    private EnderecoClient enderecoClient;

    @Test
    void buscar_deveBuscarEnderecoComCepNaoFormatado_quandoSolicitado() {
        var cep = "62960000";

        when(enderecoClient.buscar(cep))
                .thenReturn(ResponseEntity.ok(umEndereco()));

        assertThat(enderecoAdapter.buscar(cep)).extracting("bairro", "cep", "localidade")
                .containsExactly("bairro teste", "62960000", "tabuleiro do norte");

        verify(enderecoClient, times(1)).buscar(cep);
    }

    @Test
    void buscar_deveBuscarEnderecoComCepFormatado_quandoSolicitado() {
        var cep = "62960000";

        when(enderecoClient.buscar(cep))
                .thenReturn(ResponseEntity.ok(umEndereco()));

        assertThat(enderecoAdapter.buscar(cep)).extracting("bairro", "cep", "localidade")
                .containsExactly("bairro teste", "62960000", "tabuleiro do norte");

        verify(enderecoClient, times(1)).buscar(cep);
    }

    @Test
    void buscar_deveLAncarBadRequest_quandoCepInvalido() {
        var cep = "ab122003";

        assertThatThrownBy(() ->enderecoAdapter.buscar(cep))
                .isInstanceOf(BadRequestException.class)
                .hasMessage("O CEP informado é inválido.");

        verify(enderecoClient, times(1)).buscar(cep);
    }

    private static Endereco umEndereco() {
        var endereco = new Endereco();
        endereco.setBairro("bairro teste");
        endereco.setCep("62960000");
        endereco.setLocalidade("tabuleiro do norte");
        return endereco;
    }
}
