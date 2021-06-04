package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.VirtualMachine;

public class Modulo extends Operation {

    public Modulo(int address, VirtualMachine vm) {
        super(address, vm);
    }

    @Override
    public void execute() {
        int b = getValue(args[1]);
        int c = getValue(args[2]);
        setValue(args[0], b % c);
    }

    @Override
    public String opCode() {
        return "mod";
    }

    @Override
    public int numArgs() {
        return 3;
    }
}
