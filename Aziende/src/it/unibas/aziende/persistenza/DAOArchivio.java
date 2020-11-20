package it.unibas.aziende.persistenza;

import it.unibas.aziende.modello.Archivio;
import it.unibas.aziende.modello.Azienda;
import it.unibas.aziende.modello.Costanti;
import it.unibas.aziende.modello.Dipendente;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOArchivio implements IDAOArchivio {

    public Archivio carica() throws DAOException {
        Azienda a1 = new Azienda("A000", "AziendaInformatica", "Milano");
        Azienda a2 = new Azienda("A100", "AziendaMeccanica", "Milano");
        Azienda a3 = new Azienda("A200", "Azienda", "Milano");
        Azienda a4 = new Azienda("A300", "AziendaSud", "Potenza");
        Archivio archivio = new Archivio();
        Dipendente d1 = new Dipendente("MRRRS1", "Mario", "Rossi", new GregorianCalendar(2020, Calendar.MARCH, 10), Costanti.MASCHIO);
        Dipendente d2 = new Dipendente("GVLL10", "Giovanni", "Lollo", new GregorianCalendar(2019, Calendar.SEPTEMBER, 4), Costanti.MASCHIO);
        Dipendente d3 = new Dipendente("MARVD1", "Martina", "Vivida", new GregorianCalendar(2020, Calendar.JANUARY, 29), Costanti.FEMMINA);
        a1.addDipendente(d1);
        a1.addDipendente(d2);
        a1.addDipendente(d3);
        archivio.addAzienda(a1);
        archivio.addAzienda(a2);
        archivio.addAzienda(a3);
        archivio.addAzienda(a4);
        return archivio;

    }
}
