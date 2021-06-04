package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.VirtualMachine;

public class Push extends Operation {

    public Push(int address, VirtualMachine vm) {
        super(address, vm);
    }

    @Override
    public void execute() {
        int a = getValue(args[0]);
        vm.getStack().push(a);
    }

    @Override
    public String opCode() {
        return "push";
    }

    @Override
    public int numArgs() {
        return 1;
    }
}
