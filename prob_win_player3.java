import java.util.List;

public class prob_win_player3<T> {

    public String calculateWinProbability(List<T> playerHand) {
        StringBuilder result = new StringBuilder();
        result.append("Probability for Player3: \n\n");

        boolean hasBlackCard = playerHand.contains("Black");
        if (hasBlackCard) {
            result.append("Winning chance is low\n");
        } else {
            int high = 0;
            int avg = 0;
            int low = 0;

            for (T card : playerHand) {
                String cardColor = card.toString();
                switch (cardColor) {
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
                result.append("Player3 has high winning chance\n");
            } else if (avg >= high && avg > low) {
                result.append("Player3 has average winning chance\n");
            } else {
                result.append("Player3 has low winning chance\n");
            }
        }
        return result.toString();
    }

    // Overloaded method to accept an array of strings
    public String calculateWinProbability(String[] playerHand) {
        return calculateWinProbability((List<T>) List.of(playerHand));
    }
}
