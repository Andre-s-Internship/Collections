package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.PriorityQueue;
import static org.junit.jupiter.api.Assertions.*;

class MyPriorityQueueTest {

    MyPriorityQueue<String> createMyPriorityQueue() {
        MyPriorityQueue<String> myPriorityQueue = new MyPriorityQueue<>();
        myPriorityQueue.add("Java");
        myPriorityQueue.add("is");
        myPriorityQueue.add("fun");
        return myPriorityQueue;
    }

    PriorityQueue<String> createPriorityQueue() {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.add("Java");
        priorityQueue.add("is");
        priorityQueue.add("fun");
        return priorityQueue;
    }

    @Test
    @DisplayName("Test for size 1")
    void size() {
        MyPriorityQueue<String> myPriorityQueue = createMyPriorityQueue();
        PriorityQueue<String> priorityQueue = createPriorityQueue();
        assertEquals(3, myPriorityQueue.size());
        assertEquals(priorityQueue.size(), myPriorityQueue.size());
    }

    @Test
    @DisplayName("Test for size 2")
    void sizeEmpty() {
        MyPriorityQueue<String> myPriorityQueue = new MyPriorityQueue<>();
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        assertEquals(0, myPriorityQueue.size());
        assertEquals(priorityQueue.size(), myPriorityQueue.size());
    }
    @Test
    @DisplayName("Test for isEmpty 1")
    void isEmptyTrue() {
        MyPriorityQueue<String> myPriorityQueue = new MyPriorityQueue<>();
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        assertTrue(myPriorityQueue.isEmpty());
        assertEquals(priorityQueue.isEmpty(), myPriorityQueue.isEmpty());
    }

    @Test
    @DisplayName("Test for isEmpty 2")
    void isEmptyFalse() {
        MyPriorityQueue<String> myPriorityQueue = createMyPriorityQueue();
        PriorityQueue<String> priorityQueue = createPriorityQueue();
        assertFalse(myPriorityQueue.isEmpty());
        assertEquals(priorityQueue.isEmpty(), myPriorityQueue.isEmpty());
    }


    @Test
    @DisplayName("Test for add")
    void add() {
        MyPriorityQueue<String> myPriorityQueue = createMyPriorityQueue();
        PriorityQueue<String> priorityQueue = createPriorityQueue();
        myPriorityQueue.add("Python");
        myPriorityQueue.add("is");
        myPriorityQueue.add("not");
        myPriorityQueue.add("fun");
        priorityQueue.add("Python");
        priorityQueue.add("is");
        priorityQueue.add("not");
        priorityQueue.add("fun");
        assertEquals(priorityQueue.peek(), myPriorityQueue.peek());
    }


    @Test
    @DisplayName("Test for peek 1")
    void peek() {
        MyPriorityQueue<String> myPriorityQueue = createMyPriorityQueue();
        PriorityQueue<String> priorityQueue = createPriorityQueue();
        assertEquals(priorityQueue.peek(), myPriorityQueue.peek());
    }
    @Test
    @DisplayName("Test for peek 2")
    void peekEmpty() {
        MyPriorityQueue<String> myPriorityQueue = new MyPriorityQueue<>();
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        assertNull(myPriorityQueue.peek());
        assertEquals(priorityQueue.peek(), myPriorityQueue.peek());
    }

    @Test
    @DisplayName("Test for poll 1")
    void poll() {
        MyPriorityQueue<String> myPriorityQueue = createMyPriorityQueue();
        PriorityQueue<String> priorityQueue = createPriorityQueue();
        assertEquals(priorityQueue.poll(), myPriorityQueue.poll());
    }
    @Test
    @DisplayName("Test for poll 2")
    void pollEmpty() {
        MyPriorityQueue<String> myPriorityQueue = new MyPriorityQueue<>();
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        assertNull(myPriorityQueue.poll());
        assertEquals(priorityQueue.poll(), myPriorityQueue.poll());
    }






}