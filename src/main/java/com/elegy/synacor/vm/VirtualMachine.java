package com.elegy.synacor.vm;

import com.elegy.synacor.vm.operations.*;

import java.net.URL;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class VirtualMachine {

    private static final int RAM_SIZE = 32768;
    private static final int REGISTER_COUNT = 8;

    private final Memory ram;
    private final Memory registers;
    private final Stack<Integer> stack;
    private final Queue<Character> inputBuffer;

    private int instructionPointer;
    private boolean blocked;
    private boolean done;
    private StringBuilder outputBuffer;

    public VirtualMachine() {
        this.ram = new Memory(RAM_SIZE);
        this.registers = new Memory(REGISTER_COUNT);
        this.stack = new Stack<>();
        this.outputBuffer = new StringBuilder();
        this.instructionPointer = 0;
        this.inputBuffer = new LinkedList<>();
        this.blocked = false;
    }

    public Memory getRam() {
        return ram;
    }

    public Memory getRegisters() {
        return registers;
    }

    public Stack<Integer> getStack() {
        return stack;
    }

    public void run() {
        Operation curr = loadOperation(instructionPointer);
        while (!blocked && !done) {
            if (curr == null) {
                done = true;
            } else {
                instructionPointer = curr.nextAddress();
                curr.execute();
                curr = loadOperation(instructionPointer);
            }
        }
    }

    public void jump(int address) {
        instructionPointer = address;
    }

    public void call(int address) {
        stack.push(instructionPointer);
        jump(address);
    }

    public void ret() {
        int address = -1;
        if (!stack.isEmpty()) {
            address = stack.pop();
        }
        jump(address);
    }

    public void print(char c) {
        outputBuffer.append(c);
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean isDone() {
        return blocked;
    }

    public String getOutput() {
        String result = outputBuffer.toString();
        outputBuffer = new StringBuilder();
        return result;
    }

    public void parseInput(String input) {
        for (char c : input.toCharArray()) {
            inputBuffer.add(c);
        }
        inputBuffer.add('\n');
        blocked = false;
    }

    public boolean hasInput() {
        return !inputBuffer.isEmpty();
    }

    public char readNextInput() {
        return inputBuffer.poll();
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

    private Operation loadOperation(int address) {
        if (address < 0 || address >= RAM_SIZE) {
            return null;
        }
        int opcode = ram.read(address);
        switch (opcode) {
            case 0:
                return null;
            case 1:
                return new Set(address, this);
            case 2:
                return new Push(address, this);
            case 3:
                return new Pop(address, this);
            case 4:
                return new Equal(address, this);
            case 5:
                return new GreaterThan(address, this);
            case 6:
                return new Jump(address, this);
            case 7:
                return new JumpTrue(address, this);
            case 8:
                return new JumpFalse(address, this);
            case 9:
                return new Add(address, this);
            case 10:
                return new Multiply(address, this);
            case 11:
                return new Modulo(address, this);
            case 12:
                return new And(address, this);
            case 13:
                return new Or(address, this);
            case 14:
                return new Not(address, this);
            case 15:
                return new ReadMemory(address, this);
            case 16:
                return new WriteMemory(address, this);
            case 17:
                return new Call(address, this);
            case 18:
                return new Return(address, this);
            case 19:
                return new Out(address, this);
            case 20:
                return new In(address, this);
            case 21:
                return new Noop(address, this);
            default:
                throw new RuntimeException("Unsupported operation with opcode " + opcode);
        }
    }
}
