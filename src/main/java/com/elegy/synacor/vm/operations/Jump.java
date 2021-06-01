package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.Memory;

import java.util.Stack;

public class Jump extends Operation {

    public Jump(int address, Memory ram, Memory registers, Stack<Integer> stack) {
        super(address, ram, registers, stack);
    }

    @Override
    public void execute() {
        int jumpAddress = getValue(first());
        stack.push(jumpAddress);
    }

    @Override
    public String opCode() {
        return "jmp";
    }

    @Override
    public int numArgs() {
        return 1;
    }
}
