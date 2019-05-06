package ru.geekbrains.course23;

import java.util.Arrays;

public class ArrayImpl<E extends Object & Comparable<? super E>> implements Array<E> {

    static final int DEFAULT_CAPACITY = 8;

    E[] data;
    protected int currentSize;


    public ArrayImpl() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayImpl(int initialCapacity) {
        this.data = (E[]) new Object[initialCapacity];
    }

    @Override
    //O(N)
    public void add(E value) {
        checkGrow();
        //O(1)
        data[currentSize++] = value;
    }

    protected void checkGrow() {
        if (isFull(data.length)) {
            growArray();
        }
    }

    private void growArray() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    private boolean isFull(int length) {
        return currentSize == length;
    }

    @Override
    public boolean remove(E value) {
        int index = indexOf(value);
        if (index == -1) {
            return false;
        }

        remove(indexOf(value));
        return true;
    }

    @Override
    //O(N)
    public void remove(int index) {
        checkIndex(index);

        for (int i = index; i < currentSize - 1; i++) {
            data[i] = data[i + 1];
        }

        currentSize--;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= currentSize) {
            throw new IllegalArgumentException("Invalid index " + index + ", max value is " + (currentSize - 1));
        }
    }

    @Override
    //O(1)
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) != -1;
    }

    @Override
    //O(N)
    public int indexOf(E value) {
        for (int i = 0; i < size(); i++) {
            if (data[i].equals(value))
                return i;
        }
        return -1;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            sb.append(data[i]);
            sb.append(", ");
        }

        int lastCommaIndex = sb.lastIndexOf(", ");
        if (lastCommaIndex != -1) {
            sb.replace(lastCommaIndex, lastCommaIndex + 2, "");
        }


        return sb.toString();

//        return Stream.of(data).map(String::valueOf).collect(Collectors.joining(", "));
    }

    @Override
    //O(N^2)
    public void sortBubble() {
        for (int i = 0; i < currentSize - 1; i++) {
            for (int j = 0; j < currentSize - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(j, j + 1);
                }
            }
        }
    }

    @Override
    public void sortSelect() {
        for (int i = 0; i < currentSize - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < currentSize; j++) {
                if (data[j].compareTo(data[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            if (i != minIndex) {
                swap(i, minIndex);
            }
        }
    }

    @Override
    public void sortInsert() {
        for (int i = 1; i < currentSize; i++) {
            E temp = data[i];

            int in = i;
            while (in > 0 && data[in - 1].compareTo(temp) >= 0) {
                data[in] = data[in - 1];
                in--;
            }

            data[in] = temp;
        }
    }

    private void swap(int index1, int index2) {
        E temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
}
