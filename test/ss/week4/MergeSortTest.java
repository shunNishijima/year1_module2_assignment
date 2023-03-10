package test.ss.week4;

import org.junit.jupiter.api.Test;
import ss.week4.MergeSort;

import static java.util.Collections.shuffle;
import static java.util.Collections.sort;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.*;


public class MergeSortTest {
    @Test
    public void testMergesortEmptyList() {
        List<Integer> sequence = new ArrayList<>(Collections.emptyList());
        List<Integer> result = MergeSort.mergeSort(sequence);
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testMergesortSingleItem() {
        List<Integer> sequence = new ArrayList<>(Arrays.asList(1));
        List<Integer> result = MergeSort.mergeSort(sequence);
        assertEquals(Arrays.asList(1), result);
    }

    @Test
    public void testMergesortSortedList() {
        List<Integer> sequence = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> result = MergeSort.mergeSort(sequence);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), result);

        sequence = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        result = MergeSort.mergeSort(sequence);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), result);
    }

    @Test
    public void testMergesortUnsortedList() {
        List<Integer> sequence = new ArrayList<>(Arrays.asList(3, 2, 1, 5, 4));
        List<Integer> result = MergeSort.mergeSort(sequence);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), result);

        sequence = new ArrayList<>(Arrays.asList(3, 2, 1, 6, 5, 4));
        result = MergeSort.mergeSort(sequence);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), result);
    }
    @Test
    public void CollectionAndMergesort(){
        List<Integer> randomlist = new ArrayList<>();
        for(int i=0;i<20000;i++){
            Random random = new Random();
            shuffle(randomlist,random);
        }
        List<Integer> result = MergeSort.mergeSort(randomlist);
        sort(randomlist);
        assertEquals(randomlist,result);
}
}
