package pl.javastart.task;

public class Player implements Comparable<Player> {
    private String firstName;
    private String lastName;
    private int result;

    public Player(String firstName, String lastName, int result) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.result = result;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ";" + result;
    }

    @Override
    public int compareTo(Player player) {
        return 0;
    }
}
