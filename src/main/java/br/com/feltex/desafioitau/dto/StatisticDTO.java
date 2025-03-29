package br.com.feltex.desafioitau.dto;

public record StatisticDTO(
        Long count,
        Double sum,
        Double avg,
        Double min,
        Double max) {
}
