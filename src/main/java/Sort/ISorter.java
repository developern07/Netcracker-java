package Sort;

import Contracts.Contract;

import java.util.Comparator;

/**
 * Sorter interface
 */
public interface ISorter {
    public <T extends Contract> T[] sort(T[] element, Comparator<T> cmp);
}
