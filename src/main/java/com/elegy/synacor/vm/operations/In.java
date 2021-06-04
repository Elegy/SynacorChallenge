package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.VirtualMachine;

public class In extends Operation {

    public In(int address, VirtualMachine vm) {
        super(address, vm);
    }

    @Override
    public void execute() {
        if (!vm.hasInput()) {
            vm.setBlocked(true);
            vm.jump(address);
        } else {
            setValue(args[0], vm.readNextInput());
        }
    }

    @Override
    public String opCode() {
        return "in";
    }

    @Override
    public int numArgs() {
        return 1;
    }
}
