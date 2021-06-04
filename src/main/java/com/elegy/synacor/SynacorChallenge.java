package com.elegy.synacor;

import com.elegy.synacor.vm.VirtualMachine;

public class SynacorChallenge {

    public void run() {
        VirtualMachine vm = new VirtualMachine();
        vm.loadProgram("challenge.bin");
        vm.run();
        System.out.println(vm.getOutput());
    }

    public static void main(String[] args) {
        SynacorChallenge challenge = new SynacorChallenge();
        challenge.run();
    }
}
