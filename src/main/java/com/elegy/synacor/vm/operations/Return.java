package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.VirtualMachine;

public class Return extends Operation {

    public Return(int address, VirtualMachine vm) {
        super(address, vm);
    }

    @Override
    public void execute() {
        vm.ret();
    }

    @Override
    public String opCode() {
        return "ret";
    }

    @Override
    public int numArgs() {
        return 0;
    }
}
