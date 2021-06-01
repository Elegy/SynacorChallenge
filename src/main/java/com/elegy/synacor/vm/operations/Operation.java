package com.elegy.synacor.vm.operations;

public abstract class Operation {

    protected final int address;
    private final int[] ram;
    private final int[] registers;

    protected Operation(int address, int[] ram, int[] registers) {
        this.address = address;
        this.ram = ram;
        this.registers = registers;
    }

    public abstract void execute();

    public abstract String opCode();

    public abstract int numArgs();

    public final int nextAddress() {
        return address + 1 + numArgs();
    }

    protected final int first() {
        return ram[address + 1];
    }

    protected final int second() {
        return ram[address + 2];
    }

    protected final int getValue(int rawValue) {
        if (rawValue <= Short.MAX_VALUE) {
            return rawValue;
        }
        return registers[rawValue - Short.MAX_VALUE];
    }
}
