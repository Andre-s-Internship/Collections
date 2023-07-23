package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {

    MyHashMap<Integer, String> createMyHashMap(){
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        myHashMap.put(1, "Java");
        myHashMap.put(2, "is");
        myHashMap.put(3, "fun");
        return myHashMap;
    }

    HashMap<Integer, String> createHashMap(){
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Java");
        hashMap.put(2, "is");
        hashMap.put(3, "fun");
        return hashMap;
    }

    @Test
    @DisplayName("Test for size 1")
    void size() {
        MyHashMap<Integer, String> myHashMap = createMyHashMap();
        assertEquals(3, myHashMap.size());
    }

    @Test
    @DisplayName("Test for size 2")
    void sizeEmpty() {
        MyHashMap<Integer, String> myHashMap = new MyHashMap();
        assertEquals(0, myHashMap.size());
    }

    @Test
    @DisplayName("Test for size 3")
    void sizeEquals() {
        MyHashMap<Integer, String> myHashMap = createMyHashMap();
        HashMap<Integer, String> hashMap = createHashMap();
        assertEquals(hashMap.size(), myHashMap.size());
    }

    @Test
    @DisplayName("Test for isEmpty 1")
    void isEmptyTrue() {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        assertTrue(myHashMap.isEmpty());
    }

    @Test
    @DisplayName("Test for isEmpty 2")
    void isEmptyFalse() {
        MyHashMap<Integer, String> myHashMap = createMyHashMap();
        assertFalse(myHashMap.isEmpty());
    }

    @Test
    @DisplayName("Test for containsKey 1")
    void containsKeyTrue() {
        MyHashMap<Integer, String> myHashMap = createMyHashMap();
        HashMap<Integer, String> hashMap = createHashMap();
        assertTrue(myHashMap.containsKey(1));
        assertTrue(hashMap.containsKey(1));
        assertEquals(hashMap.containsKey(2), myHashMap.containsKey(2));
    }

    @Test
    @DisplayName("Test for containsKey 2")
    void containsKeyFalse() {
        MyHashMap<Integer, String> myHashMap = createMyHashMap();
        HashMap<Integer, String> hashMap = createHashMap();
        assertFalse(myHashMap.containsKey(4));
        assertFalse(hashMap.containsKey(4));
        assertEquals(hashMap.containsKey(7), myHashMap.containsKey(7));
    }


    @Test
    @DisplayName("Test for containsValue 1")
    void containsValueTrue() {
        MyHashMap<Integer, String> myHashMap = createMyHashMap();
        HashMap<Integer, String> hashMap = createHashMap();
        assertTrue(myHashMap.containsValue("Java"));
        assertTrue(hashMap.containsValue("Java"));
        assertEquals(hashMap.containsValue("is"), myHashMap.containsValue("is"));
    }

    @Test
    @DisplayName("Test for containsValue 2")
    void containsValueFalse() {
        MyHashMap<Integer, String> myHashMap = createMyHashMap();
        HashMap<Integer, String> hashMap = createHashMap();
        assertFalse(myHashMap.containsValue("Python"));
        assertFalse(hashMap.containsValue("Python"));
        assertEquals(hashMap.containsValue("not"), myHashMap.containsValue("not"));
    }

    @Test
    @DisplayName("Test for get 1")
    void getValue() {
        MyHashMap<Integer, String> myHashMap = createMyHashMap();
        HashMap<Integer, String> hashMap = createHashMap();
        assertEquals("Java", myHashMap.get(1));
        assertEquals(hashMap.get(1), myHashMap.get(1));
    }


    @Test
    @DisplayName("Test for get 2")
    void getNoValue() {
        MyHashMap<Integer, String> myHashMap = createMyHashMap();
        HashMap<Integer, String> hashMap = createHashMap();
        assertNull(myHashMap.get(5));
        assertEquals(hashMap.get(5), myHashMap.get(5));
    }

    @Test
    @DisplayName("Test for put 1")
    void put() {
        MyHashMap<Integer, String> myHashMap = createMyHashMap();
        HashMap<Integer, String> hashMap = createHashMap();
        hashMap.put(4, "Python");
        myHashMap.put(4, "Python");
        assertEquals(hashMap.size(), myHashMap.size());
        assertTrue(hashMap.containsKey(4) && hashMap.containsValue("Python") &&
                            myHashMap.containsKey(4) && myHashMap.containsValue("Python"));
    }

    @Test
    @DisplayName("Test for put 2")
    void putSame() {
        MyHashMap<Integer, String> myHashMap = createMyHashMap();
        HashMap<Integer, String> hashMap = createHashMap();
        hashMap.put(3, "Python");
        myHashMap.put(3, "Python");
        assertEquals(hashMap.size(), myHashMap.size());
        assertTrue(hashMap.get(3).equals("Python") && myHashMap.get(3).equals("Python"));
    }


    @Test
    @DisplayName("Test for remove 1")
    void removeTrue() {
        MyHashMap<Integer, String> myHashMap = createMyHashMap();
        HashMap<Integer, String> hashMap = createHashMap();
        assertEquals(hashMap.remove(2), myHashMap.remove(2));
        assertFalse(hashMap.containsKey(2) && hashMap.containsValue("is") &&
                myHashMap.containsKey(2) && myHashMap.containsValue("is"));
    }

    @Test
    @DisplayName("Test for remove 2")
    void removeFalse() {
        MyHashMap<Integer, String> myHashMap = createMyHashMap();
        HashMap<Integer, String> hashMap = createHashMap();
        assertEquals(hashMap.remove(4), myHashMap.remove(4));
        assertNull(myHashMap.remove(4));
    }

    @Test
    @DisplayName("Test for putAll 1")
    void putAll() {
        MyHashMap<Integer, String> myHashMap = createMyHashMap();
        HashMap<Integer, String> hashMap = createHashMap();
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Python");
        map.put(2, "is");
        map.put(3, "not");
        map.put(4, "fun");
        hashMap.putAll(map);
        myHashMap.putAll(map);
        //assertTrue(hashMap.size() == 4 && myHashMap.size() == 4);
        assertTrue(hashMap.get(1).equals("Python") && myHashMap.get(1).equals("Python"));
    }

    @Test
    @DisplayName("Test for putAll 2")
    void putAll2() {
        MyHashMap<Integer, String> myHashMap = createMyHashMap();
        HashMap<Integer, String> hashMap = createHashMap();
        Map<Integer, String> map = new HashMap<>();
        map.put(4, "Python");
        map.put(5, "is");
        map.put(6, "not");
        map.put(7, "fun");
        hashMap.putAll(map);
        myHashMap.putAll(map);
        assertTrue(hashMap.size() == 7 && myHashMap.size() == 7);
        assertTrue(hashMap.get(1).equals("Java") && myHashMap.get(1).equals("Java"));
        assertTrue(hashMap.get(4).equals("Python") && myHashMap.get(4).equals("Python"));
    }

    @Test
    @DisplayName("Test for clear")
    void clear() {
        MyHashMap<Integer, String> myHashMap = createMyHashMap();
        HashMap<Integer, String> hashMap = createHashMap();
        myHashMap.clear();
        hashMap.clear();
        assertTrue(hashMap.isEmpty() && myHashMap.isEmpty());
    }

    @Test
    @DisplayName("Test for keySet")
    void keySet() {
        MyHashMap<Integer, String> myHashMap = createMyHashMap();
        HashMap<Integer, String> hashMap = createHashMap();
        assertTrue(hashMap.keySet().containsAll(myHashMap.keySet()) &&
                            myHashMap.keySet().containsAll(hashMap.keySet()));
    }

    @Test
    @DisplayName("Test for values")
    void values() {
        MyHashMap<Integer, String> myHashMap = createMyHashMap();
        HashMap<Integer, String> hashMap = createHashMap();
        assertTrue(hashMap.values().containsAll(myHashMap.values()) &&
                            myHashMap.values().containsAll(hashMap.values()));
    }

    @Test
    @DisplayName("Test for entrySet 1")
    void entrySet() {
        MyHashMap<Integer, String> myHashMap = createMyHashMap();
        HashMap<Integer, String> hashMap = createHashMap();
        assertTrue(myHashMap.equalEntrySet(hashMap.entrySet()));
    }

    @Test
    @DisplayName("Test for entrySet 2")
    void entrySetFalse() {
        MyHashMap<Integer, String> myHashMap = createMyHashMap();
        HashMap<Integer, String> hashMap = createHashMap();
        myHashMap.put(4, "Python");
        hashMap.put(4, "Javascript");
        assertFalse(myHashMap.equalEntrySet(hashMap.entrySet()));
    }




}