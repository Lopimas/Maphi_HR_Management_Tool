package MainWindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MitarbeiterTest {
    public Mitarbeiter phillip = new Mitarbeiter(new int[]{11,7,2001}, "IT", false, "männlich", 13.0, new String[]{"Phillip","Krahn"});

    @Test
    void berechneAlter() {
        assertEquals(23, phillip.berechneAlter());
    }
}