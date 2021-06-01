package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.Memory;

import java.util.Stack;

public class OperationLoader {

    private final Memory ram;
    private final Memory registers;
    private final Stack<Integer> stack;

    public OperationLoader(Memory ram, Memory registers, Stack<Integer> stack) {
        this.ram = ram;
        this.registers = registers;
        this.stack = stack;
    }

    public Operation load(int address) {
        int opcode = ram.read(address);
        switch (opcode) {
            case 0:
                return null;
            case 6:
                return new Jump(address, ram, registers, stack);
            case 19:
                return new Out(address, ram, registers, stack);
            case 21:
                return new Noop(address, ram, registers, stack);
            default:
                System.out.println("Unsupported operation with opcode " + opcode);
                return null;
        }
    }
}
