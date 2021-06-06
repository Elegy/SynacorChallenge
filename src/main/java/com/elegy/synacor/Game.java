package com.elegy.synacor;

import com.elegy.synacor.vm.VirtualMachine;

public class Game {

    private final VirtualMachine vm;

    private boolean mute;

    public Game() {
        this.vm = new VirtualMachine();
        vm.loadProgram("challenge.bin");
        run();
    }

    public void processCommand(String command) {
        vm.parseInput(command);
        run();
    }

    public void setMute(boolean mute) {
        this.mute = mute;
    }

    public boolean isGameOver() {
        return vm.isDone();
    }

    private void run() {
        vm.run();
        String out = vm.getOutput();
        if (!mute) {
            System.out.print(out);
        }
    }
}
