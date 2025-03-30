package br.com.feltex.desafioitau.controller;

import br.com.feltex.desafioitau.dto.TransactionDTO;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionControllerTest {

    private TransactionController controller = new TransactionController();

    @Test
    void retornarStatus201AposCriarTransacao() {
        TransactionDTO dto = new TransactionDTO(100.0, OffsetDateTime.now());

        ResponseEntity<Void> response = controller.createTranstion(dto);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void retornarStatus422QuandoTransacaoForInconsistente() {
        TransactionDTO dto = new TransactionDTO(-100.0, OffsetDateTime.now());

        ResponseEntity<Void> response = controller.createTranstion(dto);
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
    }

    @Test
    void retornarStatus200AposDeletarTodasAsTransacoesEmMemoria() {
        ResponseEntity<Void> response = controller.deleteAll();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
