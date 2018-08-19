package ru.bellintegrator.practice;

import java.util.HashMap;
import java.util.Map;

public class MyUtilities {

    public static Object packToData(Object o){
        Map result = new HashMap();
        result.put("data",o);
        return result;
    }
}


