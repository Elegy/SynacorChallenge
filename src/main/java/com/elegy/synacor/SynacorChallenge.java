package com.elegy.synacor;

import com.elegy.synacor.vm.VirtualMachine;

import java.util.Scanner;

public class SynacorChallenge {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        VirtualMachine vm = new VirtualMachine();
        vm.loadProgram("challenge.bin");
        while (!vm.isDone()) {
            vm.run();
            System.out.println(vm.getOutput());
            vm.parseInput(scanner.nextLine());
        }
    }

    public static void main(String[] args) {
        SynacorChallenge challenge = new SynacorChallenge();
        challenge.run();
    }
}
