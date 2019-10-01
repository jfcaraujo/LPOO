package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListAggregatorTest {
    @Test
    public void sum() {
        /*List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);*/

        ListAggregator aggregator = new ListAggregator(helper());

        int sum = aggregator.sum();

        assertEquals(14, sum);
    }

    @Test
    public void max() {
        /*List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);*/

        ListAggregator aggregator = new ListAggregator(helper());

        int max = aggregator.max();

        assertEquals(5, max);
    }

    @Test
    public void min() {
        /*List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);*/

        ListAggregator aggregator = new ListAggregator(helper());

        int min = aggregator.min();

        assertEquals(1, min);
    }

    @Test
    public void distinct() {
        /*List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);*/

        ListAggregator aggregator = new ListAggregator(helper());

        int distinct = aggregator.distinct(new ListDeduplicator(helper()));

        assertEquals(4, distinct);
    }

    private List<Integer> helper(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
        return list;
    }

    @Test
    public void maxForBug4() {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(-4);
        list.add(-5);

        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        assertEquals(-1, max);
    }

    @Test
    public void distinctForBug5() {

        class innerClass implements IListDeduplicator{
            public List<Integer> deduplicate(IListSorter sorter){
                List<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(2);
                list.add(4);
                return list;
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);

        ListAggregator aggregator = new ListAggregator(list);

        int distinct = aggregator.distinct(new innerClass());

        assertEquals(3, distinct);
    }

}