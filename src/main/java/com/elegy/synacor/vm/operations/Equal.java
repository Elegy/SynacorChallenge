package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.VirtualMachine;

public class Equal extends Operation {

    public Equal(int address, VirtualMachine vm) {
        super(address, vm);
    }

    @Override
    public void execute() {
        int b = getValue(second());
        int c = getValue(third());
        int result = (b == c) ? 1 : 0;
        setValue(first(), result);
    }

    @Override
    public String opCode() {
        return "eq";
    }

    @Override
    public int numArgs() {
        return 3;
    }
}
