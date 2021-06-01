package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.Memory;

public abstract class Operation {

    protected final int address;
    private final Memory ram;
    private final Memory registers;

    protected Operation(int address, Memory ram, Memory registers) {
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
        return ram.read(address + 1);
    }

    protected final int second() {
        return ram.read(address + 2);
    }

    protected final int getValue(int rawValue) {
        if (rawValue <= Short.MAX_VALUE) {
            return rawValue;
        }
        return registers.read(rawValue - Short.MAX_VALUE);
    }
}
