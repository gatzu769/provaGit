package it.unibas.aziende.controllo;

import it.unibas.aziende.Applicazione;
import it.unibas.aziende.modello.Costanti;
import it.unibas.aziende.modello.Dipendente;
import it.unibas.aziende.vista.VistaDettagliAzienda;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

public class ControlloDettagliAzienda {

    private AzioneAggiungi azioneAggiungi = new AzioneAggiungi();

    public AzioneAggiungi getAzioneAggiungi() {
        return azioneAggiungi;
    }

    public class AzioneAggiungi extends AbstractAction {

        public AzioneAggiungi() {
            this.putValue(NAME, "Aggiungi dipendente");
            this.putValue(SHORT_DESCRIPTION, "Aggiungi nuovo dipendente nella lista");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_A);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaDettagliAzienda vistaDettagliAzienda = Applicazione.getInstance().getVistaDettagliAzienda();
            String convalida = this.convalida(vistaDettagliAzienda.getGiorno(), vistaDettagliAzienda.getMese(), vistaDettagliAzienda.getAnno());
            if (!convalida.isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore(convalida);
                return;
            }
            List<Dipendente> listaDipendenti = (List<Dipendente>) Applicazione.getInstance().getModello().getBean(Costanti.LISTA_DIPENDENTI);
            for (Dipendente dipendente : listaDipendenti) {
                if (vistaDettagliAzienda.getCampoCodiceFiscale().trim().equalsIgnoreCase(dipendente.getCodiceFiscale())) {
                    Applicazione.getInstance().getFrame().mostraMessaggioErrore("Esiste già un dipendente con questo codice fiscale");
                    return;
                }
            }
            String codiceFiscale = vistaDettagliAzienda.getCampoCodiceFiscale();
            String nome = vistaDettagliAzienda.getCampoNome();
            String cognome = vistaDettagliAzienda.getCampoCognome();
            String sesso = vistaDettagliAzienda.getSesso();
            int interoAnno = vistaDettagliAzienda.getAnno().intValue();
            int interoMese = vistaDettagliAzienda.getMese().intValue() - 1;
            int interoGiorno = vistaDettagliAzienda.getGiorno().intValue();
            Calendar data = new GregorianCalendar(interoAnno, interoMese, interoGiorno);
            Dipendente dipendente = new Dipendente(codiceFiscale, nome, cognome, data, sesso);
            listaDipendenti.add(dipendente);
            Applicazione.getInstance().getModello().putBean(Costanti.LISTA_DIPENDENTI, listaDipendenti);
            Applicazione.getInstance().getVistaDettagliAzienda().aggiornaTabella();
        }

        private String convalida(Integer giorno, Integer mese, Integer anno) {
            StringBuilder sb = new StringBuilder();
            VistaDettagliAzienda vistaDettagliAzienda = Applicazione.getInstance().getVistaDettagliAzienda();
            if (vistaDettagliAzienda.getCampoCodiceFiscale().trim().isEmpty()) {
                sb.append("Inserisci codice fiscale \n");
            }
            if (vistaDettagliAzienda.getCampoNome().trim().isEmpty()) {
                sb.append("Inserisci Nome \n");
            }
            if (vistaDettagliAzienda.getCampoCognome().trim().isEmpty()) {
                sb.append("Inserisci Cognome \n");
            }
            if (vistaDettagliAzienda.getSesso().trim().isEmpty()) {
                sb.append("Seleziona sesso \n");
            }
            if (vistaDettagliAzienda.getAnno() == null) {
                sb.append("Inserisci Anno \n");
            }
            if (vistaDettagliAzienda.getMese() == null) {
                sb.append("Inserisci Mese \n");
            }
            if (vistaDettagliAzienda.getGiorno() == null) {
                sb.append("Inserisci Giorno \n");
            }
            if (vistaDettagliAzienda.getCampoCodiceFiscale().length() != 6) {
                sb.append("Codice fiscale deve avere 6 caratteri \n");
            }

            try {
                int interoAnno = vistaDettagliAzienda.getAnno().intValue();
                int interoMese = vistaDettagliAzienda.getMese().intValue() - 1;
                int interoGiorno = vistaDettagliAzienda.getGiorno().intValue();
                Calendar data = new GregorianCalendar();
                data.setLenient(false);
                data.set(interoAnno, interoMese, interoGiorno);
                data.getTime();

            } catch (Exception ex) {
                sb.append("Data non valida");
            }
            return sb.toString();
        }
    }
}
