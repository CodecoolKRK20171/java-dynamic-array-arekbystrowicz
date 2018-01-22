package com.codecool.dynamicArrayDojo;


public class DynamicIntArray {

    private static final int DEFAULT = 1;

    private int[] array;
    private int size;
    private int index;

    public DynamicIntArray() {
        this.array = new int[DEFAULT];
        this.size = DEFAULT;
        this.index = 0;
    }

    public DynamicIntArray(int size) {
        this.array = new int[size];
        this.size = size;
        this.index = 0;
    }
    
}
