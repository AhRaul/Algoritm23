package ru.geekbrains.course23;

public class SortedArrayImpl<E extends Object & Comparable<? super E>> extends ArrayImpl<E> {

    @Override
    //O(N)
    public void add(E value) {
        checkGrow();

        int index;
        for (index = 0; index < size(); index++) {
            if (data[index].compareTo(value) > 0) {
                break;
            }
        }

        for (int i = currentSize; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = value;
        currentSize++;
    }

    @Override
    //O(logN)
    public int indexOf(E value) {
        int low = 0;
        int high = currentSize - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if ( data[mid].equals(value) ) {
                return mid;
            }

            if ( value.compareTo(data[mid]) > 0 ) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
