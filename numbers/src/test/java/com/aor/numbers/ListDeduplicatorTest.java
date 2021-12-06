package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {
    private List<Integer> helper(List<Integer> l){
//        System.out.println("Testing List: " + Arrays.toString(l.toArray()));
        return l;
    }
    @Test
    public void deduplicate() {
        List<Integer> list = Arrays.asList(1,2,4,2,5);
        List<Integer> expected = Arrays.asList(1,2,4,5);

        GenericListDeduplicator deduplicator = new ListDeduplicator();
        GenericListSorter sorter = new ListSorter();

        List<Integer> distinct = deduplicator.deduplicate(list, sorter );

        Assertions.assertEquals(expected, distinct);
    }

    @Test
    public void deduplicate_2() {
        class Stub implements GenericListSorter{

            @Override
            public List<Integer> sort(List<Integer> list) {
                return Arrays.asList(1,2,2,4);
            }
        }
        List<Integer> list = Arrays.asList(1,2,4,2);
        List<Integer> expected = Arrays.asList(1,2,4);

        ListDeduplicator deduplicator = new ListDeduplicator();
        GenericListSorter sorter = new Stub();

        List<Integer> distinct = deduplicator.deduplicate(list, sorter );

        Assertions.assertEquals(expected, distinct);
    }
}
