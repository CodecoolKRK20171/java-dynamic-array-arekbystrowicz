package com.codecool.dynamicArrayDojo;


public class DynamicIntArray {

    // default size of created DIA
    private static final int DEFAULT_CAP = 1;
    // new indexes added to DIA when out of space
    private static final int APPENDED_CAP = 1;

    private int[] array;
    private int size;
    private int index;

    public DynamicIntArray() {
        this.array = new int[DEFAULT_CAP];
        this.size = DEFAULT_CAP;
        this.index = 0;
    }

    public DynamicIntArray(int size) {
        this.array = new int[size];
        this.size = size;
        this.index = 0;
    }

    public String toString() {
        String asString = "";
        for(int element : this.array) {
            asString += " " + element;
        }

        return asString;
    }

    public void add(int integer) {
        if(this.isFilled()) {
            this.addIndexes(APPENDED_CAP);
        }
        this.array[index++] = integer;
    }

    private boolean isFilled() {
        return this.index == this.size;
    }

    private void addIndexes(int amount) {
        int[] newArray = new int[this.size + amount];
        for(int i = 0; i < this.size; i++) {
            newArray[i] = this.array[i];
        }
        this.size += amount;
        this.array = newArray;
    }

    public void remove(int integer) throws ArrayIndexOutOfBoundsException {
        int[] newArray = new int[this.size-1];

        int counter = 0;
        for(int i = 0, j = 0; i < this.size; i++) {
            if(this.array[i] != integer) {
                newArray[j++] = this.array[i];
            }
            else {
                counter++;
            }
        }

        this.array = newArray;
        this.size--;
        this.index -= counter;
    }

    // TODO [null, 1, 1, null, insertion, null]
    public void insert(int index, int integer) {
        if(index >= this.size) {
            this.add(integer);
        }
        else {
            int[] newArray = new int[this.size+1];
            for(int i = 0, j = 0; i < this.size+1; i++, j++) {
                if(index == i) {
                    newArray[j++] = integer;
                }
                newArray[j] = this.array[i];
            }

            this.array = newArray;
            this.size += 1;
            this.index += 1;
        }

    }

}
