package com.company.algorithm;


public class Array {
    private int[] data;
    private int size;

    /**
     * @param capacity
     */
    //数组构造函数，传入数组的容量
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    //获取数组中元素的个数
    public int getSize() {
        return size;
    }

    //获取数组的容量
    public int getCapacity() {
        return data.length;
    }
    //返回数组是否为空
    public boolean isEmpty(){
        return size==0;
    }
    //在数组的第一位添加新的元素
    public void addFirst(int e){
        add(0,e);
    }
    //向数组中添加新的元素
    public void addLast(int e){
        add(size,e);
    }
    //向数组中指定位置index添加元素e
    public void add(int index,int e){
        if(size==data.length){
            throw new IllegalArgumentException("AddLast failed,Array is full");
        }
        if(index<0||index>size){
            throw new IllegalArgumentException("AddLast failed,Require index>0 or index<size");
        }
        for(int i=size-1;i>=index;i--){
            data[i+1]=data[i];
        }
        data[index]=e;
        size++;
    }

}
