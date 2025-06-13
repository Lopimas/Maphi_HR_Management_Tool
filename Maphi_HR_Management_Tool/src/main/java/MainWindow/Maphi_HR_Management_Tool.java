package MainWindow;

import javax.swing.*;

public class Maphi_HR_Management_Tool extends JFrame {
    private JPanel myPanel;
    private JTextField Name_TextField;
    private JTextField Nachname_textField;
    private JRadioButton männlichRadioButton;
    private JRadioButton weiblichRadioButton;
    private JRadioButton diversRadioButton;
    private JComboBox comboBox1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JList mitarbeiterListe;

    public Maphi_HR_Management_Tool(){     //Konstruktor des Fensters
        setTitle("HR Management Tool");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920,1080);
        setContentPane(myPanel);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public static void main(String[] args) {

        new Maphi_HR_Management_Tool();

    }
}
