package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.VirtualMachine;

public class Not extends Operation {

    public Not(int address, VirtualMachine vm) {
        super(address, vm);
    }

    @Override
    public void execute() {
        int b = getValue(args[1]);
        int result = ~b & 0x7FFF; // 15-bit inverse
        setValue(args[0], result);
    }

    @Override
    public String opCode() {
        return "not";
    }

    @Override
    public int numArgs() {
        return 2;
    }
}
