package pl.javastart.task;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class TournamentStats {

    private static final int INITIAL_CAPACITY = 1;
    private int index = 0;
    Player[] players = new Player[INITIAL_CAPACITY];

    void run(Scanner scanner) {
        String userInput = null;
        do {
            System.out.println("Podaj wynik kolejnego gracza (lub stop):");
            String firstName = scanner.nextLine();
            String lastName = scanner.nextLine();
            int result = scanner.nextInt();
            add((new Player(firstName, lastName, result)));

        } while (userInput.equals("STOP"));

        sortWithGivenParameter(scanner, players);
        sortFromSmallestOrBiggest(scanner, players);
        PlayerOperations.savePlayers(players);
    }

    public void add(Player player) {
        if (index == players.length) {
            players = Arrays.copyOf(players, players.length * 5);
        }
        players[index] = player;
        index++;
    }

    public Player[] sortWithGivenParameter(Scanner scanner, Player[] players) {
        System.out.println("Po jakim parametrze posortować? (1 - imię, 2 - nazwisko, 3 - wynik)");
        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1:
                Arrays.sort(players, new FirstNameComparator());
                break;
            case 2:
                Arrays.sort(players, new PlayerOperations.LastNameComparator());
                break;
            default:
                return players;
        }
        return players;
    }

    public Player[] sortFromSmallestOrBiggest(Scanner scanner, Player[] players) {
        System.out.println("Sortować rosnąco czy malejąco? (1 - rosnąco, 2 - malejąco)");
        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1:
                Arrays.sort(players);
                break;
            case 2:
                Arrays.sort(players, new Comparator<Player>() {
                    @Override
                    public int compare(Player player1, Player player2) {
                        return -(player1.compareTo(player2));
                    }
                });
                break;
            default:
                System.out.println("Nie udało się posortować");
        }
        return players;
    }
}
