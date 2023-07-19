package org.example;

import java.util.*;

public class MyArrayList<E> implements List<E> {
    private E[] arr;
    private int size;

    public MyArrayList() {
        arr = (E[]) new Object[0];
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
        for (E element : arr) {
           if(element.equals(o)) {
               return true;
           }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return (Object[]) arr;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        if(size == arr.length) {
            resize();
        }
        arr[size] = e;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int i = indexOf(o);
        if(i == -1) {
            return false;
        }
        arr = removeHelper(i);
        size--;
        return true;
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
        if(size + c.size() >= arr.length) {
            resize(c.size());
        }
        for(Object o : c) {
            add((E) o);
        }
        size += c.size();
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if(index < 0 || index > arr.length) {
            throw new IndexOutOfBoundsException();
        }
        if(index + c.size() > arr.length) {
            resize(c.size());
        }
        int i = index;
        for(Object o : c) {
            add(i, (E)o);
            i++;
        }
        size += c.size();
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for(Object o : c) {
            if(!remove(o)) {
                return false;
            }
        }
        size -= c.size();
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        arr = (E[]) new Object[0];
        size = 0;
    }

    @Override
    public E get(int index) {
        if(index < 0 || index > arr.length) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    @Override
    public E set(int index, E element) {
        if(index < 0 || index > arr.length) {
            throw new IndexOutOfBoundsException();
        }
        arr[index] = element;
        return element;
    }

    @Override
    public void add(int index, E element) {
        if(index < 0 || index >= arr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (arr[index] != null) {
            arr = addHelper(element, index);
        } else {
            arr[index] = element;
        }
        size++;
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index >= arr.length) {
            throw new IndexOutOfBoundsException();
        }
        E temp = arr[index];
        arr = removeHelper(index);
        size --;
        return temp;
    }

    @Override
    public int indexOf(Object o) {
        if(!contains(o)) {
            return -1;
        }
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    private void resize() {
        arr = Arrays.copyOf(arr, arr.length + 1);
    }

    private void resize(int count) {
        arr = Arrays.copyOf(arr, arr.length + count);
    }

    private E[] removeHelper(int index) {
        E[] array = (E[]) new Object[arr.length - 1];
        int i = 0;
        while(i < arr.length - 1) {
            if(i >= index) {
                array[i] = arr[i + 1];
            } else {
                array[i] = arr[i];
            }
            i++;
        }
        return array;
    }

    private E[] addHelper(E object, int index) {
        E[] array = (E[])new Object[size + 1];
        for (int i = 0; i < size + 1; i++) {
            if (i < index)
                array[i] = arr[i];
            else if (i == index)
                array[i] = object;
            else
                array[i] = arr[i - 1];
            }
            return array;
        }
    }


