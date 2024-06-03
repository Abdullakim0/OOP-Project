import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class GameLauncherGUI extends JFrame {
    private gameSystem game;
    private player_experience PlayerExperience;
    private Players player_ok;
    //store player names and ages
    private String name,name2,name3;
    private int age,age2,age3;

    public GameLauncherGUI() {
        setTitle("Card Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1700, 800);
        game = new gameSystem();
        PlayerExperience =new player_experience();
        player_ok=new Players();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        JButton playButton= new JButton("Play");
        playButton.addActionListener(e -> showPlay());

        JButton overrideButton = new JButton("Cheers");
        overrideButton.addActionListener(e -> showOverride());

        JButton welcomeButton = new JButton("Welcome message");
        welcomeButton.addActionListener(e -> showWelcome());

        JButton ruleButton = new JButton("Game Rules");
        ruleButton.addActionListener(e -> showGameRules());

        JButton players=new JButton("Players Names");
        players.addActionListener(e -> showNames());

        JButton experienc=new JButton("Player Experience");
        experienc.addActionListener(e -> showExperience());

        JButton probab=new JButton("Winning probability");
        probab.addActionListener(e -> showProb());

        panel.add(experienc);
        panel.add(players);
        panel.add(probab);
        panel.add(playButton);
        panel.add(overrideButton);
        panel.add(welcomeButton);
        panel.add(ruleButton);
        panel.add(experienc);

        getContentPane().add(panel);

        setVisible(true);
    }
    private void showPlay(){
        if(game!=null) {
            game.start();
        } else{
            JOptionPane.showMessageDialog(this, "error");
        }
    }

    private void showOverride() {

        override ov=new override();
        StringBuilder overrmes=new StringBuilder();
        overrmes.append("This is example for override!\n");
        overrmes.append(ov.over()).append("\n");
        JOptionPane.showMessageDialog(this, overrmes.toString(), "Override", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showWelcome() {
        // Placeholder method for showing welcome
        Welcome_to welcomeTo=new Welcome_to();
        usage us=new usage();
        usage2 us2=new usage2();
        StringBuilder welcomeMessage = new StringBuilder();
        welcomeMessage.append("We are delighted to see you again!\n");
        welcomeMessage.append("- ").append(welcomeTo.welcome()).append("\n");
        welcomeMessage.append("- ").append(us.welcome()).append("\n");
        welcomeMessage.append("- ").append(us2.welcome()).append("\n");
        JOptionPane.showMessageDialog(this, welcomeMessage.toString(), "Welcome", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showGameRules() {
        Game_Rule120 gameRule = new Game_Rule120();
        StringBuilder rulesMessage = new StringBuilder();
        rulesMessage.append("General rules of the game:\n");
        rulesMessage.append("- ").append(gameRule.gen_rule()).append("\n");
        rulesMessage.append("- ").append(gameRule.rule_one()).append("\n");
        rulesMessage.append("- ").append(gameRule.rule_two()).append("\n");
        rulesMessage.append("- ").append(gameRule.rule_three()).append("\n");

        JOptionPane.showMessageDialog(this, rulesMessage.toString(), "Game Rules", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showNames() {
        player_ok.Player_s();
        name = player_ok.getName();
        age = player_ok.getAge();
        name2 = player_ok.getName2();
        age2 = player_ok.getAge2();
        name3 = player_ok.getName3();
        age3 = player_ok.getAge3();

        JOptionPane.showMessageDialog(this, "Player 1: " + name + ", Age: " + age +
                "\nPlayer 2: " + name2 + ", Age: " + age2 +
                "\nPlayer 3: " + name3 + ", Age: " + age3);
    }

    private void showExperience() {
        JTextField textField1;
        JTextField textField2;
        JTextField textField3;
        setTitle("Player Experience");
        textField1 = new JTextField(10);
        textField2 = new JTextField(10);
        textField3 = new JTextField(10);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("player 1 experience"));
        inputPanel.add(textField1);
        inputPanel.add(new JLabel("player 2 experience"));
        inputPanel.add(textField2);
        inputPanel.add(new JLabel("player 3 experience"));
        inputPanel.add(textField3);

        int option = JOptionPane.showConfirmDialog(null, inputPanel, "Enter Player Experience", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            try {
                int experience1 = Integer.parseInt(textField1.getText());
                int experience2 = Integer.parseInt(textField2.getText());
                int experience3 = Integer.parseInt(textField3.getText());

                PlayerExperience.setGamingExperience(experience1, experience2, experience3);

                player_experience ple = new player_experience();
                JOptionPane.showMessageDialog(null, "Player1 Experience: " + PlayerExperience.getGamingExperience() +
                        "\nPlayer2 Experience: " + PlayerExperience.getGamingExperience2() +
                        "\nPlayer3 Experience: " + PlayerExperience.getGamingExperience3());

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "invalid input");
            }
        }
    }

    private void showProb() {
        List<String> player1Hand;
        List<String> player2Hand;
        List<String> player3Hand;
        String[] colors = {"Red", "Blue", "White", "Black", "Red", "Blue", "White", "Red", "Blue", "White"};

            // Shuffle the colors
        List<String> colorList = Arrays.asList(colors);
        Collections.shuffle(colorList);

            // Deal the colors between players
        player1Hand = new ArrayList<>(colorList.subList(0, colorList.size() / 3));
        prob_win_player1 calculator=new prob_win_player1();
        String pl1=calculator.prob_win_player1(player1Hand);

        player2Hand= new ArrayList<>(colorList.subList(colorList.size() / 3, 2 * colorList.size() / 3));
        prob_win_player2 calculator2=new prob_win_player2();
        String pl2=calculator2.prob_win_player2(player2Hand);

        player3Hand=new ArrayList<>(colorList.subList(2 * colorList.size() / 3, colorList.size()-1));
        prob_win_player3 calculator3=new prob_win_player3();
        String pl3=calculator3.prob_win_player3(player3Hand);


        String combine=pl1+"\n\n"+pl2+"\n\n"+pl3;

        JOptionPane.showMessageDialog(null, combine);


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameLauncherGUI::new);
    }
}
