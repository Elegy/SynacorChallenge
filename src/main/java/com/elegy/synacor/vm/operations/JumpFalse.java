package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.Memory;

import java.util.Stack;

public class JumpFalse extends Operation {

    public JumpFalse(int address, Memory ram, Memory registers, Stack<Integer> stack) {
        super(address, ram, registers, stack);
    }

    @Override
    public void execute() {
        int condition = getValue(first());
        if (condition == 0) {
            int jumpAddress = getValue(second());
            stack.push(jumpAddress);
        }
    }

    @Override
    public String opCode() {
        return "jf";
    }

    @Override
    public int numArgs() {
        return 2;
    }
}
