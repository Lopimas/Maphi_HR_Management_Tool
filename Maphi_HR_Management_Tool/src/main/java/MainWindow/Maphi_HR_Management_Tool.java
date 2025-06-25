package MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Maphi_HR_Management_Tool extends JFrame {
    private JPanel myPanel;
    private JTextField name_TextField;
    private JRadioButton männlichRadioButton;
    private JRadioButton weiblichRadioButton;
    private JRadioButton diversRadioButton;
    private JTextField tageTextfeld;
    private JTextField monatTextfeld;
    private JTextField jahreTextfeld;
    private JButton speicherButton;
    private JPanel geschlechtPanel;
    private JTextField nachname_TextField;
    private JComboBox abteilungComboBox;
    private JPanel datumPanel;
    private JPanel mitarbeiterlistenPanel;
    private JTextArea nameTextArea;
    private JTextField stundenlohnTextField;
    private JRadioButton verheiratetRadioButton;
    private JRadioButton ledigRadioButton;
    private JTextArea alterTextArea;
    private JTextArea familienstandTextArea;
    private JTextArea abteilungTextArea;
    private JTextArea stundenlohnTextArea;
    private JButton berechneDurchschnittlichenStundenlohnButton;
    private JLabel durchschnittLabel;
    private JComboBox filterComboBox;
    private JLabel filterLabel;
    private ArrayList<Mitarbeiter> mitarbeiterDaten;


    public Maphi_HR_Management_Tool(){     //Konstruktor des Fensters
        setTitle("HR Management Tool");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920,1080);
        setContentPane(myPanel);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initObjekte();
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
        ledigRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verheiratetRadioButton.setSelected(false);
            }
        });
        verheiratetRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ledigRadioButton.setSelected(false);
            }
        });
        speicherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String vorname;
                    String nachname;
                    int tag;
                    int monat;
                    int jahre;
                    String abteilung;
                    boolean verheiratet;
                    String geschlecht;
                    double stundenlohn;
                    char[] namearr = new char[name_TextField.getText().length()];
                    char[] nachnamearr = new char[nachname_TextField.getText().length()];
                    char[] checkDigitsTagarr = new char[tageTextfeld.getText().length()];
                    char[] checkDigitsMonatarr = new char[monatTextfeld.getText().length()];
                    char[] checkDigitsJahrarr = new char[jahreTextfeld.getText().length()];
                    if(!stundenlohnTextField.getText().matches("^\\d+(\\.\\d{1,2})?$"))throw new Exception("Ungültige eingabe! Achte auf die richtige Eingabe beim Stundenlohn. z.B 13 oder 15.42 ");//Hier haben wir eine Matchabfrage mithilfe von Regex getätigt, um sicherzustellen, dass der Stundenlohn eine Zahl ist,
                                                                                                                                                                        // und optional noch ein '.' und maximal 2 Kommastellen erlaubt sind
                    checkDigitsTagarr = tageTextfeld.getText().toCharArray();
                    checkDigitsMonatarr = monatTextfeld.getText().toCharArray();
                    checkDigitsJahrarr = jahreTextfeld.getText().toCharArray();
                    for (char index: checkDigitsTagarr){
                        if (!Character.isDigit(index))throw new Exception("Keine Buchstaben oder Sonderzeichen beim Tag");
                    }
                    for (char index: checkDigitsMonatarr){
                        if (!Character.isDigit(index))throw new Exception("Keine Buchstaben oder Sonderzeichen beim Monat");
                    }
                    for (char index: checkDigitsJahrarr){
                        if (!Character.isDigit(index))throw new Exception("Keine Buchstaben oder Sonderzeichen beim Jahr");
                    }
                        if (tageTextfeld.getText().isEmpty()||monatTextfeld.getText().isEmpty()||jahreTextfeld.getText().isEmpty()||name_TextField.getText().isEmpty()||nachname_TextField.getText().isEmpty()||stundenlohnTextField.getText().isEmpty())throw new Exception("Bitte alle Felder ausfüllen!");
                    if(Integer.parseInt(tageTextfeld.getText()) <= 31 && Integer.parseInt(tageTextfeld.getText()) >= 1){
                        tag = Integer.parseInt(tageTextfeld.getText());
                    }else throw new Exception("Eingabe ungültig");
                    if(Integer.parseInt(monatTextfeld.getText()) <=12 && Integer.parseInt(monatTextfeld.getText()) >= 1){
                        monat = Integer.parseInt(monatTextfeld.getText());
                    }else throw new Exception("Eingabe ungültig!");
                    if(Integer.parseInt(jahreTextfeld.getText()) <= 2025 && Integer.parseInt(jahreTextfeld.getText()) > 1910){
                        jahre = Integer.parseInt(jahreTextfeld.getText());
                    }else throw new Exception("Eingabe ungültig!");
                    if(!abteilungComboBox.getSelectedItem().toString().equals("")){
                        abteilung = abteilungComboBox.getSelectedItem().toString();
                    }else throw new Exception("keine Abteilung ausgewählt!");
                    if(!(verheiratetRadioButton.isSelected() || ledigRadioButton.isSelected())){
                        throw new Exception("keine Familienstand ausgewählt!");
                    } else if (verheiratetRadioButton.isSelected()) {
                        verheiratet = true;
                    } else verheiratet = false;
                    if(!(männlichRadioButton.isSelected() || weiblichRadioButton.isSelected() || diversRadioButton.isSelected())){
                        throw new Exception("kein Geschlecht geht schlecht ; ) !");
                    }else if (männlichRadioButton.isSelected()) geschlecht = "männlich";
                     else if (weiblichRadioButton.isSelected()) geschlecht = "weiblich";
                     else geschlecht = "divers";
                     if(Double.parseDouble(stundenlohnTextField.getText())>= 13.0){
                         stundenlohn = Double.parseDouble(stundenlohnTextField.getText());
                     }else throw new Exception("Stundenlohn ungültig! Beachte Mindestlohn von 13€!");
                     namearr = name_TextField.getText().toCharArray();
                     for (char i: namearr) {
                         if (!Character.isAlphabetic(i)) throw new Exception("keine Zahlen oder sonderzeichen!");
                     }
                     vorname = name_TextField.getText();
                     nachnamearr = nachname_TextField.getText().toCharArray();
                     for (char i: nachnamearr){
                         if (!Character.isAlphabetic(i)) throw new Exception("keine Zahlen oder sonderzeichen!");
                     }
                     nachname = nachname_TextField.getText();




                    mitarbeiterDaten.add(new Mitarbeiter(new int[]{tag,monat,jahre}, abteilung, verheiratet, geschlecht, stundenlohn, new String[]{vorname,nachname}));
                    addtoList();
                    clearInput();
                } catch (Exception ex) {
                    if(ex.getMessage().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Eingabe ungültig! Bitte alle felder ausfüllen!");
                    }
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        berechneDurchschnittlichenStundenlohnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double durchschnitt = 0.0;
                for (Mitarbeiter i: mitarbeiterDaten){
                    durchschnitt += i.stundenlohn;
                }
                durchschnittLabel.setText(String.valueOf(durchschnitt / mitarbeiterDaten.size()));
            }
        });
        filterComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if (filterComboBox.getSelectedItem().toString().isEmpty()){
                addtoList();
            }else
            {
             addtoList(filterComboBox.getSelectedItem().toString());
            }
            }
        });
    }
    public void clearInput(){
        name_TextField.setText("");
        nachname_TextField.setText("");
        weiblichRadioButton.setSelected(false);
        diversRadioButton.setSelected(false);
        männlichRadioButton.setSelected(false);
        verheiratetRadioButton.setSelected(false);
        ledigRadioButton.setSelected(false);
        stundenlohnTextField.setText("");
        abteilungComboBox.setSelectedIndex(0);
        tageTextfeld.setText("");
        monatTextfeld.setText("");
        jahreTextfeld.setText("");

    }
    public void addtoList(){ //Methode zum anzeigen der Mitarbeiter in der Liste
        nameTextArea.setText("");           //hier wird die alter liste gelöscht und neu geschrieben
        alterTextArea.setText("");
        familienstandTextArea.setText("");
        abteilungTextArea.setText("");
        stundenlohnTextArea.setText("");

        for (Mitarbeiter a: mitarbeiterDaten) {
            nameTextArea.setText(nameTextArea.getText() + a.name[0] +", " + a.name[1] +"\n");
            alterTextArea.setText(alterTextArea.getText()+ String.valueOf(a.getAlter()) + "\n");
            if(a.verheitatet == false)
                familienstandTextArea.setText(familienstandTextArea.getText() + "ledig"+"\n");
            else
                familienstandTextArea.setText(familienstandTextArea.getText() + "verheiratet"+"\n");
            abteilungTextArea.setText(abteilungTextArea.getText() + a.abteilung +"\n");
            stundenlohnTextArea.setText(stundenlohnTextArea.getText() + String.valueOf(a.stundenlohn) + "\n");
        }
    }
    public void addtoList(String abteilung){ //die überladene Methode zum anzeigen der Mitarbeiter in der Liste, für die Filterung
        nameTextArea.setText("");           //hier wird die alter liste gelöscht und neu geschrieben
        alterTextArea.setText("");
        familienstandTextArea.setText("");
        abteilungTextArea.setText("");
        stundenlohnTextArea.setText("");

        for (Mitarbeiter a: mitarbeiterDaten) {
            if (abteilung.equals(a.abteilung)) {
                nameTextArea.setText(nameTextArea.getText() + a.name[0] + ", " + a.name[1] + "\n");
                alterTextArea.setText(alterTextArea.getText() + String.valueOf(a.getAlter()) + "\n");
                if (a.verheitatet == false)
                    familienstandTextArea.setText(familienstandTextArea.getText() + "ledig" + "\n");
                else
                    familienstandTextArea.setText(familienstandTextArea.getText() + "verheiratet" + "\n");
                abteilungTextArea.setText(abteilungTextArea.getText() + a.abteilung + "\n");
                stundenlohnTextArea.setText(stundenlohnTextArea.getText() + String.valueOf(a.stundenlohn) + "\n");
            }
        }
    }

    public void initObjekte(){
        mitarbeiterDaten = new ArrayList();
        mitarbeiterDaten.add(new Mitarbeiter(new int[]{11,7,2001}, "IT - Informations Technik", false, "männlich", 13.0, new String[]{"Phillip","Krahn"}));
        mitarbeiterDaten.add(new Mitarbeiter(new int[]{20,6,2003}, "F  - Finanzen", false, "männlich", 15.0, new String[]{"Marvin","Beck"}));
        mitarbeiterDaten.add(new Mitarbeiter(new int[]{4,10,2004}, "HR - Human Resources", false, "weiblich", 13.0, new String[]{"Janine","Baum"}));
        addtoList();


        //for (int i = 0; i < mitarbeiterDaten.size(); i++) {
        //    mitarbeiterListe.add(mitarbeiterDaten.get(i).getMitarbeiter());
//
        //}
    }

    public static void main(String[] args) {

        new Maphi_HR_Management_Tool();
    }
}
