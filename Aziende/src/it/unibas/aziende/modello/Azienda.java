package it.unibas.aziende.modello;

import java.util.ArrayList;
import java.util.List;

public class Azienda implements Comparable<Azienda> {
    private String partitaIva;
    private String denominazione;
    private String cittaSede;
    private List<Dipendente> listaDipendenti = new ArrayList<Dipendente>();

    public Azienda(String partitaIva, String denominazione, String cittaSede) {
        this.partitaIva = partitaIva;
        this.denominazione = denominazione;
        this.cittaSede = cittaSede;
    }
    
    public void addDipendente(Dipendente dipendente){
        this.listaDipendenti.add(dipendente);
    }

    public String getPartitaIva() {
        return partitaIva;
    }

    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public String getCittaSede() {
        return cittaSede;
    }

    public void setCittaSede(String cittaSede) {
        this.cittaSede = cittaSede;
    }

    public List<Dipendente> getListaDipendenti() {
        return listaDipendenti;
    }

    public void setListaDipendenti(List<Dipendente> listaDipendenti) {
        this.listaDipendenti = listaDipendenti;
    }

    @Override
    public int compareTo(Azienda o) {
        Integer a1 = new Integer(this.getDenominazione().length());
        Integer a2 = new Integer(o.getDenominazione().length());
        return a1.compareTo(a2);
    }
   
    
    
}
