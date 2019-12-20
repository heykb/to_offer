package com.zhu;

import java.util.*;

/**
 * 找重复数字
 */
public class 找重复数 {


    public static void quickSort(Integer[] in,int start,int end){
        if(start >= end){
            return;
        }
        int left = start;
        int right = end;
        int mid=left;
        while(left < right){

            while(in[right]>=in[mid] && left < right){
                right--;
            }
            while(in[left]<=in[mid] && left < right) {
                left++;
            }
            if(left < right ){
                int temp = in[left];
                in[left] = in[right];
                in[right] = temp;
            }
        }
        {
            int temp = in[mid];
            in[mid] = in[left];
            in[left] = temp;
        }
        quickSort(in,start,left-1);
        quickSort(in,left+1,end);
    }

    //先排序在查重
    static boolean fun01(Integer[] in){
        quickSort(in,0,in.length-1);
        for(int i=1;i<in.length;i++){
            if(in[i]==in[i-1]){
                return false;
            }
        }
        return true;
    }
    //使用hashset
    static boolean fun02(Integer[] in){
        HashSet set = new HashSet();
        Collections.addAll(set,in);

        if(set.size() < in.length-1){
            return false;
        }
        return true;
    }
    //将数字放到对应位置去
    static boolean fun03(Integer[] in){
        for(int i=0;i<in.length;i++){
            if(in[i]!=i){
                int value = in[i];
                if(in[value]==value){
                    return false;
                }
                in[i] = in[value];
                in[value] = value;
            }
        }
        return true;
    }
    static int count(Integer[] in, int start,int end){
        int count=0;
        for(int i:in){
            if(in[i]>=start&&i<=end){
                ++count;
            }
        }
        return count;
    }
    static int fun04(Integer[] in,boolean flag){
        int start = 0;
        int end=in.length-1;
        while(start<=end){
            int mid = start+(end-start)/2+(flag?0:1);
            int count = count(in,start,mid);
            if(end==start){
                if(count>1){
                    return start;
                }else break;
            }
            if(count>mid-start+1){
                end=mid;
            }else start=mid+1;
        }
        return -1;
    }
    public boolean Find(int target, int [][] array) {
        int colCount = array[0].length;
        int rowCount = array.length;
        int row=0;
        int col=colCount-1;
        while(row<rowCount&&col>=0){
            int cul = array[row][col];
            if(target==cul){
                return true;
            }else if( target>cul ){
                row++;
            }else col--;
        }
        return false;

    }
    public static void main(String[] args) {
        /*Integer[] in = {2,3,4,0,2,5,6};

        System.out.println(fun01(in));
        System.out.println(fun02(in));
        System.out.println(fun03(in));
        System.out.println(fun04(in,false));
        System.out.println(fun04(in,true));*/
        int[][] array = {{1,2,3,4},{1,2,3,4}};
        System.out.println(array[0].length);
        System.out.println(array.length);
        StringBuffer s = new StringBuffer("fdf fdsf dfs");
        System.out.println(s.toString().replaceAll("\\s","%20"));

    }
}
