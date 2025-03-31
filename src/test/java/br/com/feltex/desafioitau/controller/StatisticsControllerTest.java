package br.com.feltex.desafioitau.controller;

import br.com.feltex.desafioitau.dto.StatisticDTO;
import br.com.feltex.desafioitau.dto.TransactionDTO;
import br.com.feltex.desafioitau.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatisticsControllerTest {

    private TransactionService service = new TransactionService();
    private StatisticsController controller;


    @BeforeEach
    void setUp() {
        controller = new StatisticsController();
        controller.service = service;
    }

    @Test
    @DisplayName("Deve retornar um status code de 200 e enviar um Json")
    void deveRetornarStatus200EEnviarUmJson() {
        service.createTransaction(new TransactionDTO(100.0, OffsetDateTime.now()));
        service.createTransaction(new TransactionDTO(200.0, OffsetDateTime.now()));
        service.createTransaction(new TransactionDTO(300.0, OffsetDateTime.now()));

        ResponseEntity<StatisticDTO> response = controller.getStatistics();
        assertEquals(HttpStatus.OK, response.getStatusCode());

        StatisticDTO dto = response.getBody();
        DoubleSummaryStatistics stats = dto.statistics();

        assertEquals(3, stats.getCount());
        assertEquals(600.0, stats.getSum());
        assertEquals(200.0, stats.getAverage());
        assertEquals(100.0, stats.getMin());
        assertEquals(300.0, stats.getMax());
    }
}
