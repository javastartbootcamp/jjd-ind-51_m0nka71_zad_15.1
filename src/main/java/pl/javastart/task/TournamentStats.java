package pl.javastart.task;

import pl.javastart.task.comparators.FirstNameComparator;
import pl.javastart.task.comparators.LastNameComparator;
import pl.javastart.task.comparators.ResultComparator;

import java.util.*;

public class TournamentStats {

    private static final int SORT_BY_FIRST_NAME = 1;
    private static final int SORT_BY_LAST_NAME = 2;
    private static final int SORT_FROM_LOWEST = 1;

    void run(Scanner scanner) {
        List<Player> players = createPlayersList(scanner);
        sortWithGivenParameter(scanner, players);
        PlayerOperations.savePlayers(players);
    }

    private static List<Player> createPlayersList(Scanner scanner) {
        List<Player> players = new ArrayList<>();
        boolean readNext = true;
        do {
            System.out.println("Podaj wynik kolejnego gracza (lub stop):");
            String userInput = scanner.nextLine();
            if (!userInput.equals("STOP")) {
                String[] split = userInput.split(" ");
                String firstName = split[0];
                String lastName = split[1];
                int result = Integer.parseInt(split[2]);
                players.add((new Player(firstName, lastName, result)));
            } else {
                readNext = false;
            }
        } while (readNext);
        return players;
    }

    public void sortWithGivenParameter(Scanner scanner, List<Player> players) {
        System.out.println("Po jakim parametrze posortować? (1 - imię, 2 - nazwisko, 3 - wynik)");
        int firstUserChoice = scanner.nextInt();
        Comparator<Player> comparator = switch (firstUserChoice) {
            case SORT_BY_FIRST_NAME -> new FirstNameComparator();
            case SORT_BY_LAST_NAME -> new LastNameComparator();
            default -> new ResultComparator();
        };

        System.out.println("Sortować rosnąco czy malejąco? (1 - rosnąco, 2 - malejąco)");
        int secondUserChoice = scanner.nextInt();
        if (secondUserChoice == SORT_FROM_LOWEST) {
            players.sort(comparator);
        } else {
            comparator = comparator.reversed();
            players.sort(comparator);
        }
    }
}
