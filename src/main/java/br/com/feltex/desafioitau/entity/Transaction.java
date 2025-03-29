package br.com.feltex.desafioitau.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Getter
public class Transaction {

    private final double valor;
    private final OffsetDateTime dataHora;
}
