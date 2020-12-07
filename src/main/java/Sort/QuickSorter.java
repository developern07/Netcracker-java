package Sort;

import Contracts.Contract;

import java.util.Comparator;
import java.util.Random;

public class QuickSorter implements ISorter{
    private static final Random RND = new Random();

    private <T extends Contract> void swap(T[] element, int i, int j) {
        T tmp = element[i];
        element[i] = element[j];
        element[j] = tmp;
    }
    private <T extends Contract> int partition(T[] element, int begin, int end, Comparator<T> cmp) {
        int index = begin + RND.nextInt(end - begin + 1);
        T pivot = element[index];
        swap(element, index, end);
        for (int i = index = begin; i < end; ++ i) {
            if (cmp.compare(element[i], pivot) <= 0) {
                swap(element, index++, i);
            }
        }
        swap(element, index, end);
        return (index);
    }
    private <T extends Contract> void qsort(T[] element, int begin, int end, Comparator<T> cmp) {
        if (end > begin) {
            int index = partition(element, begin, end, cmp);
            qsort(element, begin, index - 1, cmp);
            qsort(element, index + 1,  end,  cmp);
        }
    }
    @Override
    public <T extends Contract> T[] sort(T[] element, Comparator<T> cmp) {
        qsort(element, 0, element.length - 1, cmp);
        return element;
    }
}
