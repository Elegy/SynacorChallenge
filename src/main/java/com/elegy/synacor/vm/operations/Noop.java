package com.elegy.synacor.vm.operations;

public class Noop extends Operation {

    public Noop(int address, int[] ram, int[] registers) {
        super(address, ram, registers);
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
