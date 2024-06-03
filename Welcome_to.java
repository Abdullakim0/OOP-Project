interface Beginning{
    public String welcome();
}

public class Welcome_to implements Beginning {

    public String welcome() {
        return "Welcome to the game";
    }
}
class usage implements Beginning {

    public String welcome() {
        return "Please wait for the system distribution!";
    }
}
class usage2 implements Beginning{

    public String welcome() {
        return "Press Enter if you don't have the matching card";

    }
}
