/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Entidades.Licencia;
import Persistencia.IPersonaDAO;
import Persistencia.ILicenciaDAO;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import Entidades.Persona;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Marcos Toledo 00000234963
 */
public class PantallaLicencia extends javax.swing.JFrame {

    private final IPersonaDAO personaDAO;
    private final ILicenciaDAO licenciaDAO;
    String existe = "Espera";
    int anios = 0;

    /**
     * Creates new form PantallaMenu
     */
    public PantallaLicencia(IPersonaDAO personaDAO, ILicenciaDAO licenciaDAO) {
        this.personaDAO = personaDAO;
        this.licenciaDAO = licenciaDAO;
        initComponents();
        //Esto permite que no se puedan escribir dentro de los fields hasta que se verifique.
        btnGenerar.setText("Generar Licencia");
        txtNombre.setEnabled(false);
        txtFechaN.setEnabled(false);
        txtTelefono.setEnabled(false);
        rbSi.setEnabled(false);
        rbNo.setEnabled(false);
        rb1.setEnabled(false);
        rb2.setEnabled(false);
        rb3.setEnabled(false);
    }

    public Persona obtieneDatosPersona() {
        Persona persona = new Persona();
        persona.setRFC(txtRFC.getText());
        persona.setNombre(txtNombre.getText());
        persona.setFechaNacimiento(txtFechaN.getDate());
        persona.setTelefono(txtTelefono.getText());
        if (rbSi.isSelected()) {
            persona.setDiscapacitado(true);
        }
        if (rbNo.isSelected()) {
            persona.setDiscapacitado(false);
        }
        return persona;
    }

    public String obtieneRFC(String RFC) {
        Persona persona = new Persona();
        persona.setRFC(RFC);
        return RFC;
    }

    public String obtieneTelefono(String telefono) {
        Persona persona = new Persona();
        persona.setTelefono(telefono);
        return telefono;
    }

    private void buscarPersona(String RFC) {
        String existePersona = obtieneRFC(RFC);
        Persona seBuscoPersona = this.personaDAO.buscarPersona(RFC);
        if (seBuscoPersona != null) {
        } else {
            JOptionPane.showMessageDialog(this, "La persona no existe\nPuedes rellenar los espacios", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public Licencia obtieneDatosLicencia() {
        Date fechaActual = new Date();
        Licencia licencia = new Licencia();
        Persona persona = obtieneDatosPersona();
        licencia.setPersona(persona);
        //Creacion de la seleccion de vigencia segun los radiobuttons.
        if (rbSi.isSelected()) {
            licencia.setTipo("Discapacitado");
            if (rb1.isSelected()) {
                licencia.setVigencia(1);
                licencia.setCosto(200);
            }
            if (rb2.isSelected()) {
                licencia.setVigencia(2);
                licencia.setCosto(500);
            }
            if (rb3.isSelected()) {
                licencia.setVigencia(3);
                licencia.setCosto(700);
            }
        }
        if (rbNo.isSelected()) {
            licencia.setTipo("Normal");
            if (rb1.isSelected()) {
                licencia.setVigencia(1);
                licencia.setCosto(600);
            }
            if (rb2.isSelected()) {
                licencia.setVigencia(2);
                licencia.setCosto(900);
            }
            if (rb3.isSelected()) {
                licencia.setVigencia(3);
                licencia.setCosto(1100);
            }
        }

        //Creación de la fecha con vigencia
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaActual);
        anios = licencia.getVigencia();
        calendar.add(Calendar.YEAR, anios);
        Date DateVigencia = calendar.getTime();
        licencia.setVigenciaF(DateVigencia);
        licencia.setEstado("Vigente");
        System.out.println("licencia:" + licencia);
        return licencia;
    }

    private void agregarPersona(Persona persona) {
        Persona nuevaPersona = obtieneDatosPersona();
        Persona seAgregoPersona = this.personaDAO.agregarPersona(persona);
        if (seAgregoPersona != null) {
        } else {
            JOptionPane.showMessageDialog(this, "No fue posible agregar la Persona", "Informacion", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregarLicencia(Licencia licencia) {
        Licencia nuevaLicencia = obtieneDatosLicencia();
        Licencia seAgregoLicencia = this.licenciaDAO.agregarLicencia(licencia);
        if (seAgregoLicencia != null) {
        } else {
            JOptionPane.showMessageDialog(this, "No fue posible agregar la Licencia", "Informacion", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jPanel2 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtRFC = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        rbSi = new javax.swing.JRadioButton();
        rbNo = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        rb3 = new javax.swing.JRadioButton();
        rb2 = new javax.swing.JRadioButton();
        txtCosto = new javax.swing.JLabel();
        btnGenerar = new javax.swing.JButton();
        txtFechaN = new com.toedter.calendar.JDateChooser();
        btnExistencia = new javax.swing.JButton();
        rb1 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

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

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("RFC:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Nombre Completo:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Fecha de Nacimiento:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Telefono:");

        txtRFC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRFCKeyTyped(evt);
            }
        });

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("¿Es discapacitado?");

        rbSi.setText("Si");
        rbSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSiActionPerformed(evt);
            }
        });

        rbNo.setText("No");
        rbNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Vigencia:");

        rb3.setText("3 Años");
        rb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb3ActionPerformed(evt);
            }
        });

        rb2.setText("2 Años");
        rb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb2ActionPerformed(evt);
            }
        });

        txtCosto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCosto.setText("El costo de la licencia sera de - ???");

        btnGenerar.setBackground(new java.awt.Color(204, 255, 153));
        btnGenerar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGenerar.setText("Genera Licencia");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        btnExistencia.setBackground(new java.awt.Color(204, 255, 153));
        btnExistencia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExistencia.setText("Verifica existencia");
        btnExistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExistenciaActionPerformed(evt);
            }
        });

        rb1.setText("1 Año");
        rb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRegresar)
                        .addGap(19, 19, 19))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefono))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRFC))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFechaN, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(btnExistencia)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCosto)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rb1)
                                .addGap(1, 1, 1)
                                .addComponent(rb2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rb3))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbSi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbNo)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(btnGenerar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExistencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtFechaN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(rbSi)
                    .addComponent(rbNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(rb3)
                    .addComponent(rb2)
                    .addComponent(rb1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCosto)
                .addGap(18, 18, 18)
                .addComponent(btnGenerar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(153, 102, 0));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tramitar Licencias");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        PantallaMenu frmMenu = new PantallaMenu(personaDAO, licenciaDAO);
        frmMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void rbSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSiActionPerformed
        // TODO add your handling code here:
        if (rbSi.isSelected()) {
            rbNo.setSelected(false); // Deselecciona NO si SI está seleccionado
        }
    }//GEN-LAST:event_rbSiActionPerformed

    private void rbNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNoActionPerformed
        // TODO add your handling code here:
        if (rbNo.isSelected()) {
            rbSi.setSelected(false); // Deselecciona SI si NO está seleccionado
        }
    }//GEN-LAST:event_rbNoActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        // TODO add your handling code here:
        if (existe.equals("Espera")) {
            JOptionPane.showMessageDialog(this, "Por favor, verifica primero para continuar.", "Verifique campos", JOptionPane.ERROR_MESSAGE);
        }
        if (existe.equals("PrimeraVez")) {
            if (!txtRFC.getText().isEmpty() && !txtNombre.getText().isEmpty()
                    && txtFechaN.getDate() != null && !txtTelefono.getText().isEmpty()
                    && (rbSi.isSelected() ^ rbNo.isSelected())
                    && (rb1.isSelected() ^ rb2.isSelected() ^ rb3.isSelected())) {
                System.out.println("licencia2:" + obtieneDatosLicencia());
                agregarLicencia(obtieneDatosLicencia());
                JOptionPane.showMessageDialog(this, "Se genero con exito la licencia de la \n RFC: " + txtRFC.getText(), "Licencia Generada", JOptionPane.INFORMATION_MESSAGE);
                PantallaMenu frmMenu = new PantallaMenu(personaDAO, licenciaDAO);
                frmMenu.setVisible(true);
                this.dispose();
            } else {
                // Muestra mensaje de error si no se cumplen las condiciones
                JOptionPane.showMessageDialog(this, "Por favor, verifica los campos y seleccione las opciones correctas.", "Verifique campos", JOptionPane.ERROR_MESSAGE);
            }
        }

        /*
        if (existe == "Renovacion") {
            String RFC = txtRFC.getText();
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
            EntityManager em = emf.createEntityManager();
            try {
                // Realizar una consulta en la base de datos para verificar si la RFC ingresada ya existe
                Query query = em.createQuery("SELECT p FROM Persona p WHERE p.RFC = :RFC");
                query.setParameter("RFC", RFC);
                Persona persona = (Persona) query.getSingleResult();
                persona.setTelefono(txtTelefono.getText());
                if (rbSi.isSelected()) {
                    persona.setDiscapacitado(true);
                }
                if (rbNo.isSelected()) {
                    persona.setDiscapacitado(false);
                }

                Date fechaActual = new Date();
                persona.getLicencias();
                Licencia licencia = new Licencia();

                if (rbSi.isSelected()) {
                    licencia.setTipo("Discapacitado");
                    if (rb1.isSelected()) {
                        licencia.setVigencia(1);
                    }
                    if (rb2.isSelected()) {
                        licencia.setVigencia(2);
                    }
                    if (rb3.isSelected()) {
                        licencia.setVigencia(3);
                    }
                } else {
                    licencia.setTipo("Normal");
                    if (rb1.isSelected()) {
                        licencia.setVigencia(1);
                    }
                    if (rb2.isSelected()) {
                        licencia.setVigencia(2);
                    }
                    if (rb3.isSelected()) {
                        licencia.setVigencia(3);
                    }
                }

                //Creación de la fecha con vigencia
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(fechaActual);
                anios = licencia.getVigencia();
                calendar.add(Calendar.YEAR, anios);
                Date DateVigencia = calendar.getTime();
                licencia.setVigenciaF(DateVigencia);
                //licencia.setCosto(licencia.obtenerCosto());
                licencia.setPersona(persona);
                //txtCosto.setText("El costo de la licencia sera de $ " + licencia.obtenerCosto());
                em.getTransaction().begin();
                em.merge(persona);
                em.merge(licencia);
                em.getTransaction().commit();
                JOptionPane.showMessageDialog(this, "Se renovó con éxito la licencia \n RFC: " + txtRFC.getText(), "Licencia Renovada", JOptionPane.INFORMATION_MESSAGE);
                PantallaMenu frmMenu = new PantallaMenu();
                frmMenu.setVisible(true);
                this.dispose();

            } catch (NoResultException ex) {
                // La RFC ingresada no se encontró en la base de datos
                JOptionPane.showMessageDialog(this, "La persona no existe", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }*/

    }//GEN-LAST:event_btnGenerarActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_SPACE) {
            evt.consume(); // Elimina si se ingresa un numero
        } else {
            super.processKeyEvent(evt); // Permite otros eventos de teclado
        }
        txtNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (txtNombre.getText().length() >= 50) {
                    e.consume();
                }
            }
        });
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        //solo permite que se ingresen numeros
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
        //Solo permite 10 digitos
        String text = txtTelefono.getText();
        if (text.length() >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void btnExistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExistenciaActionPerformed
        // TODO add your handling code here:
        if (!txtRFC.getText().isEmpty()) {
            this.buscarPersona(obtieneRFC(txtRFC.getText()));
            Persona persona = personaDAO.buscarPersona(obtieneRFC(txtRFC.getText()));;
            if ((persona) != null) {
                txtNombre.setText(persona.getNombre());
                txtFechaN.setDate(persona.getFechaNacimiento());
                txtTelefono.setText(persona.getTelefono());
                rbSi.setEnabled(true);
                rbNo.setEnabled(true);
                rb1.setEnabled(true);
                rb2.setEnabled(true);
                rb3.setEnabled(true);
                txtTelefono.setEnabled(true);
                existe = "Renovacion";
                btnGenerar.setText("Renovar Licencia");
            } else {
                txtNombre.setEnabled(true);
                txtFechaN.setEnabled(true);
                txtTelefono.setEnabled(true);
                rbSi.setEnabled(true);
                rbNo.setEnabled(true);
                rb1.setEnabled(true);
                rb2.setEnabled(true);
                rb3.setEnabled(true);
                existe = "PrimeraVez";
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, de rellenar el campo vacio.", "Verifique campos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExistenciaActionPerformed

    private void rb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb1ActionPerformed
        // TODO add your handling code here:
        if (rb1.isSelected()) {
            rb2.setSelected(false); // Deselecciona rb2 si rb1 está seleccionado
            rb3.setSelected(false); // Deselecciona rb3 si rb1 está seleccionado
        }
    }//GEN-LAST:event_rb1ActionPerformed

    private void rb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb3ActionPerformed
        // TODO add your handling code here:
        if (rb3.isSelected()) {
            rb1.setSelected(false); // Deselecciona rb1 si rb3 está seleccionado
            rb2.setSelected(false); // Deselecciona rb2 si rb3 está seleccionado
        }
    }//GEN-LAST:event_rb3ActionPerformed

    private void rb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb2ActionPerformed
        // TODO add your handling code here:
        if (rb2.isSelected()) {
            rb1.setSelected(false); // Deselecciona rb1 si rb2 está seleccionado
            rb3.setSelected(false); // Deselecciona rb3 si rb2 está seleccionado
        }
    }//GEN-LAST:event_rb2ActionPerformed

    private void txtRFCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRFCKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetterOrDigit(c) || c == KeyEvent.VK_BACK_SPACE) {
            super.processKeyEvent(evt);
        } else {
            evt.consume();
        }
        txtRFC.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (txtRFC.getText().length() >= 13) {
                    e.consume();
                }
            }
        });
    }//GEN-LAST:event_txtRFCKeyTyped

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaLicencia.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaLicencia.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaLicencia.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaLicencia.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new PantallaLicencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExistencia;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JRadioButton rb1;
    private javax.swing.JRadioButton rb2;
    private javax.swing.JRadioButton rb3;
    private javax.swing.JRadioButton rbNo;
    private javax.swing.JRadioButton rbSi;
    private javax.swing.JLabel txtCosto;
    private com.toedter.calendar.JDateChooser txtFechaN;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRFC;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
