package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter {
    private Integer num;
    public DivisibleByFilter(Integer num){
        this.num = num;
    }

    @Override
    public boolean accept(Integer number) {
        return number % num == 0;
    }
}
