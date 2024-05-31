import javax.swing.*;
import java.util.Random;
public class prob_win_player3 {
    public String prob_win_player(String round) {

        StringBuilder result=new StringBuilder();
        result.append("Probability for Player 1: ").append(round).append("\n\n");


        for (int i = 1; i <= 5; i++) {
            Random rand = new Random();
            int randomNum = rand.nextInt(10);
            if (randomNum < 2) {
                result.append("Round ").append(i).append(" Your winning chance is low\n");
            } else if (randomNum <= 4 || randomNum == 2) {
                result.append("Round ").append(i).append(" Your winning chance is average\n");
            } else {
                result.append("Round ").append(i).append(" Your winning chance is high\n");
            }
        }
        return result.toString();
    }
}