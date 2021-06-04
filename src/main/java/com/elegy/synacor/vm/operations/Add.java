package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.VirtualMachine;

public class Add extends Operation {

    public Add(int address, VirtualMachine vm) {
        super(address, vm);
    }

    @Override
    public void execute() {
        int b = getValue(second());
        int c = getValue(third());
        int result = (b + c) % (Short.MAX_VALUE + 1);
        setValue(first(), result);
    }

    @Override
    public String opCode() {
        return "add";
    }

    @Override
    public int numArgs() {
        return 3;
    }
}
