package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.VirtualMachine;

public class Call extends Operation {

    public Call(int address, VirtualMachine vm) {
        super(address, vm);
    }

    @Override
    public void execute() {
        int callAddress = getValue(args[0]);
        vm.call(callAddress);
    }

    @Override
    public String opCode() {
        return "call";
    }

    @Override
    public int numArgs() {
        return 1;
    }
}
