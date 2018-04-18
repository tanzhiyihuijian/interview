package cn.com.dom4j.adt.tree;

import cn.com.dom4j.exception.UnderFlowException;

import java.util.PriorityQueue;

public class BinaryHeap<AnyType extends Comparable<? super AnyType>> {

    public BinaryHeap() {

    }

    public BinaryHeap(int capacity) {

    }

    public BinaryHeap(AnyType[] items) {

    }


    public void insert(AnyType x) {

        if (currentSize == array.length - 1) {
            enlargeArray(array.length * 2 + 1);
        }

        int hole = ++currentSize;

        for (; hole > 1 && x.compareTo(array[hole / 2]) < 0; hole /= 2)
            array[hole] = array[hole / 2];
        array[hole] = x;


    }

    public AnyType findMin() {
        return null;
    }

    public AnyType deleteMin() {

        if (isEmpty())
            throw new UnderFlowException();

        AnyType minItem = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);

        return minItem;
    }

    public boolean isEmpty() {
        return false;
    }

    public void makeEmpty() {

    }


    public static final int DEFAULE_CAPACITY = 10;

    private int currentSize;
    private AnyType[] array;

    private void percolateDown(int hole) {

        int child = 0;
        AnyType tmp = array[hole];

        for ( ; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            if (child != currentSize && array[child + 1].compareTo(array[child]) < 0) {
                child++;
            }
            if (array[child].compareTo(tmp) < 0) {
                array[hole] = array[child];
            } else {
                break;
            }
        }
        array[hole] = tmp;
    }

    private void buildHeap(AnyType[] items) {

        currentSize = items.length;
        array = (AnyType[]) new Comparable[(currentSize + 2) * 11 / 10];

        int i = 1;
        for (AnyType item : items) {
            array[i++] = item;
        }

        buildHeap();
    }

    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--) {
            percolateDown(i);
        }
    }

    private void enlargeArray(int newSize) {
        if (newSize < currentSize)
            return;

        AnyType[] old = array;

        array = (AnyType[]) new Object[newSize];

        System.arraycopy(old, 0, array, 0, old.length);
    }


}
