package com.elegy.synacor.vm.operations;

public class OperationLoader {

    private final int[] ram;
    private final int[] registers;

    public OperationLoader(int[] ram, int[] registers) {
        this.ram = ram;
        this.registers = registers;
    }

    public Operation load(int address) {
        int opcode = ram[address];
        switch (opcode) {
            case 19:
                return new Out(address, ram, registers);
            case 21:
                return new Noop(address, ram, registers);
            default:
                return null;
        }
    }
}
