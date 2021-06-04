package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.VirtualMachine;

public class WriteMemory extends Operation {

    public WriteMemory(int address, VirtualMachine vm) {
        super(address, vm);
    }

    @Override
    public void execute() {
        setValue(getValue(args[0]), args[1]);
    }

    @Override
    public String opCode() {
        return "wmem";
    }

    @Override
    public int numArgs() {
        return 2;
    }
}
