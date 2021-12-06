package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

public class ListAggregatorTest {

    private List<Integer> helper(){
        return Arrays.asList(1,2,4,2,5);
    }

    @Test
    public void sum() {
        List<Integer>list = helper();
        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {

        List<Integer> list = helper();
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }

    @Test
    public void max_bug_7263() {
        List<Integer> list = Arrays.asList(-1,-4,-4,-5);
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(-1, max);
    }

    @Test
    public void min() {
        List<Integer>list =helper();
        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        List<Integer>list = helper();
        ListAggregator aggregator = new ListAggregator();
        GenericListDeduplicator ldd = new ListDeduplicator();

//        int distinct = aggregator.distinct(list, ldd);
        int distinct;

        distinct = aggregator.distinct(list, ldd);

        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void distinct_bug_8726() {
//        class Stub implements GenericListDeduplicator {
//            @Override
//            public List<Integer> deduplicate(List<Integer> list, GenericListSorter listSorter) {
//                return Arrays.asList(1,2,4);
//            }
//        }
//
//        GenericListSorter gls = new ListSorter();
//        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
//        Mockito.when(deduplicator.deduplicate(Mockito.anyList(), any()) ).thenReturn(Arrays.asList(1, 2, 4));
//
//
//        List<Integer> list = Arrays.asList(1,2,4,2);
//        ListAggregator aggregator = new ListAggregator();
//        GenericListDeduplicator ldd = new Stub();
//
//        int distinct;
//        distinct = aggregator.distinct(list, deduplicator);

//        Assertions.assertEquals(3, distinct);



        ListAggregator aggregator = new ListAggregator();
        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(Mockito.anyList(), any())).thenReturn(Arrays.asList(1, 2, 4));
        int distinct = aggregator.distinct(Arrays.asList(1, 2, 4, 2),
                deduplicator);
        Assertions.assertEquals(3, distinct);



    }
}

