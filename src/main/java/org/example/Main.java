package org.example;

import java.io.StringBufferInputStream;
import java.util.*;

public class Main {
    public static void main(String[] args) {
            MyTreeMap<Integer, String> myTreeMap = new MyTreeMap<>();
            myTreeMap.put(1, "Java");
            myTreeMap.put(2, "is");
            myTreeMap.put(3, "fun");
            TreeMap<Integer, String> treeMap = new TreeMap<>();
            treeMap.put(1, "Java");
            treeMap.put(2, "is");
            treeMap.put(3, "fun");
        System.out.println(treeMap.entrySet());
        for(MyTreeMap.Entry<Integer, String> entry: myTreeMap.entries) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}

