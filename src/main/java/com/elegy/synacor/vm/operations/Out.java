package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.Memory;

import java.util.Stack;

public class Out extends Operation {

    public Out(int address, Memory ram, Memory registers, Stack<Integer> stack) {
        super(address, ram, registers, stack);
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
