/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Entidades.Placa;
import Entidades.Vehiculo;
import Persistencia.ILicenciaDAO;
import Persistencia.IPersonaDAO;
import Persistencia.PlacaDAO;
import Persistencia.VehiculoDAO;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 * Formulario de Pantalla Matricula
 *
 * @author Marcos Toledo 00000234963
 */
public class PantallaMatricula extends javax.swing.JFrame {

    /**
     * Declaracion de Variables de el Form
     */
    private final IPersonaDAO personaDAO;
    private final ILicenciaDAO licenciaDAO;
    private final VehiculoDAO vehiculoDAO = new VehiculoDAO();
    private final PlacaDAO placaDAO = new PlacaDAO();

    /**
     * Metodo Constructor de la Clase
     *
     * @param personaDAO persona
     * @param licenciaDAO licencia
     */
    public PantallaMatricula(IPersonaDAO personaDAO, ILicenciaDAO licenciaDAO) {
        this.personaDAO = personaDAO;
        this.licenciaDAO = licenciaDAO;
        initComponents();
        btnPago.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        btnPago = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNumSerie = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        lblMatricula = new javax.swing.JLabel();
        lblCoste = new javax.swing.JLabel();
        btnVerificar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnRegresar.setBackground(new java.awt.Color(255, 153, 153));
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegresar.setText("Regresar al Menu Principal");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnPago.setBackground(new java.awt.Color(204, 255, 153));
        btnPago.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPago.setText("Imprime pago");
        btnPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("RFC");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Tendra un costo de");

        txtNumSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumSerieKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Matricula:");

        lblMatricula.setText("Matricula");

        lblCoste.setText("Coste");

        btnVerificar.setText("Verificar");
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(btnPago)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addGap(32, 32, 32))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCoste, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNumSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVerificar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNumSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerificar))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblMatricula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblCoste))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPago)
                    .addComponent(btnRegresar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(153, 102, 0));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Solicitud de Matriculas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Boton que Despliega el Form Menu para regresar al Menu
     *
     * @param evt evento
     */
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        PantallaMenu frmMenu = new PantallaMenu(personaDAO, licenciaDAO);
        frmMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    /**
     * Verifica que cada vez que escribas no contega letras y algunas
     * validaciones extras.
     *
     * @param evt evento
     */
    private void txtNumSerieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumSerieKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
        //Solo permite 10 digitos
        String text = txtNumSerie.getText();
        if (text.length() >= 17) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNumSerieKeyTyped

    /**
     * Boton que Despliega los metodos para guardar las placas en la base de
     * datos.
     *
     * @param evt evento
     */
    private void btnPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagoActionPerformed
        // TODO add your handling code here:

        Vehiculo vehiculo = new Vehiculo();
        vehiculo = vehiculoDAO.buscarVehiculo(txtNumSerie.getText());

        if (vehiculo != null) {
            vehiculoDAO.setPlaca(recolectaDatos(), vehiculo);
            txtNumSerie.setText("");
            JOptionPane.showMessageDialog(null, "Las placas: "
                    + lblMatricula.getText() + " se han asignado correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            lblMatricula.setText("");
            lblCoste.setText("");
            btnPago.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Las placas no se han asignado correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_btnPagoActionPerformed

    /**
     * Boton que verifica que el numero de serie exista y algunos metodos extra
     * para generarlas
     *
     * @param evt evento
     */
    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        // TODO add your handling code here:
        Vehiculo vehiculo = new Vehiculo();
        vehiculo = buscaVehiculo(txtNumSerie.getText());
        if (vehiculo != null) {
            lblMatricula.setText(generarPlaca());
            btnPago.setEnabled(true);
            JOptionPane.showMessageDialog(null, "El vehiculo con numero de serie: "
                    + txtNumSerie.getText() + " existe", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            if (vehiculo.getPlaca() != null) {
                JOptionPane.showMessageDialog(null, "El vehiculo con numero de serie: "
                        + txtNumSerie.getText() + "Tiene placas existentes", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                lblCoste.setText("1000");
            } else {
                JOptionPane.showMessageDialog(null, "El vehiculo con numero de serie: "
                        + txtNumSerie.getText() + " no tiene placas existentes", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                lblCoste.setText("1500");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El vehiculo con numero de serie: "
                    + txtNumSerie.getText() + " no existe", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnVerificarActionPerformed

    /**
     * Despliega la informacion de placa
     *
     * @return placa
     */
    public Placa recolectaDatos() {
        Placa placa = new Placa();
        placa.setCosto(Integer.parseInt(lblCoste.getText()));
        placa.setNumero(lblMatricula.getText());
        return placa;
    }

    /**
     * Despliega la informacion de vehiculo
     *
     * @param numSerie
     * @return vehiculo
     */
    public Vehiculo buscaVehiculo(String numSerie) {
        return vehiculoDAO.buscarVehiculo(numSerie);

    }

    /**
     * Genera una placa aleatoria.
     *
     * @return placa
     */
    public static String generarPlaca() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "0123456789";
        StringBuilder placa = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int indiceLetra = (int) (Math.random() * letras.length());
            placa.append(letras.charAt(indiceLetra));
        }
        for (int i = 0; i < 3; i++) {
            int indiceNumero = (int) (Math.random() * numeros.length());
            placa.append(numeros.charAt(indiceNumero));
        }
        return placa.toString();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new PantallaMatricula().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPago;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCoste;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JTextField txtNumSerie;
    // End of variables declaration//GEN-END:variables
}
