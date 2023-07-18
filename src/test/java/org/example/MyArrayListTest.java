package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    @DisplayName("Test for size")
    void size() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("Java");
        myArrayList.add("is");
        myArrayList.add("fun");
        assertEquals(3, myArrayList.size());
    }

    @Test
    @DisplayName("Test for isEmpty 1")
    void notEmpty() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("Hello");
        assertFalse(myArrayList.isEmpty());
    }

    @Test
    @DisplayName("Test for isEmpty 2")
    void Empty() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        assertEquals(myArrayList.isEmpty(), arrayList.isEmpty());
    }

    @Test
    @DisplayName("Test for contains 1")
    void contains() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        myArrayList.add(7);
        arrayList.add(7);
        assertEquals(myArrayList.contains(7), arrayList.contains(7));
    }

    @Test
    @DisplayName("Test for contains 2")
    void notContains() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        myArrayList.add(5);
        arrayList.add(5);
        assertEquals(myArrayList.contains(7), arrayList.contains(7));
    }

    @Test
    @DisplayName("Test for toArray")
    void toArray() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        String s1 = "Hello";
        String s2 = "World";
        myArrayList.add(s1);
        myArrayList.add(s2);
        arrayList.add(s1);
        arrayList.add(s2);
        assertArrayEquals(myArrayList.toArray(), arrayList.toArray());
    }

    @Test
    @DisplayName("Test for add")
    void addObject() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        myArrayList.add("Java");
        myArrayList.add("is");
        myArrayList.add("fun");
        arrayList.add("Java");
        arrayList.add("is");
        arrayList.add("fun");
        assertArrayEquals(myArrayList.toArray(), arrayList.toArray());
    }


    @Test
    @DisplayName("Test for remove")
    void removeObject() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        myArrayList.add("Java");
        myArrayList.add("is");
        myArrayList.add("fun");
        arrayList.add("Java");
        arrayList.add("is");
        arrayList.add("fun");
        myArrayList.remove("Java");
        arrayList.remove("Java");
        assertArrayEquals(myArrayList.toArray(), arrayList.toArray());
    }

    @Test
    @DisplayName("Test for containsAll 1")
    void containsAllTrue() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        myArrayList.add("Java");
        myArrayList.add("is");
        myArrayList.add("fun");
        myArrayList.add("JS is not");
        arrayList.add("Java");
        arrayList.add("is");
        arrayList.add("fun");
        arrayList.add("JS is not");
        assertTrue(myArrayList.containsAll(arrayList));
    }

    @Test
    @DisplayName("Test for containsAll 2")
    void containsAllFalse() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        myArrayList.add("Java");
        myArrayList.add("is");
        myArrayList.add("fun");
        myArrayList.add("JS is not");
        arrayList.add("Java");
        arrayList.add("is");
        arrayList.add("fun");
        arrayList.add("but not JS");
        assertFalse(myArrayList.containsAll(arrayList));
    }

    @Test
    @DisplayName("Test for addAll")
    void addAll() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        myArrayList.add("Java");
        myArrayList.add("is");
        myArrayList.add("fun");
        arrayList.add("JS");
        arrayList.add("is");
        arrayList.add("not");
        assertTrue(myArrayList.addAll(arrayList));
        assertTrue(myArrayList.containsAll(arrayList));
    }

    @Test
    @DisplayName("Test for removeAll 1")
    void removeAllTrue() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        myArrayList.add("Java");
        myArrayList.add("is");
        myArrayList.add("fun");

        arrayList.add("is");
        arrayList.add("fun");

        assertTrue(myArrayList.removeAll(arrayList));
        ArrayList<String> Java = new ArrayList<>();
        Java.add("Java");
        assertArrayEquals(myArrayList.toArray(),Java.toArray());
    }

    @Test
    @DisplayName("Test for removeAll 2")
    void removeAllFalse() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        myArrayList.add("Java");
        myArrayList.add("is");
        myArrayList.add("fun");

        arrayList.add("is");
        arrayList.add("not");

        assertFalse(myArrayList.removeAll(arrayList));
    }

    @Test
    @DisplayName("Test for clear")
    void clear() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("Java");
        myArrayList.add("is");
        myArrayList.add("fun");
        myArrayList.clear();
        assertTrue(myArrayList.isEmpty());
    }

    @Test
    @DisplayName("Test for get 1")
    void get() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("Java");
        myArrayList.add("is");
        myArrayList.add("fun");
        assertEquals(myArrayList.get(1), "is");
    }

    @Test
    @DisplayName("Test for get 2")
    void getFalse() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("Java");
        myArrayList.add("is");
        myArrayList.add("fun");
        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.get(3));
    }


    @Test
    @DisplayName("Test for set 1")
    void setTrue() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("Java");
        myArrayList.add("is");
        myArrayList.add("fun");
        myArrayList.set(1, "home");
        assertEquals(myArrayList.get(1), "home");
    }

    @Test
    @DisplayName("Test for set 2")
    void setFalse() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("Java");
        myArrayList.add("is");
        myArrayList.add("fun");
        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.set(3, "home"));
    }


    @Test
    @DisplayName("Test for add with index 1")
    void addIndexTrue() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("Java");
        myArrayList.add("is");
        myArrayList.add("fun");
        myArrayList.add(1, "Hello");

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Java");
        arrayList.add("is");
        arrayList.add("fun");
        arrayList.add(1, "Hello");

        assertArrayEquals(myArrayList.toArray(), arrayList.toArray());
    }

    @Test
    @DisplayName("Test for add with index 2")
    void addIndexFalse() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("Java");
        myArrayList.add("is");
        myArrayList.add("fun");
        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.add(45, "Hello"));
    }

    @Test
    @DisplayName("Test for remove with index 1")
    void removeIndexTrue() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("Java");
        myArrayList.add("is");
        myArrayList.add("fun");
        myArrayList.remove(1);
        String[] array = {"Java", "fun"};
        assertArrayEquals(myArrayList.toArray(), array);
    }

    @Test
    @DisplayName("Test for remove with index 2")
    void removeIndexFalse() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("Java");
        myArrayList.add("is");
        myArrayList.add("fun");
        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.remove(45));
    }

    @Test
    @DisplayName("Test for indexOf 1")
    void indexOf() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("Java");
        myArrayList.add("is");
        myArrayList.add("fun");

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Java");
        arrayList.add("is");
        arrayList.add("fun");

        assertEquals(1, myArrayList.indexOf("is"));
        assertEquals(myArrayList.indexOf("is"), arrayList.indexOf("is"));
    }

    @Test
    @DisplayName("Test for indexOf 2")
    void indexOfFalse() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("Java");
        myArrayList.add("is");
        myArrayList.add("fun");

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Java");
        arrayList.add("is");
        arrayList.add("fun");

        assertEquals(0, myArrayList.indexOf("Java"));
        assertEquals(myArrayList.indexOf("hello"), arrayList.indexOf("hello"));
    }


    @Test
    @DisplayName("Test for lastIndexOf 1")
    void lastIndexOfTrue() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("Java");
        myArrayList.add("is");
        myArrayList.add("Java");
        myArrayList.add("fun");

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Java");
        arrayList.add("is");
        arrayList.add("Java");
        arrayList.add("fun");

        assertEquals(2, myArrayList.lastIndexOf("Java"));
        assertEquals(myArrayList.lastIndexOf("Java"), arrayList.lastIndexOf("Java"));
    }


    @Test
    @DisplayName("Test for lastIndexOf 2")
    void lastIndexOfFalse() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("Python");
        myArrayList.add("is");
        myArrayList.add("very");
        myArrayList.add("fun");

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Python");
        arrayList.add("is");
        arrayList.add("very");
        arrayList.add("fun");

        assertEquals(-1, myArrayList.lastIndexOf("Java"));
        assertEquals(myArrayList.lastIndexOf("Java"), arrayList.lastIndexOf("Java"));
    }

    @Test
    @DisplayName("Test for addAll with index 1")
    void addAllIndex() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("0");
        myArrayList.add("1");
        myArrayList.add("2");

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("0");
        arrayList.add("1");
        arrayList.add("2");

        String[] strings = {"2", "3"};

        myArrayList.addAll(1, Arrays.stream(strings).toList());
        arrayList.addAll(1, Arrays.stream(strings).toList());

        assertArrayEquals(myArrayList.toArray(), arrayList.toArray());
    }

    @Test
    @DisplayName("Test for addAll with index 2")
    void addAllIndexFalse() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("0");
        myArrayList.add("1");
        myArrayList.add("2");

        String[] strings = {"2", "3"};

        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.addAll(4, Arrays.stream(strings).toList()));

    }
}