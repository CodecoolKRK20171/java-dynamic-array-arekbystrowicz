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

    public String toString() {
        String asString = "";
        for(int element : this.array) {
            asString += " " + element;
        }

        return asString;
    }

    public void add(int integer) {
        if(this.isFilled()) {
            this.addIndexes(1);
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

    public boolean remove(int integer) {
        // first occurrence of provided int
        int[] newArray = new int[this.size-1];

        int i = 0;
        int j = 0;
        boolean removed = false;

        while(j < this.size-1) {
            if(removed) {
                newArray[j++] = this.array[i++];
            }
            else {
                if(this.array[i] == integer) {
                    i++;
                    removed = true;
                }
                else {
                    newArray[j++] = this.array[i++];
                }
            }
        }
        if(removed) {
            this.array = newArray;
            this.size--;
            this.index--;
        }
        return removed;
    }
}
