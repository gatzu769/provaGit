package it.unibas.aziende.modello;

import java.util.Calendar;

public class Dipendente {
    private String codiceFiscale;
    private String nome;
    private String cognome;
    private Calendar dataAssunzione;
    private String sesso;

    public Dipendente(String codiceFiscale, String nome, String cognome, Calendar dataAssunzione, String sesso) {
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.cognome = cognome;
        this.dataAssunzione = dataAssunzione;
        this.sesso = sesso;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Calendar getDataAssunzione() {
        return dataAssunzione;
    }

    public void setDataAssunzione(Calendar dataAssunzione) {
        this.dataAssunzione = dataAssunzione;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }
    
    
}
