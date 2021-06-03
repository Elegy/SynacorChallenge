package com.elegy.synacor.vm;

import com.elegy.synacor.vm.operations.*;

import java.net.URL;
import java.nio.file.Paths;
import java.util.Stack;

public class VirtualMachine {

    private static final int RAM_SIZE = 32768;
    private static final int REGISTER_COUNT = 8;

    private final Memory ram;
    private final Memory registers;
    private final Stack<Operation> stack;

    public VirtualMachine() {
        this.ram = new Memory(RAM_SIZE);
        this.registers = new Memory(REGISTER_COUNT);
        this.stack = new Stack<>();
    }

    public Memory getRam() {
        return ram;
    }

    public Memory getRegisters() {
        return registers;
    }

    public void run() {
        stack.add(loadOperation(0));
        while (!stack.isEmpty() && stack.peek() != null) {
            Operation curr = stack.pop();
            stack.push(loadOperation(curr.nextAddress()));
            curr.execute();
        }
    }

    public void loadProgram(String filename) {
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

    public void jump(int address) {
        stack.push(loadOperation(address));
    }

    private Operation loadOperation(int address) {
        int opcode = ram.read(address);
        switch (opcode) {
            case 0:
                return null;
            case 1:
                return new Set(address, this);
            case 6:
                return new Jump(address, this);
            case 7:
                return new JumpTrue(address, this);
            case 8:
                return new JumpFalse(address, this);
            case 19:
                return new Out(address, this);
            case 21:
                return new Noop(address, this);
            default:
                System.out.println("Unsupported operation with opcode " + opcode);
                return null;
        }
    }

    public static void main(String[] args) {
        VirtualMachine vm = new VirtualMachine();
        vm.loadProgram("challenge.bin");
        vm.run();
    }
}
