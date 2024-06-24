import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String playAgain;

        do {
            String playerA = getPlayerMove(in, "A");
            String playerB = getPlayerMove(in, "B");

            displayResult(playerA, playerB);

            System.out.println("Do you want to play again? (Y/N):");
            playAgain = in.next();
        } while (playAgain.equalsIgnoreCase("Y"));

        in.close();
    }

    public static String getPlayerMove(Scanner in, String player) {
        String move;
        while (true) {
            System.out.println("Enter a move from player " + player + " (R, P, S or r, p, s):");
            move = in.next();
            move = move.toUpperCase();
            if (move.equals("R") || move.equals("P") || move.equals("S")) {
                break;
            } else {
                System.out.println("You have entered an invalid value. Please select from the options (R, S, P).");
            }
        }
        return move;
    }

    public static void displayResult(String playerA, String playerB) {
        if (playerA.equals(playerB)) {
            System.out.println(playerA + " vs " + playerB + " it’s a Tie!");
        } else if ((playerA.equals("R") && playerB.equals("S")) ||
                (playerA.equals("P") && playerB.equals("R")) ||
                (playerA.equals("S") && playerB.equals("P"))) {
            System.out.println(getWinningPhrase(playerA, playerB) + " Player A wins!");
        } else {
            System.out.println(getWinningPhrase(playerB, playerA) + " Player B wins!");
        }
    }

    public static String getWinningPhrase(String winner, String loser) {
        if (winner.equals("R") && loser.equals("S")) {
            return "Rock breaks Scissors,";
        } else if (winner.equals("P") && loser.equals("R")) {
            return "Paper covers Rock,";
        } else if (winner.equals("S") && loser.equals("P")) {
            return "Scissors cuts Paper,";
        }
        return "";
    }
}
