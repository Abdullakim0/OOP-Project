import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class gameSystem {
    private List<String> player1Hand;
    private List<String> player2Hand;
    private List<String> player3Hand;
    private Timer playerTimer;
    private final long TIME_LIMIT = 10000; // 10 seconds

    public void start() {
        prepareNewRound();
        playRound();
    }

    public void prepareNewRound() {
        // Define the colors
        String[] colors = {"Red", "Blue", "White", "Black", "Red", "Blue", "White", "Red", "Blue", "White"};

        // Shuffle the colors
        List<String> colorList = Arrays.asList(colors);
        Collections.shuffle(colorList);

        // Deal the colors between players
        player1Hand = new ArrayList<>(colorList.subList(0, colorList.size() / 3));
        player2Hand = new ArrayList<>(colorList.subList(colorList.size() / 3, 2 * colorList.size() / 3));
        player3Hand = new ArrayList<>(colorList.subList(2 * colorList.size() / 3, colorList.size()));
    }

    public void playRound() {
        // Player turns loop
        while (true) {
            if (!playerTurn("Player 1", player1Hand)) break;
            if (!playerTurn("Player 2", player2Hand)) break;
            if (!playerTurn("Player 3", player3Hand)) break;
        }

        // Determine the loser for this round
        if (containsBlack(player1Hand)) {
            JOptionPane.showMessageDialog(null, "Player 1 lost!");
        } else if (containsBlack(player2Hand)) {
            JOptionPane.showMessageDialog(null, "Player 2 lost!");
        } else if (containsBlack(player3Hand)) {
            JOptionPane.showMessageDialog(null, "Player 3 lost!");
        }
    }

    private boolean playerTurn(String playerName, List<String> playerHand) {
        // Timer setup
        playerTimer = new Timer((int) TIME_LIMIT, e -> {
            JOptionPane.showMessageDialog(null, playerName + " ran out of time and lost!");
            System.exit(0);
        });
        playerTimer.setRepeats(false);
        playerTimer.start();

        // Show player's hand
        StringBuilder handString = new StringBuilder();
        for (String color : playerHand) {
            handString.append(color).append("\n");
        }
        String playerChoice = JOptionPane.showInputDialog(null, playerName + "'s hand:\n" + handString + playerName + ", enter the color card you want to put:");

        // Stop timer
        playerTimer.stop();

        if (playerChoice == null || playerChoice.equalsIgnoreCase("Black")) {
            playerLost(playerName);
            return false;
        } else {
            if (playerHand.remove(playerChoice)) {
                JOptionPane.showMessageDialog(null, playerName + " put " + playerChoice + ".");
            } else {
                JOptionPane.showMessageDialog(null, playerName + " doesn't have " + playerChoice + " in their hand.");
            }
        }
        return true;
    }

    private boolean containsBlack(List<String> hand) {
        return hand.contains("Black");
    }

    public String[] getPlayers() {
        return new String[]{"Player 1", "Player 2", "Player 3"};
    }

    public void playerLost(String playerName) {
        JOptionPane.showMessageDialog(null, playerName + " lost! They put the Black card.");
    }
}
