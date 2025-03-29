package br.com.feltex.desafioitau.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.OffsetDateTime;

public record TransactionDTO(
        @NotNull(message = "A propriedade valor não pode ser nula")
        Double valor,
        @NotNull(message = "A propriedade dataHora não pode ser nula")
        OffsetDateTime dataHora) {
}
