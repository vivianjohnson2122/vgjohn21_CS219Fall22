package ZipCodeDB;

import javax.swing.*;

public class GUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("CS219 Weather App");
        frame.add(new GUIPanel());
        frame.setVisible(true);

        // When the user clicks the x in the title bar, also stop running main program
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // makes JFrame the size of the internal components
        frame.pack();


    }

}
