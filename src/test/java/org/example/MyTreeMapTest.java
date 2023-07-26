package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class MyTreeMapTest {

    MyTreeMap<Integer, String> createMyTreeMap() {
        MyTreeMap<Integer, String> myTreeMap = new MyTreeMap<>();
        myTreeMap.put(1, "Java");
        myTreeMap.put(2, "is");
        myTreeMap.put(3, "fun");
        return myTreeMap;
    }

    TreeMap<Integer, String> createTreeMap() {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "Java");
        treeMap.put(2, "is");
        treeMap.put(3, "fun");
        return treeMap;
    }

    @Test
    @DisplayName("Test for size 1")
    void size() {
        MyTreeMap<Integer, String> myTreeMap = createMyTreeMap();
        TreeMap<Integer, String> treeMap = createTreeMap();
        assertEquals(3, myTreeMap.size());
        assertEquals(treeMap.size(), myTreeMap.size());
    }

    @Test
    @DisplayName("Test for size 2")
    void sizeEmpty() {
        MyTreeMap<Integer, String> myTreeMap = new MyTreeMap<>();
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        assertEquals(0, myTreeMap.size());
        assertEquals(treeMap.size(), myTreeMap.size());
    }

    @Test
    @DisplayName("Test for isEmpty 1")
    void isEmpty() {
        MyTreeMap<Integer, String> myTreeMap = new MyTreeMap<>();
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        assertTrue(myTreeMap.isEmpty());
        assertEquals(treeMap.isEmpty(), myTreeMap.isEmpty());
    }

    @Test
    @DisplayName("Test for isEmpty 2")
    void isEmptyFalse() {
        MyTreeMap<Integer, String> myTreeMap = createMyTreeMap();
        TreeMap<Integer, String> treeMap = createTreeMap();
        assertFalse(myTreeMap.isEmpty());
        assertEquals(treeMap.isEmpty(), myTreeMap.isEmpty());
    }

    @Test
    @DisplayName("Test for containsKey 1")
    void containsKeyTrue() {
        MyTreeMap<Integer, String> myTreeMap = createMyTreeMap();
        TreeMap<Integer, String> treeMap = createTreeMap();
        assertTrue(myTreeMap.containsKey(2));
        assertEquals(treeMap.containsKey(1), myTreeMap.containsKey(1));
    }

    @Test
    @DisplayName("Test for containsKey 2")
    void containsKeyFalse() {
        MyTreeMap<Integer, String> myTreeMap = createMyTreeMap();
        TreeMap<Integer, String> treeMap = createTreeMap();
        assertFalse(myTreeMap.containsKey(4));
        assertEquals(treeMap.containsKey(5), myTreeMap.containsKey(5));
    }

    @Test
    @DisplayName("Test for containsValue 1")
    void containsValueTrue() {
        MyTreeMap<Integer, String> myTreeMap = createMyTreeMap();
        TreeMap<Integer, String> treeMap = createTreeMap();
        assertTrue(myTreeMap.containsValue("is"));
        assertEquals(treeMap.containsValue("Java"), myTreeMap.containsValue("Java"));
    }

    @Test
    @DisplayName("Test for containsValue 2")
    void containsValueFalse() {
        MyTreeMap<Integer, String> myTreeMap = createMyTreeMap();
        TreeMap<Integer, String> treeMap = createTreeMap();
        assertFalse(myTreeMap.containsValue("JavaScript"));
        assertEquals(treeMap.containsValue("Python"), myTreeMap.containsValue("Python"));
    }

    @Test
    @DisplayName("Test for get 1")
    void getTrue() {
        MyTreeMap<Integer, String> myTreeMap = createMyTreeMap();
        TreeMap<Integer, String> treeMap = createTreeMap();
        assertEquals("Java", myTreeMap.get(1));
        assertEquals(treeMap.get(2), myTreeMap.get(2));
    }

    @Test
    @DisplayName("Test for get 2")
    void getFalse() {
        MyTreeMap<Integer, String> myTreeMap = createMyTreeMap();
        TreeMap<Integer, String> treeMap = createTreeMap();
        assertNull(myTreeMap.get(5));
        assertEquals(treeMap.get(6), myTreeMap.get(6));
    }

    @Test
    @DisplayName("Test for put 1")
    void put() {
        MyTreeMap<Integer, String> myTreeMap = createMyTreeMap();
        TreeMap<Integer, String> treeMap = createTreeMap();
        myTreeMap.put(4, "Python");
        treeMap.put(4, "Python");
        assertEquals(treeMap.size(), myTreeMap.size());
        assertTrue(treeMap.containsKey(4) && treeMap.containsValue("Python") &&
                myTreeMap.containsKey(4) && myTreeMap.containsValue("Python"));
    }

    @Test
    @DisplayName("Test for put 2")
    void putSame() {
        MyTreeMap<Integer, String> myTreeMap = createMyTreeMap();
        TreeMap<Integer, String> treeMap = createTreeMap();
        treeMap.put(3, "Python");
        myTreeMap.put(3, "Python");
        assertEquals(treeMap.size(), myTreeMap.size());
        assertTrue(treeMap.get(3).equals("Python") && myTreeMap.get(3).equals("Python"));
    }


    @Test
    @DisplayName("Test for remove 1")
    void removeTrue() {
        MyTreeMap<Integer, String> myTreeMap = createMyTreeMap();
        TreeMap<Integer, String> treeMap = createTreeMap();
        assertEquals(treeMap.remove(2), myTreeMap.remove(2));
        assertFalse(treeMap.containsKey(2) && treeMap.containsValue("is") &&
                myTreeMap.containsKey(2) && myTreeMap.containsValue("is"));
    }

    @Test
    @DisplayName("Test for remove 2")
    void removeFalse() {
        MyTreeMap<Integer, String> myTreeMap = createMyTreeMap();
        TreeMap<Integer, String> treeMap = createTreeMap();
        assertEquals(treeMap.remove(4), myTreeMap.remove(4));
        assertNull(myTreeMap.remove(4));
    }

    @Test
    @DisplayName("Test for putAll 1")
    void putAll() {
        MyTreeMap<Integer, String> myTreeMap = createMyTreeMap();
        TreeMap<Integer, String> treeMap = createTreeMap();
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Python");
        map.put(2, "is");
        map.put(3, "not");
        map.put(4, "fun");
        myTreeMap.putAll(map);
        treeMap.putAll(map);
        assertTrue(treeMap.get(1).equals("Python") && myTreeMap.get(1).equals("Python"));
    }

    @Test
    @DisplayName("Test for putAll 2")
    void putAll2() {
        MyTreeMap<Integer, String> myTreeMap = createMyTreeMap();
        TreeMap<Integer, String> treeMap = createTreeMap();
        Map<Integer, String> map = new HashMap<>();
        map.put(4, "Python");
        map.put(5, "is");
        map.put(6, "not");
        map.put(7, "fun");
        treeMap.putAll(map);
        myTreeMap.putAll(map);
        assertTrue(treeMap.size() == 7 && myTreeMap.size() == 7);
        assertTrue(treeMap.get(1).equals("Java") && myTreeMap.get(1).equals("Java"));
        assertTrue(treeMap.get(4).equals("Python") && myTreeMap.get(4).equals("Python"));
    }

    @Test
    @DisplayName("Test for clear")
    void clear() {
        MyTreeMap<Integer, String> myTreeMap = createMyTreeMap();
        TreeMap<Integer, String> treeMap = createTreeMap();
        myTreeMap.clear();
        treeMap.clear();
        assertTrue(treeMap.isEmpty() && myTreeMap.isEmpty());
    }

    @Test
    @DisplayName("Test for keySet")
    void keySet() {
        MyTreeMap<Integer, String> myTreeMap = createMyTreeMap();
        TreeMap<Integer, String> treeMap = createTreeMap();
        assertTrue(treeMap.keySet().containsAll(treeMap.keySet()) &&
                myTreeMap.keySet().containsAll(myTreeMap.keySet()));
    }

    @Test
    @DisplayName("Test for values")
    void values() {
        MyTreeMap<Integer, String> myTreeMap = createMyTreeMap();
        TreeMap<Integer, String> treeMap = createTreeMap();
        assertTrue(treeMap.values().containsAll(myTreeMap.values()) &&
                myTreeMap.values().containsAll(treeMap.values()));
    }

    @Test
    @DisplayName("Test for entrySet 1")
    void entrySet() {
        MyTreeMap<Integer, String> myTreeMap = createMyTreeMap();
        TreeMap<Integer, String> treeMap = createTreeMap();
        assertTrue(myTreeMap.equalEntrySet(treeMap.entrySet()));
    }

    @Test
    @DisplayName("Test for entrySet 2")
    void entrySetFalse() {
        MyTreeMap<Integer, String> myTreeMap = createMyTreeMap();
        TreeMap<Integer, String> treeMap = createTreeMap();
        myTreeMap.put(4, "Python");
        treeMap.put(4, "Javascript");
        assertFalse(myTreeMap.equalEntrySet(treeMap.entrySet()));
    }


}