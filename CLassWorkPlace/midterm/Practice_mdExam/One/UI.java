package Practice_mdExam.One;

public class UI{
    private Controller controller;
    public UI(){
        this.controller = new Controller(this);
    }

    public Controller getController() {
        return controller;
    }
}
