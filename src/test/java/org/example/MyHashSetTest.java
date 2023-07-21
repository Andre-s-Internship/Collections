package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class MyHashSetTest {

    MyHashSet<String> createMyHashSet(){
        MyHashSet<String> myHashSet = new MyHashSet<>();
        myHashSet.add("Java");
        myHashSet.add("is");
        myHashSet.add("fun");
        return myHashSet;
    }

    HashSet<String> createHashSet(){
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Java");
        hashSet.add("is");
        hashSet.add("fun");
        return hashSet;
    }



    @Test
    @DisplayName("Test for size 1")
    void size() {
        MyHashSet<String> myHashSet = createMyHashSet();
        assertEquals(3, myHashSet.size());
    }

    @Test
    @DisplayName("Test for size 2")
    void sizeEmpty() {
        MyHashSet<String> myHashSet = new MyHashSet<>();
        assertEquals(0, myHashSet.size());
    }

    @Test
    @DisplayName("Test for isEmpty 1")
    void isEmptyTrue() {
        MyHashSet<String> myHashSet = new MyHashSet<>();
        assertTrue(myHashSet.isEmpty());
    }

    @Test
    @DisplayName("Test for isEmpty 2")
    void isEmptyFalse() {
        MyHashSet<String> myHashSet = createMyHashSet();
        assertFalse(myHashSet.isEmpty());
    }

    @Test
    @DisplayName("Test for contains 1")
    void contains() {
        MyHashSet<String> myHashSet = createMyHashSet();
        assertTrue(myHashSet.contains("Java"));
    }

    @Test
    @DisplayName("Test for contains 2")
    void contains1() {
        MyHashSet<String> myHashSet = createMyHashSet();
        assertFalse(myHashSet.contains("Python"));
    }

    @Test
    @DisplayName("Test for contains 3")
    void contains2() {
        MyHashSet<String> myHashSet = new MyHashSet<>();
        assertFalse(myHashSet.contains("Python"));
    }

    @Test
    @DisplayName("Test for toArray 1")
    void toArray1() {
        MyHashSet<String> myHashSet = createMyHashSet();
        String[] strings = {"Java", "is", "fun"};
        assertArrayEquals(strings, myHashSet.toArray());
    }

    @Test
    @DisplayName("Test for toArray 2")
    void toArray2() {
        MyHashSet<String> myHashSet = createMyHashSet();
        HashSet<String> hashSet = createHashSet();
        assertArrayEquals(hashSet.toArray(), myHashSet.toArray());
    }

    @Test
    @DisplayName("Test for add 1")
    void add1() {
        MyHashSet<String> myHashSet = createMyHashSet();
        assertFalse(myHashSet.add("Java"));
    }

    @Test
    @DisplayName("Test for add 2")
    void add2() {
        MyHashSet<String> myHashSet = createMyHashSet();
        HashSet<String> hashSet = createHashSet();
        assertTrue(myHashSet.add("Python"));
        assertTrue(hashSet.add("Python"));
        assertArrayEquals(hashSet.toArray(), myHashSet.toArray());
    }


    @Test
    @DisplayName("Test for remove 1")
    void remove1() {
        MyHashSet<String> myHashSet = createMyHashSet();
        HashSet<String> hashSet = createHashSet();
        assertTrue(myHashSet.remove("Java"));
        assertTrue(hashSet.remove("Java"));
        assertArrayEquals(hashSet.toArray(), myHashSet.toArray());
    }

    @Test
    @DisplayName("Test for remove 2")
    void remove2() {
        MyHashSet<String> myHashSet = createMyHashSet();
        HashSet<String> hashSet = createHashSet();
        assertFalse(myHashSet.remove("Python"));
        assertFalse(hashSet.remove("Python"));
        assertArrayEquals(hashSet.toArray(), myHashSet.toArray());
    }


    @Test
    @DisplayName("Test for addAll 1")
    void addAll() {
        MyHashSet<String> myHashSet = createMyHashSet();
        HashSet<String> hashSet = createHashSet();
        HashSet<String> hashSet1 = createHashSet();
        assertTrue(myHashSet.addAll(hashSet1));
        assertTrue(hashSet.addAll(hashSet1));
        assertArrayEquals(hashSet.toArray(), myHashSet.toArray());
    }


    @Test
    @DisplayName("Test for addAll 2")
    void addAll2() {
        MyHashSet<String> myHashSet = createMyHashSet();
        HashSet<String> hashSet = createHashSet();
        HashSet<String> hashSet1 = new HashSet<>();
        assertTrue(myHashSet.addAll(hashSet1));
        assertTrue(hashSet.addAll(hashSet1));
        assertArrayEquals(hashSet.toArray(), myHashSet.toArray());
    }


    @Test
    @DisplayName("Test for clear 1")
    void clear() {
        MyHashSet<String> myHashSet = createMyHashSet();
        HashSet<String> hashSet = createHashSet();
        myHashSet.clear();
        hashSet.clear();
        assertEquals(0, myHashSet.size());
        assertEquals(0, hashSet.size());
        assertArrayEquals(hashSet.toArray(), myHashSet.toArray());
    }



    @Test
    @DisplayName("Test for removeAll 1")
    void removeAll() {
        MyHashSet<String> myHashSet = createMyHashSet();
        HashSet<String> hashSet = createHashSet();
        HashSet<String> hashSet1 = createHashSet();
        assertTrue(myHashSet.removeAll(hashSet1));
        assertTrue(hashSet.removeAll(hashSet1));
        assertArrayEquals(hashSet.toArray(), myHashSet.toArray());
    }

    @Test
    @DisplayName("Test for removeAll 2")
    void removeAll2() {
        MyHashSet<String> myHashSet = createMyHashSet();
        HashSet<String> hashSet = createHashSet();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("Java");
        hashSet1.add("fun");
        assertTrue(myHashSet.removeAll(hashSet1));
        assertTrue(hashSet.removeAll(hashSet1));
        assertArrayEquals(hashSet.toArray(), myHashSet.toArray());
    }


    @Test
    @DisplayName("Test for containsAll 1")
    void containsAll() {
        MyHashSet<String> myHashSet = createMyHashSet();
        HashSet<String> hashSet = createHashSet();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("Java");
        hashSet1.add("fun");
        assertTrue(myHashSet.containsAll(hashSet1));
        assertTrue(hashSet.containsAll(hashSet1));
    }

    @Test
    @DisplayName("Test for containsAll 2")
    void containsAll2() {
        MyHashSet<String> myHashSet = createMyHashSet();
        HashSet<String> hashSet = createHashSet();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("Java");
        hashSet1.add("Python");
        assertFalse(myHashSet.containsAll(hashSet1));
        assertFalse(hashSet.containsAll(hashSet1));
    }






}