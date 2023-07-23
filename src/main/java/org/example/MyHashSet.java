package org.example;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MyHashSet<E> implements Set<E> {

    private MyArrayList<MyLinkedList<E>> hashtable;
    private final int CAPACITY = 10;
    private int size;

    public MyHashSet() {
        hashtable = new MyArrayList<MyLinkedList<E>>(CAPACITY);
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
    public boolean contains(Object element) {
        int hash = element.hashCode();
        int index = Math.abs((hash) % CAPACITY);
        MyLinkedList<E> target = hashtable.get(index);
        if(target == null || target.isEmpty()) return false;
        return target.contains(element);
    }

    @Override
    public Iterator<E> iterator() {
        return new MySetIterator<>();
    }

    @Override
    public Object[] toArray() {
        MyLinkedList<Object> myLinkedList = new MyLinkedList<>();
        for(int i = 0; i < CAPACITY; i++){
            if(hashtable.get(i) == null) continue;
            if(!hashtable.get(i).isEmpty()) {
                myLinkedList.addAll(hashtable.get(i));
            }
        }

        return myLinkedList.toArray();
    }

    @Override
    public boolean add(E element) {
        if(contains(element)) return false;
        int hash = element.hashCode();
        int index = Math.abs((hash) % CAPACITY);
        MyLinkedList<E> target;
        if(hashtable.get(index) == null){
            target = new MyLinkedList<>();
            hashtable.add(index, target);
        } else {
            target = hashtable.get(index);
        }
        target.addLast(element);
        size++;
        return true;
    }

    @Override
    public boolean remove(Object element) {
        if(!contains(element)) return false;
        int hash = element.hashCode();
        int index = (hash) % CAPACITY;
        MyLinkedList<E> target = hashtable.get(index);
        boolean removed = target.remove(element);
        if (removed) {
            size--;
        }
        return removed;
    }

    @Override
    public boolean addAll(Collection c) {
        if(containsAll(c)) return false;
        for(Object element : c) {
            add((E) element);
        }
        return true;
    }

    @Override
    public void clear() {
        hashtable.clear();
        size = 0;
    }

    public boolean removeAll(Collection c) {
        for(Object element : c) {
            if(!remove(element)) return false;
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        for(Object element : c) {
            if(!contains(element)) return false;
        }
        return true;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    boolean equalSets(Set<E> HashSet) {
        return containsAll(HashSet) && HashSet.containsAll(this);
    }


    class MySetIterator<T> implements Iterator<E> {

        MyLinkedList<E> list = new MyLinkedList<>();
        Iterator<E> listIterator;

        public MySetIterator(){
            fillList();
            listIterator = list.iterator();
        }

        @Override
        public boolean hasNext() {
            return listIterator.hasNext();
        }

        @Override
        public E next() {
            return listIterator.next();
        }

        private void fillList(){
            for(int i = 0; i < CAPACITY; i++){
                if(hashtable.get(i) != null){
                    if (!hashtable.get(i).isEmpty()) {
                        Iterator<E> bucketList = (Iterator<E>) hashtable.get(i).iterator();
                        while(bucketList.hasNext()){
                            list.addFirst(bucketList.next());
                        }
                    }
                }
            }
        }
    }
}
