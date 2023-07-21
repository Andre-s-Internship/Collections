package org.example;

import java.io.StringBufferInputStream;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("Java");
        myLinkedList.add("is");
        myLinkedList.add("fun");
        System.out.println(myLinkedList.size());
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Java");
        hashSet.add("is");
        hashSet.add("fun");
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("Java");
        hashSet1.add("is");
        hashSet1.add("fun");
//        for(String s : myLinkedList){
//            System.out.println(s);
//        }


    }
}

