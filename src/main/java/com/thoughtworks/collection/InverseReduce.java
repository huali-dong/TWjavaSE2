package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        Integer nextInt = random.nextInt(3);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=number-nextInt;i>0;i=i-nextInt){
            list.add(i);
        }
        return list;
    }
}
