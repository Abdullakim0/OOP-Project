import java.util.Scanner;
import javax.swing.*;
public class Players {

    public String name, name2, name3;
    public int age, age2, age3;
    public void Player_s() {
        name=JOptionPane.showInputDialog("Player 1 Enter your name:");

        String inp1=JOptionPane.showInputDialog("Enter your age:");
        age=Integer.parseInt(inp1);

        //2 player

        name2=JOptionPane.showInputDialog("Player 2 Enter your name:");

        String inp2=JOptionPane.showInputDialog("Enter your age");
        age2=Integer.parseInt(inp2);

        //Player 3

        name3=JOptionPane.showInputDialog("Player 3 Enter your name:");

        String inp3=JOptionPane.showInputDialog("Enter your age:");
        age3=Integer.parseInt(inp3);
    }

    public String getName() {
        return name;
    }
    public void setName(String name1) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getName2() {
        return name2;
    }
    public void setName2(String name2) {
        this.name2 = name2;
    }
    public int getAge2() {
        return age2;
    }
    public void setAge2(int age2) {
        this.age2 = age2;
    }
    public String getName3() {
        return name3;
    }
    public void setName3(String name3) {
        this.name3 = name3;
    }
    public int getAge3() {
        return age3;
    }
    public void setAge3(int age3) {
        this.age3 = age3;
    }

}