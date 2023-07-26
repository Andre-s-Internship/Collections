package org.example;

public class MyPriorityQueue<E extends Comparable<E>> extends MyArrayList<E> {

    MyPriorityQueue() {
        super();
    }

    public int size() {
        return super.size();
    }
    public boolean isEmpty() {
        return super.isEmpty();
    }


    public boolean add(E element) {
        super.add(element);
        heapifyUp(size() - 1);
        return true;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return super.get(0);
    }

    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E root = super.get(0);
        E lastElement = super.remove(size() - 1);
        if (!isEmpty()) {
            super.set(0, lastElement);
            heapifyDown(0);
        }
        return root;
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && super.get(index).compareTo(super.get(parentIndex)) < 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallest = index;

        if (leftChild < super.size() && super.get(leftChild).compareTo(super.get(smallest)) < 0) {
            smallest = leftChild;
        }
        if (rightChild < super.size() && super.get(rightChild).compareTo(super.get(smallest)) < 0) {
            smallest = rightChild;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        E temp = super.get(i);
        super.set(i, super.get(j));
        super.set(j, temp);
    }

}
