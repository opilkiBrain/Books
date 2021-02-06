import GUI.TheFrame;
import Objects.*;


public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        TheFrame frame = new TheFrame(db);
        frame.displayFrame();

    }

}
