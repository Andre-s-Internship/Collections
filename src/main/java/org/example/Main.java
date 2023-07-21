package org.example;

import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("Java");
        myLinkedList.add("is");
        myLinkedList.add("fun");
        System.out.println(myLinkedList.size());
//        for(String s : myLinkedList){
//            System.out.println(s);
//        }


    }
}

