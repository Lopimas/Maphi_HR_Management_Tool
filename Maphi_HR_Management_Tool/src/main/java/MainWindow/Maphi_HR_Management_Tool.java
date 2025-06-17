package MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Maphi_HR_Management_Tool extends JFrame {
    private JPanel myPanel;
    private JTextField Name_TextField;
    private JRadioButton männlichRadioButton;
    private JRadioButton weiblichRadioButton;
    private JRadioButton diversRadioButton;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JList mitarbeiterListe;
    private JButton speicherButton;
    private JList list1;
    private JPanel listPanel;
    private JPanel geschlechtPanel;

    public Maphi_HR_Management_Tool(){     //Konstruktor des Fensters
        setTitle("HR Management Tool");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920,1080);
        setContentPane(myPanel);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        männlichRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weiblichRadioButton.setSelected(false);
                diversRadioButton.setSelected(false);
            }
        });
        weiblichRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                männlichRadioButton.setSelected(false);
                diversRadioButton.setSelected(false);
            }
        });
        diversRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                männlichRadioButton.setSelected(false);
                weiblichRadioButton.setSelected(false);
            }
        });
    }
    public void initObjekte(){
        List<Mitarbeiter> mitarbeiterDaten = new ArrayList();
        mitarbeiterDaten.add(new Mitarbeiter(new int[]{11,7,2001}, "IT", false, "männlich", 13.0, new String[]{"Phillip","Krahn"}));
        mitarbeiterDaten.add(new Mitarbeiter(new int[]{20,6,2003}, "F", false, "männlich", 15.0, new String[]{"Marvin","Beck"}));
        mitarbeiterDaten.add(new Mitarbeiter(new int[]{4,10,2004}, "HR", false, "weiblich", 13.0, new String[]{"Janine","Baum"}));
        //for (int i = 0; i < mitarbeiterDaten.size(); i++) {
        //    mitarbeiterListe.add(mitarbeiterDaten.get(i).getMitarbeiter());
//
        //}
    }

    public static void main(String[] args) {

        new Maphi_HR_Management_Tool();

    }
}
