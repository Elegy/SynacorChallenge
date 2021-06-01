package com.elegy.synacor.vm;

public class Memory {

    private final int[] memory;

    public Memory(int size) {
        this.memory = new int[size];
    }

    public void load(int[] data) {
        if (data.length > memory.length) {
            throw new RuntimeException("Out of memory");
        }
        System.arraycopy(data, 0, memory, 0, data.length);
    }

    public int read(int address) {
        return memory[address];
    }

    public void write(int address, int value) {
        memory[address] = value;
    }
}
