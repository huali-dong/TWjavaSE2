package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int max = leftBorder<rightBorder?rightBorder:leftBorder;
        int min = leftBorder>rightBorder?rightBorder:leftBorder;
        int sum = 0;
        for(int i=min;i<=max;i++){
            if(i%2==0){
                sum=sum+i;
            }
        }
        return sum;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int max = leftBorder<rightBorder?rightBorder:leftBorder;
        int min = leftBorder>rightBorder?rightBorder:leftBorder;
        int sum = 0;
        for(int i=min;i<=max;i++){
            if(i%2!=0){
                sum=sum+i;
            }
        }
        return sum;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().reduce(0,(sum,item)->sum+(3*item+2));
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i)%2==1){
                arrayList.set(i,arrayList.get(i)*3+2);
            }
        }
        return  arrayList;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(item->item%2==1).reduce(0,(sum,item)->sum+(3*item+5));
    }

    public double getMedianOfEven(List<Integer> list) {
        List<Integer> newList = list.stream().filter(item -> item % 2 == 0).collect(Collectors.toList());
        int mid = newList.size()/2;
        if (newList.size()%2==0){
            return (newList.get(mid-1)+newList.get(mid))/2;
        }else{
            return newList.get(mid);
        }
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        long count = arrayList.stream().filter(item -> item % 2 == 0).count();
        Integer sum = arrayList.stream().filter(item -> item % 2 == 0).reduce(0, (sum1, item) -> sum1 + item);
        return (double)sum/count;
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream().filter(item->item%2==0).anyMatch(item->item==specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(item -> item % 2 == 0).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> even = arrayList.stream().filter(item -> item % 2 == 0)
                .sorted().collect(Collectors.toList());
        List<Integer> odd = arrayList.stream().filter(item -> item % 2 == 1)
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        even.addAll(odd);
        return even;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            if(i+1<arrayList.size()){
                list.add(3*(arrayList.get(i)+arrayList.get(i+1)));
            }
        }
        return list;

    }
}
