
package com.electrika.tech.view;

public class InterManageDistribuidor extends javax.swing.JInternalFrame {

    public InterManageDistribuidor() {        
        initComponents();       
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDistri = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        txtCode = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtDirection = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnAceptarEliminar = new javax.swing.JButton();
        btnAceptarEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAceptarAgregar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tableDistri.setBackground(new java.awt.Color(255, 255, 255));
        tableDistri.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdDistribuidor", "Ruc", "Nombre", "Direccion", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableDistri);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 740, 240));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Gestionar Distribuidor");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, -1));

        txtRuc.setBorder(javax.swing.BorderFactory.createTitledBorder("Ruc"));
        txtRuc.setEnabled(false);
        jPanel1.add(txtRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 230, 40));

        txtCode.setBorder(javax.swing.BorderFactory.createTitledBorder("Codigo"));
        txtCode.setEnabled(false);
        jPanel1.add(txtCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 180, -1));

        txtName.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre"));
        txtName.setEnabled(false);
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 420, 40));

        txtDirection.setBorder(javax.swing.BorderFactory.createTitledBorder("Direccion"));
        txtDirection.setEnabled(false);
        jPanel1.add(txtDirection, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 420, 40));

        txtPhone.setBorder(javax.swing.BorderFactory.createTitledBorder("Telefono"));
        txtPhone.setEnabled(false);
        jPanel1.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 230, 40));

        btnEditar.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/editar-codigo.png"))); // NOI18N
        btnEditar.setText("Editar");
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 160, 150, 40));

        btnEliminar.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/basura.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, 150, 40));

        btnAgregar.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/agregar-usuario.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 150, -1));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/lupa1.png"))); // NOI18N
        btnBuscar.setEnabled(false);
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 60, 40));

        btnAceptarEliminar.setText("Aceptar");
        btnAceptarEliminar.setEnabled(false);
        jPanel1.add(btnAceptarEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 80, 30));

        btnAceptarEditar.setText("Aceptar");
        btnAceptarEditar.setEnabled(false);
        jPanel1.add(btnAceptarEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 80, 30));

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 80, 30));

        btnAceptarAgregar.setText("Aceptar");
        btnAceptarAgregar.setEnabled(false);
        jPanel1.add(btnAceptarAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 80, 30));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 740, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/distri.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, 510, 820));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    public javax.swing.JTable tableDistri;
    public javax.swing.JTextField txtCode;
    public javax.swing.JTextField txtDirection;
    public javax.swing.JTextField txtName;
    public javax.swing.JTextField txtPhone;
    public javax.swing.JTextField txtRuc;
    // End of variables declaration//GEN-END:variables
}
