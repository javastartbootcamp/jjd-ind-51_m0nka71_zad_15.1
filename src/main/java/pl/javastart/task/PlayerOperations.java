package pl.javastart.task;

import java.io.*;
import java.util.List;

public class PlayerOperations {

    static void savePlayers(List<Player> players) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("stats.csv"))) {
            for (Player player : players) {
                writer.write(player.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Nie udało sie zapisać zawodników");
        }
    }
}
