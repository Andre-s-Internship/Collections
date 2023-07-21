package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {
    LinkedList<String> createLinkedList() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Java");
        linkedList.add("is");
        linkedList.add("fun");
        return linkedList;
    }

    MyLinkedList<String> createMyLinkedList() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("Java");
        myLinkedList.add("is");
        myLinkedList.add("fun");
        return myLinkedList;
    }

    @Test
    @DisplayName("Test for size")
    void size() {
        LinkedList<String> linkedList = createLinkedList();
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        assertEquals(linkedList.size(), myLinkedList.size());
    }

    @Test
    @DisplayName("Test for isEmpty 1")
    void isEmpty() {
        LinkedList<String> linkedList = createLinkedList();
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        assertEquals(linkedList.isEmpty(), myLinkedList.isEmpty());
    }

    @Test
    @DisplayName("Test for isEmpty 2")
    void isEmptyFalse() {
        LinkedList<String> linkedList = new LinkedList<>();
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        assertEquals(linkedList.isEmpty(), myLinkedList.isEmpty());
    }


    @Test
    @DisplayName("Test for contains 1")
    void contains() {
        LinkedList<String> linkedList = createLinkedList();
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        assertTrue(myLinkedList.contains("Java"));
        assertEquals(linkedList.contains("Java"), myLinkedList.contains("Java"));
    }

    @Test
    @DisplayName("Test for contains 2")
    void containsFalse() {
        LinkedList<String> linkedList = createLinkedList();
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        assertFalse(myLinkedList.contains("Python"));
        assertEquals(linkedList.contains("Python"), myLinkedList.contains("Python"));
    }

    @Test
    @DisplayName("Test for toArray 1")
    void toArray() {
        LinkedList<String> linkedList = createLinkedList();
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        assertArrayEquals(linkedList.toArray(), myLinkedList.toArray());
    }

    @Test
    @DisplayName("Test for toArray 2")
    void toArrayEmpty() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        assertThrows(IllegalStateException.class, () -> myLinkedList.toArray());
    }


    @Test
    @DisplayName("Test for add")
    void add() {
        LinkedList<String> linkedList = createLinkedList();
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        linkedList.add("Hello");
        linkedList.add("world");
        myLinkedList.add("Hello");
        myLinkedList.add("world");
        assertArrayEquals(linkedList.toArray(), myLinkedList.toArray());
    }

    @Test
    @DisplayName("Test for add with index")
    void addIndex() {
        LinkedList<String> linkedList = createLinkedList();
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        linkedList.add(1, "Hello");
        linkedList.add(1, "world");
        myLinkedList.add(1, "Hello");
        myLinkedList.add(1, "world");
        assertArrayEquals(linkedList.toArray(), myLinkedList.toArray());
    }

    @Test
    @DisplayName("Test for indexOf 1")
    void indexOf() {
        LinkedList<String> linkedList = createLinkedList();
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        assertEquals(linkedList.indexOf("Java"), myLinkedList.indexOf("Java"));
    }

    @Test
    @DisplayName("Test for indexOf 2")
    void indexOf2() {
        LinkedList<String> linkedList = createLinkedList();
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        assertEquals(-1, myLinkedList.indexOf("Python"));
        assertEquals(linkedList.indexOf("Python"), myLinkedList.indexOf("Python"));
    }

    @Test
    @DisplayName("Test for indexOf 3")
    void indexOf3() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        assertEquals(-1, myLinkedList.indexOf("Python"));
    }



    @Test
    @DisplayName("Test for remove 1")
    void remove() {
        LinkedList<String> linkedList = createLinkedList();
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        assertEquals(linkedList.remove("Java"), myLinkedList.remove("Java"));
        assertFalse(myLinkedList.contains("Java"));
        assertEquals(linkedList.contains("Java"), myLinkedList.contains("Java"));
        assertArrayEquals(linkedList.toArray(), myLinkedList.toArray());
    }

    @Test
    @DisplayName("Test for remove 2")
    void remove2() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        assertThrows(IllegalStateException.class, () -> myLinkedList.remove("Java"));
    }

    @Test
    @DisplayName("Test for remove 3")
    void remove3() {
        LinkedList<String> linkedList = createLinkedList();
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        assertEquals(linkedList.remove("Python"), myLinkedList.remove("Python"));
        assertFalse(myLinkedList.remove("Python"));
    }


    @Test
    @DisplayName("Test for containsAll 1")
    void containsAll() {
        LinkedList<String> linkedList = createLinkedList();
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        assertTrue(myLinkedList.containsAll(linkedList));
        assertTrue(linkedList.containsAll(myLinkedList));
    }

    @Test
    @DisplayName("Test for containsAll 4")
    void containsAllFalse() {
        LinkedList<String> linkedList = new LinkedList<>();
        LinkedList<String> linkedList1 = new LinkedList<>();
        linkedList1.add("Python");
        linkedList1.add("is");
        linkedList1.add("fun");
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        assertFalse(myLinkedList.containsAll(linkedList1));
        assertFalse(linkedList.containsAll(linkedList1));
    }

    @Test
    @DisplayName("Test for containsAll 2")
    void containsAll2() {
        LinkedList<String> linkedList = createLinkedList();
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        assertTrue(myLinkedList.containsAll(new LinkedList<String>()));
        assertTrue(linkedList.containsAll(new MyLinkedList<String>()));
    }

    @Test
    @DisplayName("Test for containsAll 3")
    void containsAll3() {
        LinkedList<String> linkedList = new LinkedList<>();
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        assertTrue(myLinkedList.containsAll(new LinkedList<String>()));
        assertTrue(linkedList.containsAll(new MyLinkedList<String>()));
    }

    @Test
    @DisplayName("Test for addAll 1")
    void addAll() {
        LinkedList<String> linkedList = createLinkedList();
        LinkedList<String> linkedList1 = new LinkedList<>();
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        assertTrue(myLinkedList.addAll(linkedList));
        assertTrue(linkedList1.addAll(linkedList));
        assertArrayEquals(myLinkedList.toArray(), linkedList1.toArray());
    }
    @Test
    @DisplayName("Test for addAll 2")
    void addAll2() {
        LinkedList<String> linkedList = createLinkedList();
        LinkedList<String> linkedList1 = createLinkedList();
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        assertTrue(myLinkedList.addAll(linkedList));
        assertTrue(linkedList1.addAll(linkedList));
        System.out.println(myLinkedList.size());
        for(Object o : myLinkedList) {
            System.out.println(o.toString());
        }
        assertArrayEquals(linkedList1.toArray(), myLinkedList.toArray());
    }

    @Test
    @DisplayName("Test for addAll 3")
    void addAll3() {
        LinkedList<String> linkedList1 = createLinkedList();
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(("1"));
        linkedList.add(("2"));
        linkedList.add(("3"));
        assertTrue(myLinkedList.addAll(1, linkedList));
        assertTrue(linkedList1.addAll(1, linkedList));
        assertArrayEquals(myLinkedList.toArray(), linkedList1.toArray());
    }


    @Test
    @DisplayName("Test for addAll 4")
    void addAll4() {
        LinkedList<String> linkedList1 = createLinkedList();
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(("1"));
        linkedList.add(("2"));
        linkedList.add(("3"));
        assertTrue(myLinkedList.addAll(myLinkedList.size(), linkedList));
        assertTrue(linkedList1.addAll(linkedList1.size(), linkedList));
        assertArrayEquals(myLinkedList.toArray(), linkedList1.toArray());
    }

    @Test
    @DisplayName("Test for addAll 5")
    void addAll5() {
        LinkedList<String> linkedList1 = createLinkedList();
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(("1"));
        linkedList.add(("2"));
        linkedList.add(("3"));
        assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.addAll(7, linkedList));
    }

    @Test
    @DisplayName("Test for getNode")
    void getNode() {
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        assertEquals("Java", myLinkedList.get(0));
        assertEquals("is", myLinkedList.get(1));
        assertEquals("fun", myLinkedList.get(2));
        System.out.println(myLinkedList.size());
        assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.get(3));

    }


    @Test
    @DisplayName("Test for remove 1")
    void removeFirst() {
        LinkedList<String> linkedList = createLinkedList();
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        myLinkedList.remove(0);
        linkedList.remove(0);
        assertArrayEquals(myLinkedList.toArray(), linkedList.toArray());
    }

    @Test
    @DisplayName("Test for remove 2")
    void removeLast() {
        LinkedList<String> linkedList = createLinkedList();
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        myLinkedList.remove(2);
        linkedList.remove(2);
        assertArrayEquals(myLinkedList.toArray(), linkedList.toArray());
    }

    @Test
    @DisplayName("Test for remove 3")
    void removeInside() {
        LinkedList<String> linkedList = createLinkedList();
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        myLinkedList.remove(1);
        linkedList.remove(1);
        assertArrayEquals(myLinkedList.toArray(), linkedList.toArray());
    }

    @Test
    @DisplayName("Test for remove 4")
    void removeEmpty() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        assertThrows(IllegalStateException.class, () -> myLinkedList.remove(1));
    }

    @Test
    @DisplayName("Test for remove 5")
    void removeInvalidIndex() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("Java");
        assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.remove(-1));
    }


    @Test
    @DisplayName("Test for removeAll 1")
    void removeAll() {
        LinkedList<String> linkedList1 = createLinkedList();
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(("Java"));
        linkedList.add(("is"));
        assertTrue(myLinkedList.removeAll(linkedList));
        assertTrue(linkedList1.removeAll(linkedList));
        assertArrayEquals(myLinkedList.toArray(), linkedList1.toArray());
    }

    @Test
    @DisplayName("Test for removeAll 2")
    void removeAll2() {
        LinkedList<String> linkedList1 = createLinkedList();
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(("Python"));
        linkedList.add(("is"));
        assertTrue(myLinkedList.removeAll(linkedList));
        assertTrue(linkedList1.removeAll(linkedList));
        assertArrayEquals(linkedList1.toArray(), myLinkedList.toArray());
    }

    @Test
    @DisplayName("Test for clear")
    void clear() {
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        myLinkedList.clear();
        assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.get(0));
    }


    @Test
    @DisplayName("Test for set")
    void set() {
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        myLinkedList.set(0, "JS");
        assertEquals("JS", myLinkedList.get(0));
    }

    @Test
    @DisplayName("Test for lastIndexOf")
    void lastIndexOf() {
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        LinkedList<String> linkedList = createLinkedList();
        assertEquals(0, myLinkedList.lastIndexOf("Java"));
        assertEquals(linkedList.lastIndexOf("Java"), myLinkedList.lastIndexOf("Java"));
    }

    @Test
    @DisplayName("Test for lastIndexOf 2")
    void lastIndexOf2() {
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        LinkedList<String> linkedList = createLinkedList();
        myLinkedList.add("Java");
        linkedList.add("Java");
        assertEquals(3, myLinkedList.lastIndexOf("Java"));
        assertEquals(linkedList.lastIndexOf("Java"), myLinkedList.lastIndexOf("Java"));
    }

    @Test
    @DisplayName("Test for lastIndexOf 3")
    void lastIndexOf3() {
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        LinkedList<String> linkedList = createLinkedList();
        assertEquals(-1, myLinkedList.lastIndexOf("Python"));
        assertEquals(linkedList.lastIndexOf("Python"), myLinkedList.lastIndexOf("Python"));
    }

    @Test
    @DisplayName("Test for sublist 1")
    void sublist() {
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        LinkedList<String> linkedList = createLinkedList();
        LinkedList<String> linkedList1 = new LinkedList<>();
        linkedList1.add("Java");
        assertArrayEquals(linkedList1.toArray(), myLinkedList.subList(0, 1).toArray());
        assertArrayEquals(linkedList1.toArray(), linkedList.subList(0, 1).toArray());
        assertArrayEquals(linkedList.subList(0,2).toArray(), myLinkedList.subList(0, 2).toArray());
    }

    @Test
    @DisplayName("Test for sublist 2")
    void sublist2() {
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.subList(-1, 7));
    }

    @Test
    @DisplayName("Test for sublist 3")
    void sublist3() {
        MyLinkedList<String> myLinkedList = createMyLinkedList();
        assertThrows(IllegalArgumentException.class, () -> myLinkedList.subList(2, 0));
    }

}