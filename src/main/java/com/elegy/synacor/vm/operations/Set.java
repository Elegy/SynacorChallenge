package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.Memory;

import java.util.Stack;

public class Set extends Operation {

    public Set(int address, Memory ram, Memory registers, Stack<Integer> stack) {
        super(address, ram, registers, stack);
    }

    @Override
    public void execute() {
        setValue(first(), second());
    }

    @Override
    public String opCode() {
        return "set";
    }

    @Override
    public int numArgs() {
        return 2;
    }
}
