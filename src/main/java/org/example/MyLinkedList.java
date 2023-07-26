package org.example;

import java.util.*;

public class MyLinkedList<E> implements List<E> {

    class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> prev;

        public Node(Node<E> prev, E data, Node<E> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        public E getData() {
            return data;
        }
        public void setNext(Node<E> next) {
            this.next = next;
        }
        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }

    private int size;
    private Node<E> head;
    private Node<E> tail;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node<E> temp = head;
        while(temp != null) {
            if(temp.data.equals(o)){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyListIterator(0);
    }

    @Override
    public Object[] toArray() {
        if(isEmpty()) {
            throw new IllegalStateException();
        }
        E[] arr = (E[]) new Object[size];
        Node<E> temp = head;
        int i = 0;
        while(temp != null) {
            arr[i] = temp.data;
            temp = temp.next;
            i++;
        }
        return arr;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if(isEmpty()) {
            throw new IllegalStateException();
        }
        int index = indexOf(o);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for(Object o : c) {
            if(!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return addAll(size, c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if(index == size) {
            for(E element : c) {
                addLast(element);
            }
        } else {
            Node<E> pred = getNode(index - 1);
            Node<E> succ = pred.next;
            for (E element : c) {
                addBetween(element, pred, succ);
                pred = pred.next;
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if(isEmpty() || size < c.size()) return false;
        for(Object object : c) {
            if(!contains(object)){
                continue;
            }
            if(!remove(object)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        return getNode(index).getData();
    }

    @Override
    public E set(int index, E element) {

        Node<E> temp = getNode(index);
        E oldData = temp.data;
        temp.data = element;
        return oldData;
    }



    @Override
    public void add(int index, E element) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if(index == 0) {
            addFirst(element);
        } else if(index == size) {
            addLast(element);
        } else {
            Node<E> temp = getNode(index);
            addBetween(element, temp.prev, temp);
        }
    }

    @Override
    public E remove(int index) {
        if(isEmpty()) {
            throw new  IllegalStateException();
        }
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if(index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            return removeBetween(getNode(index).prev, getNode(index).next);
        }
    }

    private E removeFirst() {
        Node<E> temp = head;
        if(size == 1){
            clear();
        } else {
            head.next.setPrev(null);
            head = head.next;
            size--;
        }
        return temp.data;
    }

    private E removeLast() {
        Node<E> temp = tail;
        if(size == 1) {
            clear();
        } else {
            temp.prev.setNext(null);
            tail = tail.prev;
            size--;
        }
        return temp.data;
    }

    private E removeBetween(Node<E> pred, Node<E> succ) {
        E temp = pred.next.data;
        pred.setNext(succ);
        succ.setPrev(pred);
        size--;
        return temp;
    }

    @Override
    public int indexOf(Object o) {
        if(isEmpty()) {
            return -1;
        }
        Node<E> temp = head;
        int i = 0;
        while(temp != null) {
            if(temp.getData().equals(o)) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if(!contains(o)) {
            return -1;
        }
        Node<E> temp = tail;
        for(int i = size - 1; i >= 0; i--) {
            if(temp.getData().equals(o)) {
                return i;
            }
            temp = temp.prev;
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new MyListIterator(0);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new MyListIterator(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size) {
            throw new IndexOutOfBoundsException();
        }
        if(fromIndex > toIndex) {
            throw new IllegalArgumentException();
        }
        MyLinkedList<E> list = new MyLinkedList<>();
        Node<E> temp = getNode(fromIndex);
        for(int i = fromIndex; i < toIndex; i++) {
            list.add(temp.data);
            temp = temp.next;
        }
        return list;
    }

    void addFirst(E e) {
        Node<E> temp = head;
        Node<E> newNode = new Node<>(null, e, temp);
        if(isEmpty()) {
            head = tail = newNode;
        } else {
            head = newNode;
        }
        size++;
    }

    void addLast(E element) {
        Node<E> newNode = new Node<>(tail, element, null);
        if (isEmpty()) {
            addFirst(element);
        } else {
            tail.setNext(newNode);
            tail = newNode;
            size++;
        }

    }

    private void addBetween(E element, Node<E> pred, Node<E> succ) {
        Node<E> newNode = new Node<>(pred, element, succ);
        pred.setNext(newNode);
        succ.setPrev(newNode);
        size++;
    }

    private Node<E> getNode(int index) {
        if(index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        if(isEmpty()) {
            throw new IllegalStateException();
        }
        Node<E> temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    private class MyListIterator implements ListIterator<E> {
        private Node<E> lastReturned;
        private Node<E> current;
        private int cursor;

        MyListIterator(int index) {
            current = (index == size) ? null : getNode(index);
            cursor = index;
            lastReturned = null;
        }

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastReturned = current;
            current = current.next;
            cursor++;
            return lastReturned.data;
        }

        @Override
        public boolean hasPrevious() {
            return cursor > 0;
        }

        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            if (current == null) {
                current = tail;
            } else {
                current = current.prev;
            }
            lastReturned = current;
            cursor--;
            return lastReturned.data;
        }

        @Override
        public int nextIndex() {
            return cursor;
        }

        @Override
        public int previousIndex() {
            return cursor - 1;
        }

        @Override
        public void remove() {
            if (lastReturned == null) {
                throw new IllegalStateException();
            }
            Node<E> lastNext = lastReturned.next;
            Node<E> lastPrev = lastReturned.prev;

            if (lastPrev == null) {
                head = lastNext;
            } else {
                lastPrev.next = lastNext;
                lastReturned.prev = null;
            }

            if (lastNext == null) {
                tail = lastPrev;
            } else {
                lastNext.prev = lastPrev;
                lastReturned.next = null;
            }

            if (current == lastReturned) {
                current = lastNext;
            } else {
                cursor--;
            }

            lastReturned = null;
            size--;
        }

        @Override
        public void set(E e) {
            if (lastReturned == null) {
                throw new IllegalStateException();
            }
            lastReturned.data = e;
        }

        @Override
        public void add(E e) {
            Node<E> pred, succ;
            if (current == null) {
                pred = tail;
                succ = null;
            } else {
                pred = current.prev;
                succ = current;
            }

            Node<E> newNode = new Node<>(pred, e, succ);

            if (pred == null) {
                head = newNode;
            } else {
                pred.next = newNode;
            }

            if (succ == null) {
                tail = newNode;
            } else {
                succ.prev = newNode;
            }

            current = newNode;
            lastReturned = null;
            size++;
            cursor++;
        }
    }
}