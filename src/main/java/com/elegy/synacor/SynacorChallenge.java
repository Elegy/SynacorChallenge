package com.elegy.synacor;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class SynacorChallenge {

    public void solve() {
        Game game = new Game();

        List<String> commands = loadCommands("solution");
        for (String command : commands) {
            System.out.println(command);
            game.processCommand(command);
        }

        Scanner scanner = new Scanner(System.in);
        while (!game.isGameOver()) {
            game.processCommand(scanner.nextLine());
        }
    }

    private List<String> loadCommands(String filename) {
        URL resource = getClass().getClassLoader().getResource(filename);
        if (resource == null) {
            throw new RuntimeException(filename + " not found");
        }
        try {
            return Files.readAllLines(Paths.get(resource.toURI()));
        } catch (Exception e) {
            throw new RuntimeException("Failure loading commands from " + filename, e);
        }
    }

    public static void main(String[] args) {
        new SynacorChallenge().solve();
    }
}
