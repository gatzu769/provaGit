package it.unibas.aziende.vista;

import it.unibas.aziende.Applicazione;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;


public class Frame extends javax.swing.JFrame {
    
    static{
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e){
            
        }
    }

    public void inizializza() {
        initComponents();
        this.setContentPane(new JScrollPane(Applicazione.getInstance().getVistaPrincipale()));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.inizializzaAzione();
    }
    
    public void inizializzaAzione(){
       this.MenuCarica.setAction(Applicazione.getInstance().getControlloMenu().getAzioneCarica());
       this.menuEsci.setAction(Applicazione.getInstance().getControlloMenu().getAzioneEsci());
       this.menuVerifica.setAction(Applicazione.getInstance().getControlloMenu().getAzioneVerifica());
       this.menuCerca.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneCerca());
       
    }
    
    public void mostraMessaggio(String messaggio){
        JOptionPane.showMessageDialog(this, messaggio, this.getTitle() + "-Messaggio", JOptionPane.INFORMATION_MESSAGE);
    }
    
     public void mostraMessaggioErrore(String messaggio){
        JOptionPane.showMessageDialog(this, messaggio, this.getTitle() + "-Errore", JOptionPane.ERROR_MESSAGE);
     }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MenuCarica = new javax.swing.JMenuItem();
        menuCerca = new javax.swing.JMenuItem();
        menuVerifica = new javax.swing.JMenuItem();
        menuEsci = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aziende");

        jMenu1.setText("File");

        MenuCarica.setText("jMenuItem1");
        jMenu1.add(MenuCarica);

        menuCerca.setText("jMenuItem2");
        jMenu1.add(menuCerca);

        menuVerifica.setText("jMenuItem3");
        jMenu1.add(menuVerifica);

        menuEsci.setText("jMenuItem4");
        jMenu1.add(menuEsci);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuCarica;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuCerca;
    private javax.swing.JMenuItem menuEsci;
    private javax.swing.JMenuItem menuVerifica;
    // End of variables declaration//GEN-END:variables
}
