package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.VirtualMachine;

public class Jump extends Operation {

    public Jump(int address, VirtualMachine vm) {
        super(address, vm);
    }

    @Override
    public void execute() {
        int jumpAddress = getValue(first());
        vm.jump(jumpAddress);
    }

    @Override
    public String opCode() {
        return "jmp";
    }

    @Override
    public int numArgs() {
        return 1;
    }
}
