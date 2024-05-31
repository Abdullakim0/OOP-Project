interface Beginning{
    public String usage();
    public String welcome();
    public String rule();

}

public class Welcome_to implements Beginning {

    public String usage() {
        return "Welcome to the game";
    }

    public String  rule() {
        return "Please wait for the system distribution!";
    }

    public String welcome() {
        return "Press Enter if you don't have the matching card";

    }
}