package ru.geekbrains.course23;

public class RecSortedArrayImpl<E extends Object & Comparable<? super E>> extends SortedArrayImpl<E> {

    public static void main(String[] args) {
        Array<Integer> array = new SortedArrayImpl<>();
        array.add(20);
        array.add(10);
        array.add(70);

        if (!array.contains(10)) throw new AssertionError();
        if (!array.contains(20)) throw new AssertionError();
        if (!array.contains(70)) throw new AssertionError();

        if (array.indexOf(10) != 0) throw new AssertionError();
        if (array.indexOf(20) != 1) throw new AssertionError();
        if (array.indexOf(70) != 2) throw new AssertionError();
    }

    @Override
    public int indexOf(E value) {
        int low = 0;
        int high = currentSize - 1;
        return recBinaryFind(value, low, high);
    }

    private int recBinaryFind(E value, int low, int high) {
        int mid = (low + high) / 2;

        if (low > high) {
            return -1;
        }

        if ( data[mid].equals(value) ) {
            return mid;
        }

        if ( value.compareTo(data[mid]) > 0 ) {
            return recBinaryFind(value, mid+1, high);
        }
        else {
            return recBinaryFind(value, low, mid - 1);
        }
    }
}
