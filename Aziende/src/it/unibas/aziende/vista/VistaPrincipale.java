
package it.unibas.aziende.vista;

import it.unibas.aziende.Applicazione;
import it.unibas.aziende.modello.Archivio;
import it.unibas.aziende.modello.Azienda;
import it.unibas.aziende.modello.Costanti;
import java.util.List;

public class VistaPrincipale extends javax.swing.JPanel {

   public void inizializza(){
       initComponents();
       inizializzaAzione();
   }
   
   public void inizializzaAzione(){
       this.tabellaAziende.setModel(new ModelloTabellaAziende());
       this.bottoneCerca.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneCerca());
       this.campoCitta.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneCerca());
       this.bottoneInserisci.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneSeleziona());
    }

    public String getCampoCitta() {
        return campoCitta.getText();
    }
    
    public Azienda getAziendaSelezionata(){
        List<Azienda> listaAziende = (List<Azienda>) Applicazione.getInstance().getModello().getBean(Costanti.LISTA_FILTRATA);
        Azienda azienda = listaAziende.get(this.tabellaAziende.getSelectedRow());
        return azienda;
    }
    
    public void aggiornaTabella(){
        ModelloTabellaAziende modelloTabellaAziende = (ModelloTabellaAziende) this.tabellaAziende.getModel();
        List<Azienda> listaAzienda = (List<Azienda>) Applicazione.getInstance().getModello().getBean(Costanti.LISTA_FILTRATA);
        modelloTabellaAziende.setListaAziende(listaAzienda);
        modelloTabellaAziende.aggiornaContenuto();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        campoCitta = new javax.swing.JTextField();
        bottoneCerca = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabellaAziende = new javax.swing.JTable();
        bottoneInserisci = new javax.swing.JButton();

        jLabel1.setText("Nome Città:");

        bottoneCerca.setText("jButton1");

        tabellaAziende.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabellaAziende);

        bottoneInserisci.setText("jButton2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(campoCitta)
                        .addGap(18, 18, 18)
                        .addComponent(bottoneCerca))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bottoneInserisci)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoCitta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneCerca))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(bottoneInserisci)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCerca;
    private javax.swing.JButton bottoneInserisci;
    private javax.swing.JTextField campoCitta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabellaAziende;
    // End of variables declaration//GEN-END:variables
}
