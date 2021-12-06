package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {

    @Test
    public void posFilter() {

        GenericListFilter fil = Mockito.mock(GenericListFilter.class);

        Mockito.when(fil.accept(-1)).thenReturn(false);
        Mockito.when(fil.accept(-2)).thenReturn(false);
        Mockito.when(fil.accept(-3)).thenReturn(false);
        Mockito.when(fil.accept(0)).thenReturn(false);
        Mockito.when(fil.accept(4)).thenReturn(true);
        Mockito.when(fil.accept(5)).thenReturn(true);






        PositiveFilter posFil = new PositiveFilter();
        ListFilterer lf = new ListFilterer(posFil);
        List<Integer> list = Arrays.asList(-1,-2,-3,4,5,0);


        List<Integer> res = lf.filter(list);

        Assertions.assertEquals(Arrays.asList(4,5), res);

    }

    @Test
    public void divFilter() {
        DivisibleByFilter divFil = new DivisibleByFilter(3);
        ListFilterer lf = new ListFilterer(divFil);
        List<Integer> list = Arrays.asList(-1,-2,-3,4,5,0, 6,9);

//        GenericListFilter fil = Mockito.mock(GenericListFilter.class);
//        Mockito.when(fil.accept(Mockito.anyInteger())).thenReturn(Arrays.asList(1, 2, 4));

        List<Integer> res = lf.filter(list);

        Assertions.assertEquals(Arrays.asList(-3,0,6,9), res);
    }
}
