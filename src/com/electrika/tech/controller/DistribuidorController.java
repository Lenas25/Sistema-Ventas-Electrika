package com.electrika.tech.controller;

import com.electrika.tech.dao.DaoDistribuidor;
import com.electrika.tech.dao.impl.DaoDistribuidorImpl;
import com.electrika.tech.entidades.Distribuidor;
import com.electrika.tech.view.InterManageDistribuidor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DistribuidorController implements ActionListener {

    DaoDistribuidor dao;
    DefaultTableModel tabla;
    private InterManageDistribuidor view;

    public DistribuidorController(InterManageDistribuidor view) {
        this.view = view;
        dao = new DaoDistribuidorImpl();
        tabla = new DefaultTableModel();
        view.setTitle("Gestionar Distribuidor");
        tabla = (DefaultTableModel) view.tableDistri.getModel();
        view.tableDistri.setModel(tabla);
        view.btnAceptarEditar.setVisible(false);
        view.btnAceptarEliminar.setVisible(false);
        listado();
        agregarEventos();
    }

    private void agregarEventos() {
        view.btnAceptarAgregar.addActionListener(this);
        view.btnAceptarEditar.addActionListener(this);
        view.btnAceptarEliminar.addActionListener(this);
        view.btnAgregar.addActionListener(this);
        view.btnBuscar.addActionListener(this);
        view.btnCancelar.addActionListener(this);
        view.btnEditar.addActionListener(this);
        view.btnEliminar.addActionListener(this);

        view.txtRuc.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                int key = e.getKeyChar(); // solo numeros con codigo ASCII

                boolean numeros = key >= 48 && key <= 57 && key != 32;
                String currentText = view.txtRuc.getText();
                boolean longitudPermitida = currentText.length() < 11;

                if (!numeros || !longitudPermitida) {
                    e.consume();
                }
            }
        });

        view.txtCode.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                int key = e.getKeyChar(); // solo numeros con codigo ASCII

                boolean numeros = key >= 48 && key <= 57 && key != 32;

                if (!numeros) {
                    e.consume();
                }
            }
        });

        view.txtPhone.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                int key = e.getKeyChar(); // solo numeros con codigo ASCII

                boolean numeros = key >= 48 && key <= 57 && key != 32;
                String currentText = view.txtPhone.getText();
                boolean longitudPermitida = currentText.length() < 9;
                if (!numeros || !longitudPermitida) {
                    e.consume();
                }
            }
        });

        view.txtName.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                int key = e.getKeyChar(); // solo letras y espacio

                boolean letras = (key >= 65 && key <= 90) || (key >= 97 && key <= 122);
                boolean espacio = key == 32;
                if (!(letras || espacio)) {
                    e.consume();
                }
            }
        });
    }

    public static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input; // Devolver el mismo texto si es nulo o vacío
        }

        // Convertir la primera letra a mayúscula y concatenar el resto del texto
        return String.format("%s%s", input.substring(0, 1).toUpperCase(), input.substring(1).toLowerCase());

    }

    private void listado() {
        tabla.setNumRows(0);
        view.tableDistri.clearSelection();
        view.txtRuc.setText(null);
        view.txtCode.setText(null);
        view.txtName.setText(null);
        view.txtDirection.setText(null);
        view.txtPhone.setText(null);

        for (Distribuidor dis : dao.select()) {
            Object[] objs = new Object[5];
            objs[0] = dis.getIdDistribuidor();
            objs[1] = dis.getRuc();
            objs[2] = dis.getNombre();
            objs[3] = dis.getDireccion();
            objs[4] = dis.getTelefono();
            tabla.addRow(objs);
        }
    }

    private void habilitar(boolean opc) {
        view.txtName.setEnabled(opc);
        view.txtDirection.setEnabled(opc);
        view.txtRuc.setEnabled(opc);
        view.txtPhone.setEnabled(opc);

        view.btnAceptarAgregar.setEnabled(opc);
        view.btnAceptarEditar.setEnabled(opc);
        view.btnAceptarEliminar.setEnabled(opc);

        view.btnCancelar.setEnabled(opc);
        view.btnAgregar.setEnabled(!opc);
        view.btnEditar.setEnabled(!opc);
        view.btnEliminar.setEnabled(!opc);

    }

    private void aceptarAgregar() {
        // TODO add your handling ide here:
        boolean bool = view.txtName.getText().isEmpty() || view.txtDirection.getText().isEmpty() || view.txtRuc.getText().isEmpty() || view.txtPhone.getText().isEmpty();
        if (bool) {
            JOptionPane.showMessageDialog(null, "Debes completar todos los datos");
        } else {
            String nombreDistribuidor = capitalizeFirstLetter(view.txtName.getText());
            String direccionDistribuidor = capitalizeFirstLetter(view.txtDirection.getText());
            String ruc = view.txtRuc.getText();
            String telefonoDistribuidor = view.txtPhone.getText();

            //Se crea un nuevo distribuidor
            Distribuidor distri = new Distribuidor(null, ruc, nombreDistribuidor, direccionDistribuidor, telefonoDistribuidor);
            dao.insert(distri);
            JOptionPane.showMessageDialog(null, "Se insertó un nuevo distribuidor");
            listado();
            habilitar(false);
        }
    }

    private void aceptarEditar() {
        Integer ide = Integer.valueOf(view.txtCode.getText());
        boolean bool1 = view.txtCode.getText().isEmpty() || view.txtName.getText().isEmpty() || view.txtDirection.getText().isEmpty() || view.txtRuc.getText().isEmpty() || view.txtPhone.getText().isEmpty();
        if (view.txtCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un idigo");
        } else if (bool1) {
            JOptionPane.showMessageDialog(null, "No puedes guardar clientes vacios");
        } else {
            String nombreDistribuidor = capitalizeFirstLetter(view.txtName.getText());
            String direccionDistribuidor = capitalizeFirstLetter(view.txtDirection.getText());
            String ruc = view.txtRuc.getText();
            String telefonoDistribuidor = view.txtPhone.getText();

            Distribuidor distri = new Distribuidor(ide, ruc, nombreDistribuidor, direccionDistribuidor, telefonoDistribuidor);
            dao.update(distri);
            JOptionPane.showMessageDialog(null, "Se acualizó el registro de un distribuidor");

            listado();
            view.txtCode.setEnabled(false);
            view.btnBuscar.setEnabled(false);
            habilitar(false);
        }
    }

    private void aceptarEliminar() {
        Integer ide = Integer.valueOf(view.txtCode.getText());
        dao.delete(ide);
        listado();
        JOptionPane.showMessageDialog(null, "Eliminación exitosa");
        habilitar(false);
    }

    private void cancelar() {
        habilitar(false);
        view.txtCode.setText(null);
        view.txtRuc.setText(null);
        view.txtName.setText(null);
        view.txtDirection.setText(null);
        view.txtPhone.setText(null);
        view.txtCode.setEnabled(false);
        view.btnBuscar.setEnabled(false);
        listado();
    }

    private void agregar() {
        habilitar(true);
        view.btnAceptarEditar.setVisible(false);
        view.btnAceptarAgregar.setVisible(true);
        view.btnAceptarEliminar.setVisible(false);
    }

    private void editar() {

        Integer fila = view.tableDistri.getSelectedRow();
        if (view.tableDistri.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos para actualizar");
        } else if (fila >= 0) {
            view.btnAceptarEditar.setVisible(true);
            view.btnAceptarAgregar.setVisible(false);
            view.btnAceptarEliminar.setVisible(false);

            view.txtCode.setText(view.tableDistri.getValueAt(fila, 0).toString());
            view.txtRuc.setText(view.tableDistri.getValueAt(fila, 1).toString());
            view.txtName.setText(view.tableDistri.getValueAt(fila, 2).toString());
            view.txtDirection.setText(view.tableDistri.getValueAt(fila, 3).toString());
            view.txtPhone.setText(view.tableDistri.getValueAt(fila, 4).toString());

            view.btnAceptarEditar.setEnabled(true);
            view.btnCancelar.setEnabled(true);
            habilitar(true);
            view.btnAgregar.setEnabled(false);
            view.btnEditar.setEnabled(false);
            view.btnEliminar.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Debes elegir una fila");
        }

    }

    private void eliminar() {
        Integer fila = view.tableDistri.getSelectedRow();
        if (view.tableDistri.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos para eliminar");
        } else if (fila >= 0) {
            //Se sabe que botón me lleva a que, entre los 3, mediante su visibilidad
            view.btnAceptarEditar.setVisible(false);
            view.btnAceptarAgregar.setVisible(false);
            view.btnAceptarEliminar.setVisible(true);
            view.txtCode.setText(view.tableDistri.getValueAt(fila, 0).toString());
            view.txtRuc.setText(view.tableDistri.getValueAt(fila, 1).toString());
            view.txtName.setText(view.tableDistri.getValueAt(fila, 2).toString());
            view.txtDirection.setText(view.tableDistri.getValueAt(fila, 3).toString());
            view.txtPhone.setText(view.tableDistri.getValueAt(fila, 4).toString());
            view.btnAceptarEliminar.setEnabled(true);
            view.btnCancelar.setEnabled(true);
            view.btnAgregar.setEnabled(false);
            view.btnEditar.setEnabled(false);
            view.btnEliminar.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Debes elegir una fila");
        }
    }

    private void buscar() {
        Integer cod = Integer.valueOf(view.txtCode.getText());
        if (view.txtCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa un Codigo");
        } else if (dao.get(cod) != null) {
            habilitar(true);
            Distribuidor dis = dao.get(cod);
            view.txtRuc.setText(dis.getRuc());
            view.txtName.setText(dis.getNombre());
            view.txtDirection.setText(dis.getDireccion());
            view.txtPhone.setText(dis.getTelefono());

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnAceptarAgregar) {
            aceptarAgregar();
        } else if (e.getSource() == view.btnAceptarEditar) {
            aceptarEditar();
        } else if (e.getSource() == view.btnAceptarEliminar) {
            aceptarEliminar();
        } else if (e.getSource() == view.btnAgregar) {
            agregar();
        } else if (e.getSource() == view.btnBuscar) {
            buscar();
        } else if (e.getSource() == view.btnCancelar) {
            cancelar();
        } else if (e.getSource() == view.btnEditar) {
            editar();
        } else if (e.getSource() == view.btnEliminar) {
            eliminar();
        }
    }
}
