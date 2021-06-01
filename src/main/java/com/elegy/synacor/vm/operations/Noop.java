package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.Memory;

public class Noop extends Operation {

    public Noop(int address, Memory ram, Memory registers) {
        super(address, ram, registers);
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
