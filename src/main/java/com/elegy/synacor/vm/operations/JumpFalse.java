package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.VirtualMachine;

public class JumpFalse extends Operation {

    public JumpFalse(int address, VirtualMachine vm) {
        super(address, vm);
    }

    @Override
    public void execute() {
        int condition = getValue(first());
        if (condition == 0) {
            int jumpAddress = getValue(second());
            vm.jump(jumpAddress);
        }
    }

    @Override
    public String opCode() {
        return "jf";
    }

    @Override
    public int numArgs() {
        return 2;
    }
}
