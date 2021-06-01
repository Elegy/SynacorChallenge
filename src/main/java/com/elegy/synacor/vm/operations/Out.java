package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.Memory;

public class Out extends Operation {

    public Out(int address, Memory ram, Memory registers) {
        super(address, ram, registers);
    }

    @Override
    public void execute() {
        System.out.print((char) getValue(first()));
    }

    @Override
    public String opCode() {
        return "out";
    }

    @Override
    public int numArgs() {
        return 1;
    }
}
