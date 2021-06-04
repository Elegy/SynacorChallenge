package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.VirtualMachine;

public class JumpTrue extends Operation {

    public JumpTrue(int address, VirtualMachine vm) {
        super(address, vm);
    }

    @Override
    public void execute() {
        int condition = getValue(args[0]);
        if (condition != 0) {
            int jumpAddress = getValue(args[1]);
            vm.jump(jumpAddress);
        }
    }

    @Override
    public String opCode() {
        return "jt";
    }

    @Override
    public int numArgs() {
        return 2;
    }
}
