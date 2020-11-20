package it.unibas.aziende.modello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archivio {

    private List<Azienda> listaAziende = new ArrayList<Azienda>();
    private Logger logger = LoggerFactory.getLogger(Archivio.class);

    public List<Azienda> getListaAziende() {
        return listaAziende;
    }

    public void test(){
    	return;
    }

    public void addAzienda(Azienda azienda) {
        this.listaAziende.add(azienda);
    }

    public List<Azienda> getListaAziendeCitta(String citta) {
        List<Azienda> listaFiltrata = new ArrayList<Azienda>();
        for (Azienda azienda : this.listaAziende) {
            if (azienda.getCittaSede().equalsIgnoreCase(citta)) {
                listaFiltrata.add(azienda);
            }
        }
        logger.debug("Citta: " + listaFiltrata.get(0).getCittaSede());
        if(listaFiltrata.size() == 0){
            return null;
        }
        if(listaFiltrata.size() == 1){
            return listaFiltrata;
        }
        Collections.sort(listaFiltrata);
        logger.debug(listaFiltrata.get(1).getDenominazione());
        return listaFiltrata;
    }

    public boolean verificaDuplicati() {
        List<String> listaCodiciFiscali = new ArrayList<String>();
        for (Azienda azienda : listaAziende) {
            for (Dipendente dipendente : azienda.getListaDipendenti()) {
                listaCodiciFiscali.add(dipendente.getCodiceFiscale());
            }
        }
        Set<String> setCodiceFiscale = new HashSet<String>(listaCodiciFiscali);
        if(setCodiceFiscale.size() != listaCodiciFiscali.size()){
            return true;
        }
        return false;

    }
}
