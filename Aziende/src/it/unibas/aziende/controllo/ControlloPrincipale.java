package it.unibas.aziende.controllo;

import it.unibas.aziende.Applicazione;
import it.unibas.aziende.modello.Archivio;
import it.unibas.aziende.modello.Azienda;
import it.unibas.aziende.modello.Costanti;
import it.unibas.aziende.modello.Dipendente;
import it.unibas.aziende.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloPrincipale {

    private Action azioneCerca = new AzioneCerca();
    private Action azioneSeleziona = new AzioneSeleziona();

    public Action getAzioneCerca() {
        return azioneCerca;
    }

    public Action getAzioneSeleziona() {
        return azioneSeleziona;
    }

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            this.putValue(NAME, "Cerca");
            this.putValue(SHORT_DESCRIPTION, "Cerca aziende per città");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_S);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt S"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            String nomeCitta = vistaPrincipale.getCampoCitta().trim();
            if (nomeCitta.isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Inserisci prima il nome della città");
                return;
            }
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBean(Costanti.ARCHIVIO);
            List<Azienda> listaAziende = archivio.getListaAziendeCitta(nomeCitta);
            if (listaAziende == null) {
                Applicazione.getInstance().getFrame().mostraMessaggio("Non sono presenti aziende in questa città");
                return;
            }
            Applicazione.getInstance().getModello().putBean(Costanti.LISTA_FILTRATA, listaAziende);
            Applicazione.getInstance().getVistaPrincipale().aggiornaTabella();
            Applicazione.getInstance().getControlloPrincipale().getAzioneSeleziona().setEnabled(true);
        }

    }

    private class AzioneSeleziona extends AbstractAction {

        public AzioneSeleziona() {
            this.putValue(NAME, "Seleziona");
            this.putValue(SHORT_DESCRIPTION, "Vedi dettagli azienda");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_D);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt D"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Azienda azienda = Applicazione.getInstance().getVistaPrincipale().getAziendaSelezionata();
            List<Dipendente> listaDipendenti = azienda.getListaDipendenti();
            Applicazione.getInstance().getModello().putBean(Costanti.AZIENDA_SELEZIONATA, azienda);
            Applicazione.getInstance().getModello().putBean(Costanti.LISTA_DIPENDENTI, listaDipendenti);
            Applicazione.getInstance().getVistaDettagliAzienda().visualizza();
        }

    }
}
