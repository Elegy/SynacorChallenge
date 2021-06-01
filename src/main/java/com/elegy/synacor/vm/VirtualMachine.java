package com.elegy.synacor.vm;

import com.elegy.synacor.vm.operations.Operation;
import com.elegy.synacor.vm.operations.OperationLoader;

import java.net.URL;
import java.nio.file.Paths;

public class VirtualMachine {

    private static final int RAM_SIZE = 32768;
    private static final int REGISTER_COUNT = 8;

    private final Memory ram;
    private final Memory registers;
    private final OperationLoader operationLoader;

    private int programCounter;

    public VirtualMachine() {
        this.ram = new Memory(RAM_SIZE);
        this.registers = new Memory(REGISTER_COUNT);
        this.operationLoader = new OperationLoader(ram, registers);
        this.programCounter = 0;
    }

    public void load(String filename) {
        URL resource = getClass().getClassLoader().getResource(filename);
        if (resource == null) {
            throw new RuntimeException(filename + " not found");
        }
        try {
            ram.load(new BlockReader().read(Paths.get(resource.toURI())));
        } catch (Exception e) {
            throw new RuntimeException("Failure loading memory from " + filename, e);
        }
    }

    public void run() {
        Operation current = operationLoader.load(programCounter);
        while (current != null) {
            current.execute();
            this.programCounter = current.nextAddress();
            current = operationLoader.load(programCounter);
        }
    }

    public static void main(String[] args) {
        VirtualMachine vm = new VirtualMachine();
        vm.load("challenge.bin");
        vm.run();
    }
}
