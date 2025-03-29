package br.com.feltex.desafioitau.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Statistic {

    private final long count;
    private final double sum;
    private final double avg;
    private final double min;
    private final double max;
}
