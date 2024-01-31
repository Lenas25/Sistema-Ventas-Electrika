package com.electrika.tech.view;

public class InterManageClient extends javax.swing.JInternalFrame {

    public InterManageClient() {      
        initComponents();       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableClients = new javax.swing.JTable();
        txtId = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        txtApellido = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        txtTelefono = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        btnAceptarAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAceptarEditar = new javax.swing.JButton();
        btnAceptarEliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableClients.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        tableClients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Dni", "Apellido", "Nombre", "Teléfono", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableClients);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 880, 220));

        txtId.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtId.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Id Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        txtId.setEnabled(false);
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 110, 40));

        btnEliminar.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/basura.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setFocusPainted(false);
        btnEliminar.setPreferredSize(new java.awt.Dimension(80, 30));
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 210, 130, 40));

        txtNombre.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        txtNombre.setEnabled(false);
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 170, 40));

        btnEditar.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/editar-codigo.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setFocusPainted(false);
        btnEditar.setPreferredSize(new java.awt.Dimension(72, 30));
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 160, 130, 40));

        txtApellido.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtApellido.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Apellido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        txtApellido.setEnabled(false);
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 170, 40));

        txtCorreo.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtCorreo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Correo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        txtCorreo.setEnabled(false);
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 370, 40));

        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/informacion.png"))); // NOI18N
        btnBuscar.setEnabled(false);
        btnBuscar.setFocusPainted(false);
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 70, 60));

        btnAgregar.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/agregar-usuario.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setFocusPainted(false);
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 110, 130, 40));

        txtTelefono.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtTelefono.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Teléfono", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        txtTelefono.setEnabled(false);
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 170, 40));

        txtDni.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtDni.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Dni", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        txtDni.setEnabled(false);
        jPanel1.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 160, 40));

        btnAceptarAgregar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnAceptarAgregar.setForeground(new java.awt.Color(51, 51, 51));
        btnAceptarAgregar.setText("Aceptar");
        btnAceptarAgregar.setEnabled(false);
        jPanel1.add(btnAceptarAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 110, 30));

        btnCancelar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(51, 51, 51));
        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 110, 30));

        btnAceptarEditar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnAceptarEditar.setForeground(new java.awt.Color(51, 51, 51));
        btnAceptarEditar.setText("Aceptar");
        btnAceptarEditar.setEnabled(false);
        jPanel1.add(btnAceptarEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 110, 30));

        btnAceptarEliminar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnAceptarEliminar.setForeground(new java.awt.Color(51, 51, 51));
        btnAceptarEliminar.setText("Aceptar");
        btnAceptarEliminar.setEnabled(false);
        jPanel1.add(btnAceptarEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 110, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/satisfaccion-del-consumidor.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 830, -1));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        jLabel3.setText("Gestionar Clientes");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAceptarAgregar;
    public javax.swing.JButton btnAceptarEditar;
    public javax.swing.JButton btnAceptarEliminar;
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTable tableClients;
    public javax.swing.JTextField txtApellido;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtDni;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
