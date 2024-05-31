public class override {
    public String over(){
        return "Start the game!";
    }
}

class override1 extends override{
    @Override
    public String over(){
        return "This will be overridden";
    }
}