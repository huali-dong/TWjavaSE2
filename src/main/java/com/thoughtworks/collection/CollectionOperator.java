package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();
        if(left<right){
            for (int i=left;i<=right;i++){
                list.add(i);
            }
        }else{
            for (int i=left;i>=right;i--){
                list.add(i);
            }
        }
        return list;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        List<Integer> listByInterval = getListByInterval(left, right);
        return listByInterval.stream().filter(item->item%2==0).collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).boxed().filter(item -> item % 2 == 0).collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return array[array.length-1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> firstCollection = Arrays.stream(firstArray).boxed().collect(Collectors.toList());
        List<Integer> secondCollection = Arrays.stream(secondArray).boxed().collect(Collectors.toList());
        return firstCollection.stream().filter(secondCollection::contains).collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> firstCollection = Arrays.asList(firstArray);
        List<Integer> secondCollection =  Arrays.asList(secondArray);
        list.addAll(firstCollection);
        list.addAll(secondCollection);
        return  list.stream().distinct().collect(Collectors.toList());
    }
}
