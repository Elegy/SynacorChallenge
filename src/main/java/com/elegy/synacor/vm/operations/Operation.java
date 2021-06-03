package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.VirtualMachine;

public abstract class Operation {

    protected final VirtualMachine vm;

    private final int address;

    protected Operation(int address, VirtualMachine vm) {
        this.address = address;
        this.vm = vm;
    }

    public abstract void execute();

    public abstract String opCode();

    public abstract int numArgs();

    public final int nextAddress() {
        return address + 1 + numArgs();
    }

    protected final int first() {
        return vm.getRam().read(address + 1);
    }

    protected final int second() {
        return vm.getRam().read(address + 2);
    }

    protected final int getValue(int rawValue) {
        if (!isRegister(rawValue)) {
            return rawValue;
        }
        return vm.getRegisters().read(getRegisterAddress(rawValue));
    }

    protected final void setValue(int rawAddress, int rawValue) {
        if (isRegister(rawAddress)) {
            int address = getRegisterAddress(rawAddress);
            vm.getRegisters().write(address, getValue(rawValue));
        } else {
            vm.getRam().write(rawAddress, getValue(rawValue));
        }
    }

    private boolean isRegister(int rawValue) {
        return rawValue > Short.MAX_VALUE;
    }

    private int getRegisterAddress(int rawAddress) {
        return rawAddress - Short.MAX_VALUE - 1;
    }
}
