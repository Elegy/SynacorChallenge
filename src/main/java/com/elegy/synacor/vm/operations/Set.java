package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.VirtualMachine;

public class Set extends Operation {

    public Set(int address, VirtualMachine vm) {
        super(address, vm);
    }

    @Override
    public void execute() {
        setValue(args[0], args[1]);
    }

    @Override
    public String opCode() {
        return "set";
    }

    @Override
    public int numArgs() {
        return 2;
    }
}
