package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.VirtualMachine;

public class Noop extends Operation {

    public Noop(int address, VirtualMachine vm) {
        super(address, vm);
    }

    @Override
    public void execute() {
        // noop
    }

    @Override
    public String opCode() {
        return "noop";
    }

    @Override
    public int numArgs() {
        return 0;
    }
}
