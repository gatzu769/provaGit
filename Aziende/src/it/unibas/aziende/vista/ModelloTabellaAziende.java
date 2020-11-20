package it.unibas.aziende.vista;

import it.unibas.aziende.modello.Azienda;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaAziende extends AbstractTableModel {

    private List<Azienda> listaAziende = new ArrayList<Azienda>();

    public void setListaAziende(List<Azienda> listaAziende) {
        this.listaAziende = listaAziende;
    }

    @Override
    public int getRowCount() {
        return this.listaAziende.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Azienda azienda = this.listaAziende.get(rowIndex);
        if (columnIndex == 0) {
            return azienda.getPartitaIva();
        } else if (columnIndex == 1) {
            return azienda.getDenominazione();
        } else if (columnIndex == 2) {
            return azienda.getCittaSede();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Partita Iva";
        } else if (column == 1) {
            return "Denominazione";
        } else if (column == 2) {
            return "Città sede";
        }
        return "";
    }

    public void aggiornaContenuto() {
        fireTableDataChanged();;
    }

}
