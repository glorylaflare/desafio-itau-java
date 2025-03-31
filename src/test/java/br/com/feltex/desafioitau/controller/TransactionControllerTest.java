package br.com.feltex.desafioitau.controller;

import br.com.feltex.desafioitau.dto.TransactionDTO;
import br.com.feltex.desafioitau.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionControllerTest {

    private TransactionController controller;

    @BeforeEach
    void setUp() {
        controller = new TransactionController();
    }

    @Test
    @DisplayName("Deve retornar status code 201 após criar uma transação")
    void retornarStatus201AposCriarTransacao() {
        TransactionDTO dto = new TransactionDTO(100.0, OffsetDateTime.now());

        ResponseEntity<Void> response = controller.createTranstion(dto);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    @DisplayName("Deve retornar status code 422 quando uma transação for inconsistente")
    void retornarStatus422QuandoTransacaoForInconsistente() {
        TransactionDTO dto = new TransactionDTO(-100.0, OffsetDateTime.now());

        ResponseEntity<Void> response = controller.createTranstion(dto);
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
    }

    @Test
    @DisplayName("Deve retornar um status code 200 após deletar todas as transações em memória")
    void retornarStatus200AposDeletarTodasAsTransacoesEmMemoria() {
        ResponseEntity<Void> response = controller.deleteAll();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
