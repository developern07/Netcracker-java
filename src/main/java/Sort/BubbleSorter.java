package Sort;

import Contracts.Contract;

import java.util.Comparator;

public class BubbleSorter implements ISorter{
    protected <T extends Contract> void swap(T[] element, int i, int j){
        T tmp = element[i];
        element[i]=element[j];
        element[j]=tmp;
    }
    public <T extends Contract> T[] sort(T[] elements, Comparator<T> cmp) {
        for (int i = 0; i < elements.length - 1; ++i) {
            for (int j = elements.length - 1; j > i; --j) {
                if (cmp.compare(elements[j-1], elements[j]) > 0) {
                    swap(elements, j-1, j);
                }
            }
        }
        return elements;
    }
}
