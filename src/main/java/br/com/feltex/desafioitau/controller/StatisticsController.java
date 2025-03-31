package br.com.feltex.desafioitau.controller;

import br.com.feltex.desafioitau.dto.StatisticDTO;
import br.com.feltex.desafioitau.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/estatistica")
public class StatisticsController {

    @Autowired
    TransactionService service;

    //Get
    @GetMapping
    public ResponseEntity<StatisticDTO> getStatistics() {
        DoubleSummaryStatistics statistics = service.getStatistics();
        return ResponseEntity.ok(new StatisticDTO(statistics));
    }
}
