package it.unibas.aziende.controllo;

import it.unibas.aziende.Applicazione;
import it.unibas.aziende.modello.Archivio;
import it.unibas.aziende.modello.Costanti;
import it.unibas.aziende.persistenza.DAOException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

public class ControlloMenu {
    
    private AzioneCarica azioneCarica = new AzioneCarica();
    private AzioneEsci azioneEsci = new AzioneEsci();
    private AzioneVerifica azioneVerifica = new AzioneVerifica();
    
    public AzioneCarica getAzioneCarica() {
        return azioneCarica;
    }
    
    public AzioneEsci getAzioneEsci() {
        return azioneEsci;
    }
    
    public AzioneVerifica getAzioneVerifica() {
        return azioneVerifica;
    }
    
    public class AzioneCarica extends AbstractAction {
        
        public AzioneCarica() {
            this.putValue(NAME, "Carica Archivio");
            this.putValue(SHORT_DESCRIPTION, "Carica archivio da file");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_U);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt U"));
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = null;
            try {
                archivio = Applicazione.getInstance().getDaoArchivio().carica();
                
            } catch (DAOException ex) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Impossibile caricare archivio");
            }
            Applicazione.getInstance().getModello().putBean(Costanti.ARCHIVIO, archivio);
            Applicazione.getInstance().getFrame().mostraMessaggio("Archivio caricato contenente " + archivio.getListaAziende().size() + " Aziende");
            Applicazione.getInstance().getControlloPrincipale().getAzioneCerca().setEnabled(true);
            Applicazione.getInstance().getControlloMenu().getAzioneVerifica().setEnabled(true);
        }
        
    }
    
    public class AzioneEsci extends AbstractAction {
        
        public AzioneEsci() {
            this.putValue(NAME, "esci");
            this.putValue(SHORT_DESCRIPTION, "Chiudi app");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_E);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt E"));
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
        
    }
    
    public class AzioneVerifica extends AbstractAction {
        
        public AzioneVerifica() {
            this.putValue(NAME, "Verifica archivio");
            this.putValue(SHORT_DESCRIPTION, "Verifica la presenza di codici fiscali duplicati");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_A);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
            this.setEnabled(false);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBean(Costanti.ARCHIVIO);
            if(archivio.verificaDuplicati()){
                Applicazione.getInstance().getFrame().mostraMessaggio("Sono presenti più utenti con lo stesso codice fiscale");
                return;
            } else {
                Applicazione.getInstance().getFrame().mostraMessaggio("Non sono presenti più dipendenti con lo stesso codice fiscale");
            }
        }
        
    }
}
