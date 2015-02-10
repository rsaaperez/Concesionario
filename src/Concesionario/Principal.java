/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concesionario;

import Objetos.Coche;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rsaaperez
 */
public class Principal extends javax.swing.JFrame {
//Concesionario.
    private Coche c;
    private Conexion con = new Conexion();
    private Metodos met = new Metodos();
    private String marca = null, modelo = null, año = null, precio = null, modeloViejo = null;
    private Object[][] dtCoches;

    //Añade icono al jframe
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Imagenes/icono1.png"));

        return retValue;
    }

    /**
     * Creates new form Principal
     */
    public Principal() throws SQLException {
        initComponents();
        con.getConexion();
        this.cENombre.setModel(con.LlenarComboBox());
        this.cBNombre.setModel(con.LlenarComboBox());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        vAñadir = new javax.swing.JDialog();
        tAñadido = new javax.swing.JLabel();
        vAcerca = new javax.swing.JDialog();
        jLabel10 = new javax.swing.JLabel();
        vDEditar = new javax.swing.JDialog();
        tEAñadido = new javax.swing.JLabel();
        vBorrar = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        pInicial = new javax.swing.JPanel();
        paneles = new javax.swing.JTabbedPane();
        pVisualizar = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        panelVisualizar = new javax.swing.JPanel();
        cVMarca = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        bVisualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        pAñadir = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tAModelo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cAMarca = new javax.swing.JComboBox();
        cAAño = new javax.swing.JComboBox();
        eACmc = new javax.swing.JLabel();
        tAPrecio = new javax.swing.JTextField();
        bAñadir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        pEditar = new javax.swing.JPanel();
        bEditar = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        cENombre = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        eACmc1 = new javax.swing.JLabel();
        tEPrecio = new javax.swing.JTextField();
        tEModelo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cEMarca = new javax.swing.JComboBox();
        cEAño = new javax.swing.JComboBox();
        jLabel30 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pBorrar = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        cBNombre = new javax.swing.JComboBox();
        bBorrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        mArchivo = new javax.swing.JMenu();
        mSalir = new javax.swing.JMenuItem();
        mAyuda = new javax.swing.JMenu();
        macerca = new javax.swing.JMenuItem();

        vAñadir.setIconImage(getIconImage());
        vAñadir.setMinimumSize(new java.awt.Dimension(357, 100));

        tAñadido.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tAñadido.setText("El coche ha sido añadido correctamente.");

        javax.swing.GroupLayout vAñadirLayout = new javax.swing.GroupLayout(vAñadir.getContentPane());
        vAñadir.getContentPane().setLayout(vAñadirLayout);
        vAñadirLayout.setHorizontalGroup(
            vAñadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vAñadirLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(tAñadido)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        vAñadirLayout.setVerticalGroup(
            vAñadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vAñadirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tAñadido)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        vAcerca.setFocusable(false);
        vAcerca.setIconImage(getIconImage());
        vAcerca.setMinimumSize(new java.awt.Dimension(500, 150));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Aplicacion de coches terminada, que la disfruten. :D");

        javax.swing.GroupLayout vAcercaLayout = new javax.swing.GroupLayout(vAcerca.getContentPane());
        vAcerca.getContentPane().setLayout(vAcercaLayout);
        vAcercaLayout.setHorizontalGroup(
            vAcercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vAcercaLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel10)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        vAcercaLayout.setVerticalGroup(
            vAcercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vAcercaLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel10)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        vDEditar.setMinimumSize(new java.awt.Dimension(280, 130));

        tEAñadido.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        tEAñadido.setText("Modificación aplicada.");

        javax.swing.GroupLayout vDEditarLayout = new javax.swing.GroupLayout(vDEditar.getContentPane());
        vDEditar.getContentPane().setLayout(vDEditarLayout);
        vDEditarLayout.setHorizontalGroup(
            vDEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vDEditarLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(tEAñadido)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        vDEditarLayout.setVerticalGroup(
            vDEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vDEditarLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(tEAñadido)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        vBorrar.setMinimumSize(new java.awt.Dimension(400, 100));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("El coche ha sido eliminado correctamente.");

        javax.swing.GroupLayout vBorrarLayout = new javax.swing.GroupLayout(vBorrar.getContentPane());
        vBorrar.getContentPane().setLayout(vBorrarLayout);
        vBorrarLayout.setHorizontalGroup(
            vBorrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vBorrarLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        vBorrarLayout.setVerticalGroup(
            vBorrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vBorrarLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Concesionario");
        setFocusTraversalPolicyProvider(true);
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(750, 550));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pInicial.setMinimumSize(new java.awt.Dimension(750, 680));
        pInicial.setPreferredSize(new java.awt.Dimension(750, 680));
        pInicial.setLayout(new java.awt.CardLayout());

        paneles.setMinimumSize(new java.awt.Dimension(900, 680));
        paneles.setPreferredSize(new java.awt.Dimension(900, 680));

        pVisualizar.setMinimumSize(new java.awt.Dimension(670, 670));
        pVisualizar.setPreferredSize(new java.awt.Dimension(670, 670));
        pVisualizar.setLayout(new javax.swing.BoxLayout(pVisualizar, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel1.setLayout(new java.awt.GridBagLayout());

        panelVisualizar.setLayout(new java.awt.GridBagLayout());

        cVMarca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todas las marcas", "BMW", "Seat", "Renault", "Fiat", "Rover", "Audi", "Mercedes" }));
        cVMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cVMarcaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 11, 0);
        panelVisualizar.add(cVMarca, gridBagConstraints);

        jLabel14.setText("¿Desea filtrar por marca?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 10, 0, 0);
        panelVisualizar.add(jLabel14, gridBagConstraints);

        bVisualizar.setText("Visualizar Coches");
        bVisualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVisualizarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 10);
        panelVisualizar.add(bVisualizar, gridBagConstraints);

        jLabel1.setText("Presione el boton para visualizar nuestra lista de stock.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 0, 0);
        panelVisualizar.add(jLabel1, gridBagConstraints);

        jPanel1.add(panelVisualizar, new java.awt.GridBagConstraints());

        pVisualizar.add(jPanel1);

        tabla.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Modelo", "Marca", "Año", "Precio"
            }
        ));
        tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tabla);

        pVisualizar.add(jScrollPane1);

        paneles.addTab("Visualizar lista", pVisualizar);

        pAñadir.setMinimumSize(new java.awt.Dimension(670, 670));
        pAñadir.setPreferredSize(new java.awt.Dimension(670, 670));
        pAñadir.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Modelo:");
        pAñadir.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, -1, -1));

        tAModelo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        tAModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tAModeloActionPerformed(evt);
            }
        });
        pAñadir.add(tAModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 133, -1));

        jLabel6.setText("Marca:");
        pAñadir.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        jLabel9.setText("Año:");
        pAñadir.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, -1, -1));

        cAMarca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona un marca", "BMW", "Seat", "Renault", "Fiat", "Rover", "Audi", "Mercedes" }));
        cAMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cAMarcaActionPerformed(evt);
            }
        });
        pAñadir.add(cAMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, -1));

        cAAño.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona un año", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015" }));
        cAAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cAAñoActionPerformed(evt);
            }
        });
        pAñadir.add(cAAño, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, -1, -1));

        eACmc.setText("Precio:");
        pAñadir.add(eACmc, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, -1, -1));

        tAPrecio.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        tAPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tAPrecioActionPerformed(evt);
            }
        });
        pAñadir.add(tAPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 61, -1));

        bAñadir.setText("Añadir");
        bAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAñadirActionPerformed(evt);
            }
        });
        pAñadir.add(bAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/horizontal1.jpg"))); // NOI18N
        pAñadir.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 440, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono1.png"))); // NOI18N
        pAñadir.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, -1));

        paneles.addTab("Añadir Coche", pAñadir);

        pEditar.setMinimumSize(new java.awt.Dimension(670, 670));
        pEditar.setPreferredSize(new java.awt.Dimension(670, 670));
        pEditar.setLayout(null);

        bEditar.setText("Editar");
        bEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditarActionPerformed(evt);
            }
        });
        pEditar.add(bEditar);
        bEditar.setBounds(380, 180, 61, 23);

        jLabel23.setText("Indica el Coche a editar:");
        pEditar.add(jLabel23);
        jLabel23.setBounds(190, 30, 150, 14);

        cENombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cENombreActionPerformed(evt);
            }
        });
        pEditar.add(cENombre);
        cENombre.setBounds(330, 30, 180, 20);

        jLabel11.setText("Modelo:");
        pEditar.add(jLabel11);
        jLabel11.setBounds(110, 110, 50, 14);

        eACmc1.setText("Precio:");
        pEditar.add(eACmc1);
        eACmc1.setBounds(230, 170, 50, 14);

        tEPrecio.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        tEPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tEPrecioActionPerformed(evt);
            }
        });
        pEditar.add(tEPrecio);
        tEPrecio.setBounds(270, 160, 60, 25);

        tEModelo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        tEModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tEModeloActionPerformed(evt);
            }
        });
        pEditar.add(tEModelo);
        tEModelo.setBounds(160, 100, 140, 25);

        jLabel15.setText("Marca:");
        pEditar.add(jLabel15);
        jLabel15.setBounds(310, 80, 50, 14);

        cEMarca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona un marca", "BMW", "Seat", "Renault", "Fiat", "Rover", "Audi", "Mercedes" }));
        cEMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cEMarcaActionPerformed(evt);
            }
        });
        pEditar.add(cEMarca);
        cEMarca.setBounds(350, 80, 150, 20);

        cEAño.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona un año", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015" }));
        cEAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cEAñoActionPerformed(evt);
            }
        });
        pEditar.add(cEAño);
        cEAño.setBounds(430, 130, 140, 20);

        jLabel30.setText("Año:");
        pEditar.add(jLabel30);
        jLabel30.setBounds(400, 130, 40, 14);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/horizontal2.jpg"))); // NOI18N
        pEditar.add(jLabel8);
        jLabel8.setBounds(160, 310, 450, 150);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono1.png"))); // NOI18N
        jLabel12.setText("jLabel12");
        pEditar.add(jLabel12);
        jLabel12.setBounds(60, 0, 630, 321);

        paneles.addTab("Editar Coche", pEditar);

        pBorrar.setLayout(new java.awt.GridBagLayout());

        jLabel24.setText("Indica el Coche que deseas borrar:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 32;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(151, 199, 0, 0);
        pBorrar.add(jLabel24, gridBagConstraints);

        cBNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBNombreActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 152;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(148, 392, 0, 0);
        pBorrar.add(cBNombre, gridBagConstraints);

        bBorrar.setText("Borrar");
        bBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBorrarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(68, 339, 0, 0);
        pBorrar.add(bBorrar, gridBagConstraints);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono1.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(48, 89, 0, 0);
        pBorrar.add(jLabel3, gridBagConstraints);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/horizontal3.jpg"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = -30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(69, 28, 147, 145);
        pBorrar.add(jLabel7, gridBagConstraints);

        paneles.addTab("Borrar Coche", pBorrar);

        pInicial.add(paneles, "card2");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 11, 10);
        getContentPane().add(pInicial, gridBagConstraints);

        mArchivo.setText("Archivo");

        mSalir.setText("Salir");
        mSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSalirActionPerformed(evt);
            }
        });
        mArchivo.add(mSalir);

        menu.add(mArchivo);

        mAyuda.setText("Ayuda");

        macerca.setText("Acerca de");
        macerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                macercaActionPerformed(evt);
            }
        });
        mAyuda.add(macerca);

        menu.add(mAyuda);

        setJMenuBar(menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void macercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_macercaActionPerformed
        vAcerca.setVisible(true);
    }//GEN-LAST:event_macercaActionPerformed

    private void mSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mSalirActionPerformed

    private void bBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBorrarActionPerformed
        modelo = cBNombre.getSelectedItem().toString();
        try {
            Metodos.borrar(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        vBorrar.setVisible(true);
        this.cENombre.setModel(con.LlenarComboBox());
        this.cBNombre.setModel(con.LlenarComboBox());

    }//GEN-LAST:event_bBorrarActionPerformed

    private void cBNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBNombreActionPerformed
        //actualiza los datos de la tabla realizando una consulta a la base de datos
        String[] columNames = {"Modelo", "Marca", "Año", "Precio"};
        dtCoches = con.Select_Coches();
        // se colocan los datos en la tabla
        DefaultTableModel datos = new DefaultTableModel(dtCoches, columNames);
        tabla.setModel(datos);
    }//GEN-LAST:event_cBNombreActionPerformed

    private void cEAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cEAñoActionPerformed
        if (cEAño.getSelectedIndex() == 1) {
            año = "2005";
        } else if (cEAño.getSelectedIndex() == 2) {
            año = "2006";
        } else if (cEAño.getSelectedIndex() == 3) {
            año = "2007";
        } else if (cEAño.getSelectedIndex() == 4) {
            año = "2008";
        } else if (cEAño.getSelectedIndex() == 5) {
            año = "2009";
        } else if (cEAño.getSelectedIndex() == 6) {
            año = "2010";
        } else if (cEAño.getSelectedIndex() == 7) {
            año = "2011";
        } else if (cEAño.getSelectedIndex() == 8) {
            año = "2012";
        } else if (cEAño.getSelectedIndex() == 9) {
            año = "2013";
        } else if (cEAño.getSelectedIndex() == 10) {
            año = "2014";
        } else if (cEAño.getSelectedIndex() == 10) {
            año = "2015";
        }
    }//GEN-LAST:event_cEAñoActionPerformed

    private void cEMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cEMarcaActionPerformed
        if (cEMarca.getSelectedIndex() == 1) {
            marca = "BMW";
        } else if (cEMarca.getSelectedIndex() == 2) {
            marca = "Seat";
        } else if (cEMarca.getSelectedIndex() == 3) {
            marca = "Renault";
        } else if (cEMarca.getSelectedIndex() == 4) {
            marca = "Fiat";
        } else if (cEMarca.getSelectedIndex() == 5) {
            marca = "Rover";
        } else if (cEMarca.getSelectedIndex() == 6) {
            marca = "Audi";
        } else if (cEMarca.getSelectedIndex() == 7) {
            marca = "Mercedes";
        }
    }//GEN-LAST:event_cEMarcaActionPerformed

    private void tEModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tEModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tEModeloActionPerformed

    private void tEPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tEPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tEPrecioActionPerformed

    private void cENombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cENombreActionPerformed
        //actualiza los datos de la tabla realizando una consulta a la base de datos
        String[] columNames = {"Modelo", "Marca", "Año", "Precio"};
        dtCoches = con.Select_Coches();
        // se colocan los datos en la tabl
        DefaultTableModel datos = new DefaultTableModel(dtCoches, columNames);
        tabla.setModel(datos);
    }//GEN-LAST:event_cENombreActionPerformed

    private void bEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditarActionPerformed
        modelo = tEModelo.getText();
        precio = tEPrecio.getText();
        boolean ex = false;
        modeloViejo = cENombre.getSelectedItem().toString();
        dtCoches = con.Select_Coches();
        for (int i = 0; i < dtCoches.length; i++) {
            if (modelo.equalsIgnoreCase(dtCoches[i][0].toString())) {
                ex = true;
            }
        }
        if ("".equals(modelo) || año == null || marca == null || precio == null) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
        } else {
            if (ex == true && !modelo.equalsIgnoreCase(modeloViejo)) {
                JOptionPane.showMessageDialog(null, "Ya disponemos de ese modelo en nuestra base de datos.");
            } else {
                tEAñadido.setText("Modificación aplicada.");
                try {
                    Metodos.editar(modeloViejo, modelo, año, precio, marca);
                } catch (SQLException ex1) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex1);
                }
                vDEditar.setVisible(true);
                this.cENombre.setModel(con.LlenarComboBox());
                this.cBNombre.setModel(con.LlenarComboBox());
            }

        }
    }//GEN-LAST:event_bEditarActionPerformed

    private void bAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAñadirActionPerformed
        modelo = tAModelo.getText();
        precio = tAPrecio.getText();
        boolean ex = false;
        dtCoches = con.Select_Coches();
        for (int i = 0; i < dtCoches.length; i++) {
            if (modelo.equalsIgnoreCase(dtCoches[i][0].toString())) {
                ex = true;
            }
        }
        if ("".equals(modelo) || año == null || marca == null || precio == null) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
        } else {
            if (ex == true) {
                JOptionPane.showMessageDialog(null, "Ese coche ya esta almacenado en nuestro sistema.");
            } else {
                tAñadido.setText("Coche insertado correctamente.");
                try {
                    Metodos.insertar(marca, modelo, año, precio);
                } catch (SQLException ex1) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex1);
                }
                vAñadir.setVisible(true);
                this.cENombre.setModel(con.LlenarComboBox());
                this.cBNombre.setModel(con.LlenarComboBox());
            }
        }
    }//GEN-LAST:event_bAñadirActionPerformed

    private void tAPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tAPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tAPrecioActionPerformed

    private void cAAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cAAñoActionPerformed
        if (cAAño.getSelectedIndex() == 1) {
            año = "2005";
        } else if (cAAño.getSelectedIndex() == 2) {
            año = "2006";
        } else if (cAAño.getSelectedIndex() == 3) {
            año = "2007";
        } else if (cAAño.getSelectedIndex() == 4) {
            año = "2008";
        } else if (cAAño.getSelectedIndex() == 5) {
            año = "2009";
        } else if (cAAño.getSelectedIndex() == 6) {
            año = "2010";
        } else if (cAAño.getSelectedIndex() == 7) {
            año = "2011";
        } else if (cAAño.getSelectedIndex() == 8) {
            año = "2012";
        } else if (cAAño.getSelectedIndex() == 9) {
            año = "2013";
        } else if (cAAño.getSelectedIndex() == 10) {
            año = "2014";
        } else if (cAAño.getSelectedIndex() == 10) {
            año = "2015";
        }
    }//GEN-LAST:event_cAAñoActionPerformed

    private void cAMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cAMarcaActionPerformed
        if (cAMarca.getSelectedIndex() == 1) {
            marca = "BMW";
        } else if (cAMarca.getSelectedIndex() == 2) {
            marca = "Seat";
        } else if (cAMarca.getSelectedIndex() == 3) {
            marca = "Renault";
        } else if (cAMarca.getSelectedIndex() == 4) {
            marca = "Fiat";
        } else if (cAMarca.getSelectedIndex() == 5) {
            marca = "Rover";
        } else if (cAMarca.getSelectedIndex() == 6) {
            marca = "Audi";
        } else if (cAMarca.getSelectedIndex() == 7) {
            marca = "Mercedes";
        }
    }//GEN-LAST:event_cAMarcaActionPerformed

    private void tAModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tAModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tAModeloActionPerformed

    private void bVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVisualizarActionPerformed
        //actualiza los datos de la tabla realizando una consulta a la base de datos
        String[] columNames = {"Modelo", "Marca", "Año", "Precio"};
        if(cVMarca.getSelectedIndex()==0){
            dtCoches = con.Select_Coches();
        }else{
            dtCoches = con.Select_Coches_Marca(marca);
        }
        // se colocan los datos en la tabla
        DefaultTableModel datos = new DefaultTableModel(dtCoches, columNames);
        tabla.setModel(datos);
    }//GEN-LAST:event_bVisualizarActionPerformed

    private void cVMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cVMarcaActionPerformed
        if (cVMarca.getSelectedIndex() == 1) {
            marca = "BMW";
        } else if (cVMarca.getSelectedIndex() == 2) {
            marca = "Seat";
        } else if (cVMarca.getSelectedIndex() == 3) {
            marca = "Renault";
        } else if (cVMarca.getSelectedIndex() == 4) {
            marca = "Fiat";
        } else if (cVMarca.getSelectedIndex() == 5) {
            marca = "Rover";
        } else if (cVMarca.getSelectedIndex() == 6) {
            marca = "Audi";
        } else if (cVMarca.getSelectedIndex() == 7) {
            marca = "Mercedes";
        }
    }//GEN-LAST:event_cVMarcaActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Principal().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAñadir;
    private javax.swing.JButton bBorrar;
    private javax.swing.JButton bEditar;
    private javax.swing.JButton bVisualizar;
    private javax.swing.JComboBox cAAño;
    private javax.swing.JComboBox cAMarca;
    private javax.swing.JComboBox cBNombre;
    private javax.swing.JComboBox cEAño;
    private javax.swing.JComboBox cEMarca;
    private javax.swing.JComboBox cENombre;
    private javax.swing.JComboBox cVMarca;
    private javax.swing.JLabel eACmc;
    private javax.swing.JLabel eACmc1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu mArchivo;
    private javax.swing.JMenu mAyuda;
    private javax.swing.JMenuItem mSalir;
    private javax.swing.JMenuItem macerca;
    private javax.swing.JMenuBar menu;
    private javax.swing.JPanel pAñadir;
    private javax.swing.JPanel pBorrar;
    private javax.swing.JPanel pEditar;
    private javax.swing.JPanel pInicial;
    private javax.swing.JPanel pVisualizar;
    private javax.swing.JPanel panelVisualizar;
    private javax.swing.JTabbedPane paneles;
    private javax.swing.JTextField tAModelo;
    private javax.swing.JTextField tAPrecio;
    private javax.swing.JLabel tAñadido;
    private javax.swing.JLabel tEAñadido;
    private javax.swing.JTextField tEModelo;
    private javax.swing.JTextField tEPrecio;
    private javax.swing.JTable tabla;
    private javax.swing.JDialog vAcerca;
    private javax.swing.JDialog vAñadir;
    private javax.swing.JDialog vBorrar;
    private javax.swing.JDialog vDEditar;
    // End of variables declaration//GEN-END:variables
}