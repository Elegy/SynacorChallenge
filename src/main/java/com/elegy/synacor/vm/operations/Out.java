package com.elegy.synacor.vm.operations;

public class Out extends Operation {

    public Out(int address, int[] ram, int[] registers) {
        super(address, ram, registers);
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
