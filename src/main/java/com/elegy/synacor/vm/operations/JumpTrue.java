package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.Memory;

import java.util.Stack;

public class JumpTrue extends Operation {

    public JumpTrue(int address, Memory ram, Memory registers, Stack<Integer> stack) {
        super(address, ram, registers, stack);
    }

    @Override
    public void execute() {
        int condition = getValue(first());
        if (condition != 0) {
            int jumpAddress = getValue(second());
            stack.push(jumpAddress);
        }
    }

    @Override
    public String opCode() {
        return "jt";
    }

    @Override
    public int numArgs() {
        return 2;
    }
}
