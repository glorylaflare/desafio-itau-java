package br.com.feltex.desafioitau.service;

import br.com.feltex.desafioitau.dto.TransactionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
@Slf4j
public class TransactionService {

    private final Queue<TransactionDTO> transactions = new ConcurrentLinkedQueue<>();
    long start = System.nanoTime();

    public void createTransaction(TransactionDTO transactionDTO) {
        transactions.add(transactionDTO);

        long end = System.nanoTime();
        log.info("Nova transação adicionada: {}", transactionDTO);
        log.info("Tempo para adicionar a transação: {} ms", (end - start) / 1_000_000);
    }

    public void deleteAll() {
        transactions.clear();
        long end = System.nanoTime();
        log.info("Todas as transações foram removidas.");
        log.info("Tempo para remover todas as transações: {} ms", (end - start) / 1_000_000);
    }

    public DoubleSummaryStatistics getStatistics() {
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        return transactions.stream()
                .filter(t -> t.dataHora().isAfter(offsetDateTime.minusSeconds(60)))
                .mapToDouble(TransactionDTO::valor)
                .summaryStatistics();
    }
}
