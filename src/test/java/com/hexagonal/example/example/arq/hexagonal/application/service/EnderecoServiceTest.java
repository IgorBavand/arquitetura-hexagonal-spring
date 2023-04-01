package com.hexagonal.example.example.arq.hexagonal.application.service;

import com.hexagonal.example.example.arq.hexagonal.application.core.domain.Endereco;
import com.hexagonal.example.example.arq.hexagonal.application.core.domain.constants.RegioesConstants;
import com.hexagonal.example.example.arq.hexagonal.application.core.service.EnderecoService;
import com.hexagonal.example.example.arq.hexagonal.application.ports.out.EnderecoPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EnderecoServiceTest {

    @InjectMocks
    private EnderecoService enderecoService;

    @Mock
    private EnderecoPort enderecoPort;

    @Test
    void calcularFrete_deveCalcularFrete_quandoSolicitado() {
        var cepNordeste = "62960000";
        var cepNorte = "12345444";
        var cepCentoOente = "62960002";
        var cepSudeste = "62960003";
        var cepSul = "62960004";

        when(enderecoPort.buscar(cepNordeste)).thenReturn(umEnderecoGenerico("CE"));
        when(enderecoPort.buscar(cepNorte)).thenReturn(umEnderecoGenerico("PA"));
        when(enderecoPort.buscar(cepCentoOente)).thenReturn(umEnderecoGenerico("MT"));
        when(enderecoPort.buscar(cepSudeste)).thenReturn(umEnderecoGenerico("SP"));
        when(enderecoPort.buscar(cepSul)).thenReturn(umEnderecoGenerico("PR"));

        assertEquals(enderecoService.calcularFrete(cepNordeste).getFrete(), RegioesConstants.VALOR_FRETE_NORDESTE);
        assertEquals(enderecoService.calcularFrete(cepNorte).getFrete(), RegioesConstants.VALOR_FRETE_NORTE);
        assertEquals(enderecoService.calcularFrete(cepCentoOente).getFrete(), RegioesConstants.VALOR_FRETE_CENTRO_OESTE);
        assertEquals(enderecoService.calcularFrete(cepSudeste).getFrete(), RegioesConstants.VALOR_FRETE_SUDESTE);
        assertEquals(enderecoService.calcularFrete(cepSul).getFrete(), RegioesConstants.VALOR_FRETE_SUL);

        verify(enderecoPort, times(5)).buscar(anyString());
    }

    private static Endereco umEnderecoGenerico(String uf) {
        var endereco = new Endereco();
        endereco.setBairro("bairro teste");
        endereco.setCep("62960000");
        endereco.setUf(uf);
        endereco.setLocalidade("tabuleiro do norte");
        return endereco;
    }
}
