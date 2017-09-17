/*Copyright 1999-2015. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by liangzixing on 15/8/20.
 */
public class NumberUtil {

    public static <T extends Number> boolean isPositive(T t) {
        if (t == null) {
            return false;
        }

        Number n = t;

        if (t instanceof Double
                || t instanceof Float) {
            return t.doubleValue() > 0;
        }

        return t.longValue() > 0;
    }

    public static <T extends Number> boolean isNotPositive(T t) {
        return !isPositive(t);
    }

    public static long plus(Long ... args){
       return Stream.of(args).mapToLong(l -> toPositive(l)).sum();
    }

    public static int plus(Integer ... args){
        return Stream.of(args).mapToInt(l -> toPositive(l)).sum();
    }

    public static <T extends Number> boolean isAllPositive(T... t) {
        if (t == null || t.length == 0) {
            return false;
        }

        for (T temp : t) {
            if (!isPositive(temp)) {
                return false;
            }
        }

        return true;
    }

    public static <T extends Number> boolean isAllPositive(Collection<T> Collection) {
        if (Collection == null || Collection.size() == 0) {
            return false;
        }

        Iterator<T> t = Collection.iterator();

        while (t.hasNext()) {
            Number n = t.next();
            if (!isPositive(n)) {
                return false;
            }
        }

        return true;
    }


    public static <K extends Number, V extends Number> boolean isKVAllPositive(Map<K, V> map) {

        if (map == null || map.size() == 0) {
            return false;
        }

        return isKeyAllPositive(map) && isValueAllPositive(map);
    }


    public static <V extends Number> boolean isValueAllPositive(Map<?, V> map) {
        if (map == null || map.size() == 0) {
            return false;
        }

        return isAllPositive(map.values());
    }

    public static <K extends Number> boolean isKeyAllPositive(Map<K, ?> map) {

        if (map == null || map.size() == 0) {
            return false;
        }

        return isAllPositive(map.keySet());
    }

    public static <T extends Number> void removeAllUnPositiveElement(Collection<T> Collection) {
        if (Collection == null || Collection.size() == 0) {
            return;
        }

        List<T> needRemoveElement = new ArrayList<T>();

        Iterator<T> t = Collection.iterator();
        while (t.hasNext()) {
            T n = t.next();
            if (!isPositive(n)) {
                needRemoveElement.add(n);
            }
        }

        Collection.removeAll(needRemoveElement);
    }


    public static long toLong(String s, long defaultValue){

        if (s == null || s.isEmpty()) {
            return defaultValue;
        }

        try {
            return Long.valueOf(s);
        } catch (Exception e){
            return defaultValue;
        }
    }

    public static long toPositive(Long l){
      return isPositive(l) ? l : 0;
    }

    public static Integer toPositive(Integer l){
        return toPositive(l, 0);
    }

    public static Integer toPositive(Integer l, int defaultValue){
        return isPositive(l) ? l : defaultValue;
    }

    public static int toInt( String s, int defaultValue){

        if (s == null || s.isEmpty()) {
            return defaultValue;
        }

        try {
            return Integer.valueOf(s);
        } catch (Exception e){
            return defaultValue;
        }
    }

    public static int toPositiveInt(String s){
        if (s == null || s.isEmpty()) {
            return 0;
        }

        try {
            int result = Integer.valueOf(s);
            return result > 0 ? result : 0;
        } catch (Exception e){
            return 0;
        }
    }

    public static int toPositiveInt(Integer i){
        if (i == null) {
            return 0;
        }

        try {
            int result = Integer.valueOf(i);
            return result > 0 ? result : 0;
        } catch (Exception e){
            return 0;
        }
    }

    public static int toInt(String s){
        return toInt(s, 0);
    }

    public static int positiveMinus1(int reduction, int defaultNum){
        return (reduction - 1 > 0) ? (reduction -1) : defaultNum;
    }

    public static int positiveMinus1(int reduction){
        return positiveMinus1(reduction, 0);
    }


    public static int positiveMinus(int reduction, int minuend){
        return reduction - minuend > 0 ? (reduction - minuend) : 0;
    }

    /**
     * ·µ»ØÒ»¸öÉýÐòµÄÊý×ÖÅÅÐòÆ÷
     * @param <T>
     * @return ÅÅÐòÆ÷
     */
    public static <T extends Number> Comparator<T> ascComparator(){
        return (n1, n2) -> {
            if (n1.equals(n2)) {
                return 0;
            } else if (n1 instanceof Double || n1 instanceof Float) {
                return n1.doubleValue() > n2.doubleValue() ? 1 : -1;
            } else {
                return n1.longValue() > n2.longValue() ? 1 : -1;
            }
        };
    }

    /**
     * ·µ»ØÒ»¸ö½µÐòµÄÊý×ÖÅÅÐòÆ÷
     * @param <T>
     * @return
     */
    public static <T extends Number> Comparator<T> descComparator(){
        return (n1, n2) -> {
            if (n1.equals(n2)) {
                return 0;
            } else if (n1 instanceof Double || n1 instanceof Float) {
                return n1.doubleValue() > n2.doubleValue() ? -1 : 1;
            } else {
                return n1.longValue() > n2.longValue() ? -1 : 1;
            }
        };
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,34,556,78,23,6,768,98,23);
        list.sort(descComparator());
        System.out.println(Arrays.toString(list.toArray()));

        List<Double> list2 = Arrays.asList(0.00D, 1.21D, 0.33D, 1234D, 32.32D, 0.00D, 2.12D, 1.21D);
        list2.sort(ascComparator());
        System.out.println(Arrays.toString(list2.toArray()));
    }

    public static long firstPositive(Long... ls) {
        return Stream.of(ls).filter(l -> isPositive(l)).findFirst().orElse(0l);
    }
}