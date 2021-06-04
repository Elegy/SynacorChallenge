package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.VirtualMachine;

public class Multiply extends Operation {

    public Multiply(int address, VirtualMachine vm) {
        super(address, vm);
    }

    @Override
    public void execute() {
        int b = getValue(args[1]);
        int c = getValue(args[2]);

        int result = (b * c) % (Short.MAX_VALUE + 1);
        setValue(args[0], result);
    }

    @Override
    public String opCode() {
        return "mult";
    }

    @Override
    public int numArgs() {
        return 3;
    }
}
