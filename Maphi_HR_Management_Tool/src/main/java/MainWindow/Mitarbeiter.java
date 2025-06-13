package MainWindow;


import java.util.Calendar;

public class Mitarbeiter { //Konstruktor der Mitarbeiter Klasse
    public int[] geburtsdatum = new int[3];
    private int alter;
    public String abteilung;
    public boolean verheitatet;
    public String geschlecht;
    public double stundenlohn;

    public void setAlter(int alterSet){//setter vom alter
        alter = alterSet;
    }
    public int getAlter() {return alter;}//getter vom alter
    String [] name = new String [2];
    //String vorname = ;
    //name[0] =

    public int berechneAlter(){
        Calendar c = Calendar.getInstance(); //legt ein Calender Objekt an
        int bAlter = c.get(Calendar.YEAR) - geburtsdatum[2]; //berechnet Alter in Jahren
        if (c.get(Calendar.DAY_OF_MONTH) > geburtsdatum[0] && c.get(Calendar.MONTH) > geburtsdatum[1]) bAlter = bAlter - 1; //zieht 1 Jahr ab bei nicht vergangenem Geburtstag
        return bAlter; //gibt das alter zurück
    }
    public Mitarbeiter(int geburtsdatum[], String abteilung, boolean verheitatet, String geschlecht, double stundenlohn, String[] name) {

        this.geburtsdatum= geburtsdatum;
        setAlter(berechneAlter());
        this.abteilung = abteilung;
        this.verheitatet = verheitatet;
        this.geschlecht = geschlecht;
        this.stundenlohn = stundenlohn;
        this.name = name;
    }

}
