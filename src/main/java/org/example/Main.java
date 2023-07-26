package org.example;

import java.io.StringBufferInputStream;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Java");
        hashMap.put(2, "is");
        hashMap.put(3, "fun");
        hashMap.put(3, "Python");
        System.out.println(hashMap.entrySet().getClass());

    }
}

