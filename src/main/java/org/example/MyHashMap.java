package org.example;

import java.util.*;

public class MyHashMap<K, V> implements Map<K, V> {

    class Entry<K, V> implements Map.Entry<K, V> {
        private K key;
        private V value;
        Entry(K k, V v) {
            key = k;
            value = v;
        }
        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            this.value = value;
            return value;
        }
    }

    MyHashSet<Entry> map = new MyHashSet<>();

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return keySet().contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        for(Entry entry : map) {
            if(entry.getValue().equals(value)) return true;
        }
        return false;
    }

    @Override
    public V get(Object key) {
        if(!containsKey(key)) return null;
        for(Entry entry : map) {
            if(entry.getKey().equals(key)){
                return (V) entry.getValue();
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        if(containsKey(key)) {
            for(Entry entry : map) {
                if(entry.getKey().equals(key)) {
                    return (V) entry.setValue(value);
                }
            }
        } else {
            Entry<K, V> entry = new Entry<>(key, value);
            map.add(entry);
        }
        return value;
    }

    @Override
    public V remove(Object key) {
        if(!containsKey(key)) return null;
        V value = null;
        for(Entry entry : map) {
            if(entry.getKey().equals(key)){
                value = (V) entry.getValue();
                map.remove(entry);
                return value;
            }
        }
        return null;
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
        map.clear();
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for(Entry entry : map) {
            keys.add((K) entry.getKey());
        }
        return keys;
    }

    @Override
    public Collection<V> values() {
        Set<V> values = new HashSet<>();
        for(Entry entry : map) {
            values.add((V) entry.getValue());
        }
        return values;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> entries = new HashSet<>();
        for(Entry entry : map) {
            Map.Entry<K, V> mapEntry = (Map.Entry<K, V>) new Entry<>(entry.getKey(), entry.getValue());
            entries.add(mapEntry);
        }
        return entries;
    }

    //2 methods under this comment are created to make testing of entries() easy
    boolean equalEntrySet(Set<Map.Entry<K, V>> mapEntries) {
        Set<Map.Entry<K, V>> myEntries = entrySet();
        for(Map.Entry<K, V> myEntry : myEntries) {
            if(!containsEntry(myEntry, mapEntries)) {
                return false;
            }
        }
        return true;
    }

    private boolean containsEntry(Map.Entry<K, V> entry, Set<Map.Entry<K, V>> entries){
        for(Map.Entry<K, V> myEntry : entries) {
            if(myEntry.getKey().equals(entry.getKey())
            && myEntry.getValue().equals(entry.getValue())) return true;
        }
        return false;
    }
}
