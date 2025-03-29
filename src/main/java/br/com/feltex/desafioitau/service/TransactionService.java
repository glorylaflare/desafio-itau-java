package br.com.feltex.desafioitau.service;

import br.com.feltex.desafioitau.dto.TransactionDTO;
import br.com.feltex.desafioitau.entity.Transaction;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
@Slf4j
public class TransactionService {

    private final Queue<TransactionDTO> transactions = new ConcurrentLinkedQueue<>();

    public void createTransaction(TransactionDTO transactionDTO) {
        transactions.add(transactionDTO);
        log.info("Nova transação adicionada: {}", transactionDTO);
    }

    public void deleteAll() {
        transactions.clear();
        log.info("Todas as transações foram removidas.");
    }
}
