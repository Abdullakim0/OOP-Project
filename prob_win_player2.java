import javax.swing.*;
import java.util.List;
import java.util.Random;
public class prob_win_player2 {
    public String prob_win_player2(List<String> player1Hand) {

        StringBuilder result = new StringBuilder();
        result.append("Probability for Player 2: \n\n");

        boolean hasBlackCard = player1Hand.contains("Black");
        if (hasBlackCard) {
            result.append("Winning chance is low\n");
        } else {
            int high = 0;
            int avg = 0;
            int low = 0;

            for (String card : player1Hand) {
                switch (card) {
                    case "Red":
                    case "Blue":
                        high++;
                        break;
                    case "White":
                        avg++;
                        break;
                    case "Black":
                        low++;
                        break;
                }
            }
            if (high > avg && high > low) {
                result.append("Player2 has high winning chance\n");
            } else if (avg >= high && avg > low) {
                result.append("player2 has average winning chance\n");
            } else {
                result.append("Player2 has low winning chance\n");
            }
        }
        return result.toString();
    }
}
