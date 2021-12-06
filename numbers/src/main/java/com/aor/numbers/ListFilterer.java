package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer {
    GenericListFilter fil;
    public ListFilterer(GenericListFilter filter){
        this.fil = filter;
    }

    public List<Integer> filter(List<Integer> list){
        List<Integer> res = new ArrayList<>();
        for (Integer num: list){
             if (fil.accept(num)) res.add(num);
        }
        return res;
    }

}
