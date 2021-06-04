package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.VirtualMachine;

public class Pop extends Operation {

    public Pop(int address, VirtualMachine vm) {
        super(address, vm);
    }

    @Override
    public void execute() {
        if (vm.getStack().isEmpty()) {
            throw new RuntimeException("Cannot pop an empty stack: " + this);
        }
        int value = vm.getStack().pop();
        setValue(args[0], value);
    }

    @Override
    public String opCode() {
        return "pop";
    }

    @Override
    public int numArgs() {
        return 1;
    }
}
