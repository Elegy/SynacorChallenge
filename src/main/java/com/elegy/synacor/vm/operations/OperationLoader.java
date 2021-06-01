package com.elegy.synacor.vm.operations;

import com.elegy.synacor.vm.Memory;

public class OperationLoader {

    private final Memory ram;
    private final Memory registers;

    public OperationLoader(Memory ram, Memory registers) {
        this.ram = ram;
        this.registers = registers;
    }

    public Operation load(int address) {
        int opcode = ram.read(address);
        switch (opcode) {
            case 0:
                return null;
            case 19:
                return new Out(address, ram, registers);
            case 21:
                return new Noop(address, ram, registers);
            default:
                System.out.println("Unsupported operation with opcode " + opcode);
                return null;
        }
    }
}
