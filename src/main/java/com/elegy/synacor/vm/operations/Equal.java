package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.VirtualMachine;

public class Equal extends Operation {

    public Equal(int address, VirtualMachine vm) {
        super(address, vm);
    }

    @Override
    public void execute() {
        int b = getValue(args[1]);
        int c = getValue(args[2]);

        int result = (b == c) ? 1 : 0;
        setValue(args[0], result);
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
