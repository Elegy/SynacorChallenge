package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.Memory;

import java.util.Stack;

public class Noop extends Operation {

    public Noop(int address, Memory ram, Memory registers, Stack<Integer> stack) {
        super(address, ram, registers, stack);
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
