package pl.javastart.task.comparators;

import pl.javastart.task.Player;

import java.util.Comparator;

public class ResultComparator implements Comparator<Player> {
    @Override
    public int compare(Player player1, Player player2) {
        return Integer.compare(player1.getResult(), player2.getResult());
    }
}
