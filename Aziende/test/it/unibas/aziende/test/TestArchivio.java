package it.unibas.aziende.test;

import it.unibas.aziende.modello.Archivio;
import it.unibas.aziende.modello.Azienda;
import it.unibas.aziende.modello.Costanti;
import it.unibas.aziende.modello.Dipendente;
import it.unibas.aziende.persistenza.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import junit.framework.TestCase;


public class TestArchivio extends TestCase {
    private IDAOArchivio daoArchivio = new DAOArchivio();
    private Archivio archivio;

    @Override
    protected void setUp() throws Exception {
       try{
          this.archivio = this.daoArchivio.carica();
           
       } catch(DAOException e){
           fail("Impossibile caricare archivio");
       }
    }
    
    public void testGetListaAziendeCitta(){
        List<Azienda> listaCitta = archivio.getListaAziendeCitta("Milano");
        assertEquals(true, listaCitta.get(0).getDenominazione().equalsIgnoreCase("Azienda"));
        assertEquals(true, listaCitta.get(1).getDenominazione().equalsIgnoreCase("AziendaMeccanica"));
        assertEquals(true, listaCitta.get(2).getDenominazione().equalsIgnoreCase("AziendaInformatica"));
    }
    
    public void testVerificaDuplicati(){
        Dipendente d1 = new Dipendente("MRRRS1", "Mario", "Rossi", new GregorianCalendar(2020, Calendar.MARCH, 10), Costanti.MASCHIO);
        assertEquals(false, archivio.verificaDuplicati());
        archivio.getListaAziende().get(3).addDipendente(d1);
        assertEquals(true, archivio.verificaDuplicati());
        
    }
    
    
}
