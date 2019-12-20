package com.zhu;

public class 旋转数组 {
    public static int findMinInOrder(int[] array){
        for(int i=1;i<array.length;i++){
            if(array[i]<array[i-1]) return array[i];
        }
        return array[0];
    }
    public static int minNumberInRotateArray(int [] array) {
        if(array == null || array.length==0) return 0;

        int start = 0;
        int end = array.length-1;

        while(end-start>1){
            int mid = start+((end-start)>>>1);
            if(array[start] == array[mid]&&array[end] == array[mid])
                return findMinInOrder(array);
            if(array[mid] >= array[start]){
                start = mid;
            }
            if(array[mid] <= array[end]){
                end=mid;
            }
        }
        return array[end];
    }

    public static void main(String[] args) {
        System.out.println(minNumberInRotateArray(new int[]{1,1,1,0,1}));
    }
}
