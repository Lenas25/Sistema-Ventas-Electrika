package com.electrika.tech.controller;

import com.electrika.tech.dao.*;
import com.electrika.tech.dao.impl.*;
import com.electrika.tech.entidades.*;
import com.electrika.tech.view.InterManageProduct;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProductoController implements ActionListener {

    DaoProducto dao;
    DaoCategoria daoCat;
    DaoDistribuidor daoDis;
    DefaultTableModel table;
    private InterManageProduct view;

    public ProductoController(InterManageProduct view) {
        this.view = view;
        dao = new DaoProductoImpl();
        daoCat = new DaoCategoriaImpl();
        daoDis = new DaoDistribuidorImpl();
        view.setTitle("Gestion de Productos");
        table = (DefaultTableModel) view.tablePro.getModel();
        view.tablePro.setModel(table);
        view.btnAceptarEditar.setVisible(false);
        view.btnAceptarEliminar.setVisible(false);
        listado();
        for (Categoria cat : daoCat.select()) {
            if (cat.equals(null)) {

            } else {
                view.jComboCat.addItem(cat.toString());
            }
        }
        for (Distribuidor dis : daoDis.select()) {
            if (dis.equals(null)) {

            } else {
                view.jComboDis.addItem(dis.toString());
            }
        }
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

        view.txtNombre.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                int key = e.getKeyChar(); // solo letras y espacio

                boolean numeros = (key >= 65 && key <= 90) || (key >= 97 && key <= 122) || key == 32;

                if (!numeros) {
                    e.consume();
                }
            }
        });

        view.txtId.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                int key = e.getKeyChar(); // solo numeros con codigo ASCII

                boolean numeros = key >= 48 && key <= 57 && key != 32;

                if (!numeros) {
                    e.consume();
                }
            }
        });

        view.txtStock.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                int key = e.getKeyChar(); // solo numeros con codigo ASCII

                boolean numeros = key >= 48 && key <= 57 && key != 32;

                if (!numeros) {
                    e.consume();
                }
            }
        });

        view.txtPrecio.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                int key = e.getKeyChar(); // solo numeros con codigo ASCII

                boolean numeros = key >= 46 && key <= 57 && key != 47 && key != 32;

                if (!numeros) {
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
        table.setNumRows(0);
        view.tablePro.clearSelection();
        view.txtId.setText(null);
        view.txtNombre.setText(null);
        view.txtDescripcion.setText(null);
        view.txtStock.setText(null);
        view.txtPrecio.setText(null);
        view.jComboCat.setSelectedIndex(0);
        view.jComboDis.setSelectedIndex(0);

        for (Object[] fila : dao.verData()) {
            table.addRow(fila);
        }
    }

    private void habilitar(boolean opc) {
        view.txtNombre.setEnabled(opc);
        view.txtDescripcion.setEnabled(opc);
        view.txtPrecio.setEnabled(opc);
        view.txtStock.setEnabled(opc);
        view.jComboCat.setEnabled(opc);
        view.jComboDis.setEnabled(opc);
        view.btnAceptarAgregar.setEnabled(opc);
        view.btnAceptarEditar.setEnabled(opc);
        view.btnAceptarEliminar.setEnabled(opc);
        view.btnCancelar.setEnabled(opc);
        view.btnAgregar.setEnabled(!opc);
        view.btnEditar.setEnabled(!opc);
        view.btnEliminar.setEnabled(!opc);
    }

    private void aceptarAgregar() {
        boolean bool = view.txtNombre.getText().isEmpty() || view.txtDescripcion.getText().isEmpty() || view.txtPrecio.getText().isEmpty() || view.txtStock.getText().isEmpty();
        if (bool) {
            JOptionPane.showMessageDialog(null, "Debes completar todos los datos");
        } else {
            String nombre = capitalizeFirstLetter(view.txtNombre.getText());
            String descripcion = capitalizeFirstLetter(view.txtDescripcion.getText());
            Integer stock = Integer.valueOf(view.txtStock.getText());
            Double precio = Double.valueOf(view.txtPrecio.getText());
            String cat = view.jComboCat.getSelectedItem().toString();
            String dis = view.jComboDis.getSelectedItem().toString();
            Categoria categoriaSeleccionada = null;
            for (Categoria categoria : daoCat.select()) {
                if (categoria.getNombre().equals(cat)) {
                    categoriaSeleccionada = categoria;
                    break;
                }
            }
            Distribuidor distribuidorSeleccionado = null;
            for (Distribuidor distribuidor : daoDis.select()) {
                if (distribuidor.getNombre().equals(dis)) {
                    distribuidorSeleccionado = distribuidor;
                    break;
                }
            }

            JOptionPane.showMessageDialog(null,
                    dao.insert(new Producto(null, nombre, descripcion, stock, precio, categoriaSeleccionada, distribuidorSeleccionado)));
            listado();
            habilitar(false);
        }
    }

    private void aceptarEditar() {
        Integer id = Integer.valueOf(view.txtId.getText());
        boolean bool1 = view.txtId.getText().isEmpty() || view.txtNombre.getText().isEmpty() || view.txtDescripcion.getText().isEmpty() || view.txtPrecio.getText().isEmpty() || view.txtStock.getText().isEmpty();
        if (view.txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un id");
        } else if (bool1) {
            JOptionPane.showMessageDialog(null, "No puedes guardar productos vacios");
        } else {
            String nombre = capitalizeFirstLetter(view.txtNombre.getText());
            String descripcion = capitalizeFirstLetter(view.txtDescripcion.getText());
            Integer stock = Integer.valueOf(view.txtStock.getText());
            Double precio = Double.valueOf(view.txtPrecio.getText());
            String cat = view.jComboCat.getSelectedItem().toString();
            String dis = view.jComboDis.getSelectedItem().toString();

            Categoria categoriaSeleccionada = null;
            for (Categoria categoria : daoCat.select()) {
                if (categoria.getNombre().equals(cat)) {
                    categoriaSeleccionada = categoria;
                    break;
                }
            }
            Distribuidor distribuidorSeleccionado = null;
            for (Distribuidor distribuidor : daoDis.select()) {
                if (distribuidor.getNombre().equals(dis)) {
                    distribuidorSeleccionado = distribuidor;
                    break;
                }
            }

            JOptionPane.showMessageDialog(null,
                    dao.update(new Producto(id, nombre, descripcion, stock, precio, categoriaSeleccionada, distribuidorSeleccionado)));
            listado();
            view.txtId.setEnabled(false);
            view.btnBuscar.setEnabled(false);
            habilitar(false);
        }
    }

    private void aceptarEliminar() {
        Integer id = Integer.valueOf(view.txtId.getText());
        dao.delete(id);
        listado();
        habilitar(false);
    }

    private void cancelar() {
        habilitar(false);
        view.txtId.setText(null);
        view.txtNombre.setText(null);
        view.txtDescripcion.setText(null);
        view.txtPrecio.setText(null);
        view.txtStock.setText(null);
        view.txtId.setEnabled(false);
        view.btnBuscar.setEnabled(false);
        listado();
    }

    private void agregar() {
        habilitar(true);
        view.btnAceptarEditar.setVisible(false);
        view.btnAceptarAgregar.setVisible(true);
        view.btnAceptarEliminar.setVisible(false);
    }

    private void buscar() {
        habilitar(true);
        view.txtId.setEnabled(false);
        Integer id = Integer.valueOf(view.txtId.getText());
        if (view.txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa un Id");
        } else if (dao.get(id) != null) {
            Producto pro = dao.get(id);
            view.txtNombre.setText(pro.getNombreProducto());
            view.txtDescripcion.setText(pro.getDescripcionProducto());
            view.txtStock.setText(pro.getStock().toString());
            view.txtPrecio.setText(pro.getPrecioUnidad().toString());
            view.jComboCat.setSelectedItem(pro.getCategoria().getNombre());
            view.jComboDis.setSelectedItem(pro.getDistribuidor().getNombre());
        }
    }

    private void editar() {
        view.btnAgregar.setEnabled(false);
        view.btnEditar.setEnabled(false);
        view.btnEliminar.setEnabled(false);
        JOptionPane.showMessageDialog(null, "Ya puedes ingresar un id");
        view.btnAceptarEditar.setVisible(true);
        view.btnAceptarAgregar.setVisible(false);
        view.btnAceptarEliminar.setVisible(false);
        view.txtId.setEnabled(true);
        view.btnBuscar.setEnabled(true);
        view.btnCancelar.setEnabled(true);
    }

    private void eliminar() {
        Integer fila = view.tablePro.getSelectedRow();
        if (view.tablePro.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos para eliminar");
        } else if (fila >= 0) {
            view.btnAceptarEditar.setVisible(false);
            view.btnAceptarAgregar.setVisible(false);
            view.btnAceptarEliminar.setVisible(true);
            view.txtId.setText(view.tablePro.getValueAt(fila, 0).toString());
            view.txtNombre.setText(view.tablePro.getValueAt(fila, 1).toString());
            view.txtDescripcion.setText(view.tablePro.getValueAt(fila, 2).toString());
            view.txtStock.setText(view.tablePro.getValueAt(fila, 3).toString());
            view.txtPrecio.setText(view.tablePro.getValueAt(fila, 4).toString());
            view.jComboCat.setSelectedItem(view.tablePro.getValueAt(fila, 5).toString());
            view.jComboDis.setSelectedItem(view.tablePro.getValueAt(fila, 6).toString());
            view.btnAceptarEliminar.setEnabled(true);
            view.btnCancelar.setEnabled(true);
            view.btnAgregar.setEnabled(false);
            view.btnEditar.setEnabled(false);
            view.btnEliminar.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Debes elegir una fila");
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
