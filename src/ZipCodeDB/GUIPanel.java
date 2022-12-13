package ZipCodeDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// JPanel is the base class - can use its methods
// GUIPanel is the derived class
public class GUIPanel extends JPanel {

    private JTextField zipcode;
    private JButton submit;
    private JButton northernMost;
    private JTextArea output;

    private Database db; // the zipcode database

    public GUIPanel(){

        // adding each part to the window
        this.zipcode = new JTextField("zipcode", 7);
        this.add(this.zipcode);

        // adding the submit button to the window
        this.submit = new JButton("Submit");
        this.add(this.submit);
        this.submit.addActionListener(new SubmitButtonListener());

        // adding the northernmost button to the window
        this.northernMost = new JButton("Northernmost");
        this.add(this.northernMost);
        this.northernMost.addActionListener(new NorthernButtonListener());

        this.output = new JTextArea(5, 20);
        this.add(this.output);

        this.db = new Database(); // load the zipcodes
    }

    class SubmitButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e){
            // function will get called when the user presses submit
            output.setText("The button was pressed");

            // get the zipcode out of the textfield
            String code = zipcode.getText();

            Zipcode zc = db.search(code);
            WeatherObservation wob = zc.getWeatherData();
            output.setText(wob.toString());

        }
    }

    class NorthernButtonListener implements ActionListener{
        // function called when user presses northernmost
        public void actionPerformed(ActionEvent e){

            String code = zipcode.getText();
            Zipcode northmost = db.getNorthern();
            output.setText(northmost.toString());
        }
    }

}
