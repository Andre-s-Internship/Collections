package org.example;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyTreeMap<K extends Comparable<K>, V> implements Map<K, V> {

    public static class Entry<K, V> implements Map.Entry<K, V> {
        K key;
        V value;
        Entry<K, V> parent;
        Entry<K, V> left;
        Entry<K, V> right;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {
            return false;
        }

        @Override
        public int hashCode() {
            return 0;
        }
    }

    Entry<K, V> root;
    private int size;
    public MyHashSet<Entry<K,V>> entries;

    MyTreeMap() {
        entries = new MyHashSet<>();
        size = 0;
        root = null;
    }

    private int compareTo(K key1, K key2) {
        return key1.compareTo(key2);
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
    public boolean containsKey(Object key) {
        for(Entry <K, V> entry : entries) {
            if(entry.key.equals(key)) return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for(Entry <K, V> entry : entries) {
            if(entry.value.equals(value)) return true;
        }
        return false;
    }

    @Override
    public V get(Object key) {
        return (V) helperGetFunction(root, (K) key);
    }

    public V helperGetFunction(Entry<K, V> e, K key) {
        if (e == null) {
            return null;
        }
        if (compareTo(key, e.key) == 0) {
            return (V) e.value;
        }
        if (e.left == null && e.right == null) {
            return null;
        }
        if (compareTo(key, e.key) < 0) {
            return helperGetFunction(e.left, key);
        }
        return helperGetFunction(e.right, key);
    }


    @Override
    public V put(K key, V value) {
        Entry<K, V> newEntry = new Entry<>(key, value);
        if (root == null) {
            root = newEntry;
            size++;
            entries.add(newEntry);
            return value;
        }
        Entry<K, V> temp = root;
        Entry<K, V> parent = null;
        while (temp != null) {
            int comp = compareTo(temp.key, key);
            if (comp == 0) {
                V oldValue = temp.value;
                temp.value = value;
                return oldValue;
            } else if (comp > 0) {
                parent = temp;
                temp = temp.left;
            } else {
                parent = temp;
                temp = temp.right;
            }
        }
        temp = parent;
        newEntry.parent = temp;
        if (compareTo(key, temp.key) > 0) {
            temp.right = newEntry;
        } else {
            temp.left = newEntry;
        }
        while (temp != null) {
            reBalance(temp);
            temp = temp.parent;
        }
        entries.add(newEntry);
        size++;
        return value;
    }

    @Override
    public V remove(Object key) {
        Entry<K, V> temp = root;
        Entry<K, V> parent = null;

        while (temp != null) {
            int comp = compareTo(temp.key, (K) key);
            if (comp == 0) {
                V oldValue = temp.value;
                if (temp.left == null && temp.right == null) {
                    if (parent == null) {
                        root = null;
                    } else {
                        if (temp.equals(parent.right)) {
                            parent.right = null;
                        } else if (temp.equals(parent.left)) {
                            parent.left = null;
                        }
                    }
                } else if (temp.left != null && temp.right != null) {
                    Entry<K, V> successor = findSuccessor(temp);
                    temp.key = successor.key;
                    temp.value = successor.value;
                    if (successor.equals(successor.parent.left)) {
                        successor.parent.left = successor.right;
                    } else if (successor.equals(successor.parent.right)) {
                        successor.parent.right = successor.right;
                    }
                    if (successor.right != null) {
                        successor.right.parent = successor.parent;
                    }
                    temp = successor;
                } else {
                    if (temp.left != null) {
                        if (temp.equals(parent.left)) {
                            parent.left = temp.left;
                        } else if (temp.equals(parent.right)) {
                            parent.right = temp.left;
                        }
                        temp.left.parent = parent;
                    } else if (temp.right != null) {
                        if (temp.equals(parent.left)) {
                            parent.left = temp.right;
                        } else if (temp.equals(parent.right)) {
                            parent.right = temp.right;
                        }
                        temp.right.parent = parent;
                    }
                }

                entries.remove(temp);
                size--;
                return oldValue;
            } else if (comp > 0) {
                parent = temp;
                temp = temp.left;
            } else {
                parent = temp;
                temp = temp.right;
            }
        }
        return null;
    }

    private Entry<K, V> findSuccessor(Entry<K, V> node) {
        Entry<K, V> current = node.right;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }


    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        Set<? extends Map.Entry<? extends K, ? extends V>> entries = m.entrySet();
        for(Map.Entry entry : entries) {
            put((K) entry.getKey(), (V) entry.getValue());
        }
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keySet = new HashSet<>();
        for(Entry<K,V> entry : entries) {
            keySet.add(entry.key);
        }
        return keySet;
    }

    @Override
    public Collection<V> values() {
        Set<V> values = new HashSet<>();
        for(Entry<K,V> entry : entries) {
            values.add(entry.value);
        }
        return values;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K,V>> mapEntries = new HashSet<>();
        for(Entry<K,V> entry : entries) {
            mapEntries.add(new Entry<>(entry.key, entry.value));
        }
        return mapEntries;
    }

    //2 methods under this comment are created to make testing of entries() easy
    boolean equalEntrySet(Set<Map.Entry<K, V>> mapEntries) {
        for(Map.Entry<K, V> myEntry : entries) {
            if(!containsEntry(myEntry, mapEntries)) {
                return false;
            }
        }
        return true;
    }

    private boolean containsEntry(Map.Entry<K, V> entry, Set<Map.Entry<K, V>> entries) {
        for(Map.Entry<K, V> myEntry : entries) {
            if(myEntry.getKey().equals(entry.getKey())
                    && myEntry.getValue().equals(entry.getValue())) return true;
        }
        return false;
    }




    private boolean completeHelper(Entry<K, V> e) {
        if (e == null || (e.left == null && e.right == null)) {
            return true;
        }
        if (e.left != null && e.right != null) {
            return completeHelper(e.left) && completeHelper(e.right);
        } else {
            return false;
        }
    }



    public boolean skewHelper(Entry<K, V> e) {
        if (e == null || (e.right == null && e.right == null)) {
            return true;
        }
        if (e.right != null) {
            return false;
        }
        return skewHelper(e.left);
    }

    public void reBalance(Entry<K, V> n) {
        if (Math.abs(height(n.left) - height(n.right)) <= 1) {
            return;
        }
        if (height(n.left) > height(n.right)) {
            if (height(n.left.right) > height(n.left.left)) {
                rotateLeft(n.left);
            }
            rotateRight(n);
        } else {
            if (height(n.right.left) > height(n.right.right)) {
                rotateRight(n.right);
            }
            rotateLeft(n);
        }
    }

    public void rotateRight(Entry<K, V> x) {
        Entry<K, V> y = x.left;
        if (x.parent == null) {
            root = y;
            y.parent = null;
        } else {
            if (x == x.parent.left) {
                x.parent.left = y;
                y.parent = x.parent;
            }

            if (x == x.parent.right) {
                x.parent.right = y;
                y.parent = x.parent;
            }
        }
        x.left = y.right;
        if (y.right != null)
            y.right.parent = x;
        y.right = x;
        x.parent = y;
    }

    public void rotateLeft(Entry<K, V> x) {
        Entry<K, V> y = x.right;
        if (x.parent == null) {
            root = y;
            y.parent = null;
        } else {
            if (x == x.parent.left) {
                x.parent.left = y;
                y.parent = x.parent;
            }

            if (x == x.parent.right) {
                x.parent.right = y;
                y.parent = x.parent;
            }
        }
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.left = x;
        x.parent = y;
    }

    public int height(Entry<K, V> n) {
        if (n == null) {
            return -1;
        }
        int leftHeight = height(n.left);
        int rightHeight = height(n.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }


}
