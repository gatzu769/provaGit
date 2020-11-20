package it.unibas.aziende;

import it.unibas.aziende.controllo.ControlloDettagliAzienda;
import it.unibas.aziende.controllo.ControlloMenu;
import it.unibas.aziende.controllo.ControlloPrincipale;
import it.unibas.aziende.modello.Modello;
import it.unibas.aziende.persistenza.DAOArchivio;
import it.unibas.aziende.persistenza.IDAOArchivio;
import it.unibas.aziende.vista.Frame;
import it.unibas.aziende.vista.VistaDettagliAzienda;
import it.unibas.aziende.vista.VistaPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {

    private static Applicazione singleton = new Applicazione();

    public static Applicazione getInstance() {
        return singleton;
    }

    private Applicazione() {
    }
    private IDAOArchivio daoArchivio;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private VistaDettagliAzienda vistaDettagliAzienda;
    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private ControlloDettagliAzienda controlloDettagliAzienda;
    private Modello modello;

    public IDAOArchivio getDaoArchivio() {
        return daoArchivio;
    }

    public Frame getFrame() {
        return frame;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public VistaDettagliAzienda getVistaDettagliAzienda() {
        return vistaDettagliAzienda;
    }

    public ControlloMenu getControlloMenu() {
        return controlloMenu;
    }

    public ControlloPrincipale getControlloPrincipale() {
        return controlloPrincipale;
    }

    public ControlloDettagliAzienda getControlloDettagliAzienda() {
        return controlloDettagliAzienda;
    }

    public Modello getModello() {
        return modello;
    }

    private void inizializza() {
        this.modello = new Modello();
        this.daoArchivio = new DAOArchivio();
        this.controlloDettagliAzienda = new ControlloDettagliAzienda();
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.vistaPrincipale = new VistaPrincipale();
        this.frame = new Frame();
        this.vistaDettagliAzienda = new VistaDettagliAzienda(this.frame, true);
        vistaPrincipale.inizializza();
        vistaDettagliAzienda.inizializza();
        frame.inizializza();

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Applicazione.getInstance().inizializza();
            }

        });
    }
}
