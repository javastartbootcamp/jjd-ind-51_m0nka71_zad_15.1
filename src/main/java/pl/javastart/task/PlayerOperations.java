package pl.javastart.task;

import java.io.*;
import java.util.Comparator;

public class PlayerOperations {

    static void savePlayers(Player[] players) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("stats.csv"));) {
            for (Player player : players) {
                writer.write(String.valueOf(player));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Nie udało sie zapisać zawodników");
        }
    }

    public static class LastNameComparator implements Comparator<Player> {

        @Override
        public int compare(Player player1, Player player2) {
            return player1.getLastName().compareTo(player2.getLastName());
        }
    }
}
