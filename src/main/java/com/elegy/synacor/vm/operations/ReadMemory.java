package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.VirtualMachine;

public class ReadMemory extends Operation {

    public ReadMemory(int address, VirtualMachine vm) {
        super(address, vm);
    }

    @Override
    public void execute() {
        int value = vm.getRam().read(getValue(args[1]));
        setValue(args[0], value);
    }

    @Override
    public String opCode() {
        return "rmem";
    }

    @Override
    public int numArgs() {
        return 2;
    }
}
