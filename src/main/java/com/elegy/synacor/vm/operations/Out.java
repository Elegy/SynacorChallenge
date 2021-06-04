package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.VirtualMachine;

public class Out extends Operation {

    public Out(int address, VirtualMachine vm) {
        super(address, vm);
    }

    @Override
    public void execute() {
        System.out.print((char) getValue(args[0]));
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
