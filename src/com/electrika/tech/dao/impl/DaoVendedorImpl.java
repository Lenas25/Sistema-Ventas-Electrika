package com.electrika.tech.dao.impl;

import com.electrika.tech.dao.DaoVendedor;
import com.electrika.tech.entidades.Vendedor;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.electrika.tech.util.ConectaBD;
import java.util.Objects;

public class DaoVendedorImpl implements DaoVendedor {

    private ConectaBD con;
    private String mensaje;
    public static Map<Integer, Vendedor> empleado;
    private static Integer idEmpleado = null;

    public DaoVendedorImpl() {
        con = new ConectaBD();
        empleado = new HashMap<>();
    }

    @Override
    public String iniciar(Vendedor vendedor) {
        boolean usuarioPasswordExist = empleado.values().stream()
                .anyMatch(ven -> Objects.equals(ven.getUsuario(), vendedor.getUsuario()));
        if (vendedor != null && !usuarioPasswordExist) {
            idEmpleado = vendedor.getCodUsuario();
            empleado.put(idEmpleado, vendedor);
            mensaje = "Se registro en map un nuevo empleado";
            return mensaje;
        } else {
            mensaje = "El usuario ya existe";
            return mensaje;
        }
    }

    @Override
    public Vendedor getEmpleado() {
        return empleado.get(idEmpleado);
    }

    @Override
    public String getMessage() {
        return mensaje;
    }

    @Override
    public Vendedor login(String user, String pass) {
        Vendedor empleado = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idVendedor,")
                .append("apellido,")
                .append("nombre,")
                .append("usuario")
                .append(" FROM Vendedor")
                .append(" WHERE usuario = ?")
                .append(" AND AES_DECRYPT(password, ?)=?");
        try (Connection c = con.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                empleado = new Vendedor();
                empleado.setCodUsuario(rs.getInt(1));
                empleado.setApellidoUsuario(rs.getString(2));
                empleado.setNombreUsuario(rs.getString(3));
                empleado.setUsuario(rs.getString(4));
                mensaje = "Credenciales correctas";
            } else {
                mensaje = "Credenciales inválidas";
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return empleado;
    }

    @Override
    public List<Vendedor> select() {
        List<Vendedor> lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idVendedor,")
                .append("apellido,")
                .append("nombre,")
                .append("puestoArea,")
                .append("usuario,")
                .append("fechaIngreso,")
                .append("fechaSalida ")
                .append(" FROM Vendedor");
        //try con recursos para no usar el finally
        //lo va a cerrar funcione o falle
        try (Connection c = con.getConexion()) {
            //PreparedStatement limpia de inyecciones a la secuencia sql
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            //mientras exista un registro resultSet continúa
            lista = new ArrayList<>();
            while (rs.next()) {
                Vendedor vendedor = new Vendedor();
                vendedor.setCodUsuario(rs.getInt(1));
                vendedor.setApellidoUsuario(rs.getString(2));
                vendedor.setNombreUsuario(rs.getString(3));
                vendedor.setPuestoArea(rs.getObject(4).toString());
                vendedor.setUsuario(rs.getString(5));
                vendedor.setFechaIngreso(rs.getString(6));
                vendedor.setFechaSalida(rs.getString(7));
                lista.add(vendedor);
                iniciar(vendedor);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public String insert(Vendedor vendedor) {
        if (empleado.isEmpty()) {
            mensaje = "No hay empleados";
            return mensaje;
        }
        // Verificar si el nombre de usuario ya existe
        String mensaje = iniciar(vendedor);
        if (mensaje.equals("El usuario ya existe")) {
            return mensaje;
        } else {
            // Si no existe, proceder con la inserción
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO Vendedor(")
                    .append("apellido,")
                    .append("nombre,")
                    .append("puestoArea,")
                    .append("usuario,")
                    .append("password,")
                    .append("fechaIngreso,")
                    .append("fechaSalida")
                    .append(") VALUES (?,?,?,?,AES_ENCRYPT(?,?),?,?)");

            try (Connection c = con.getConexion()) {
                PreparedStatement ps = c.prepareStatement(sql.toString());
                ps.setString(1, vendedor.getApellidoUsuario());
                ps.setString(2, vendedor.getNombreUsuario());
                ps.setString(3, vendedor.getPuestoArea());
                ps.setString(4, vendedor.getUsuario());
                ps.setString(5, vendedor.getPassword());
                ps.setString(6, vendedor.getPassword());
                ps.setString(7, vendedor.getFechaIngreso());
                ps.setString(8, vendedor.getFechaSalida());

                // Agregar el nuevo vendedor al mapa antes de ejecutar la inserción
                empleado.put(vendedor.getCodUsuario(), vendedor);

                mensaje = (ps.executeUpdate() != 0) ? "Se registró correctamente" : "No se insertó el vendedor";
            } catch (Exception e) {
                mensaje = e.getMessage();
            }
            return mensaje;
        }
    }

    @Override
    public String update(Vendedor vendedor) {
        Vendedor aux = get(vendedor.getCodUsuario());
        if (aux == null) {
            mensaje = "El vendedor no existe";
            return mensaje;
        }
        String mensaje = iniciar(vendedor);
        if (mensaje.equals("El usuario ya existe")) {
            return mensaje;
        } else {
            // Si no hay conflictos, proceder con la actualización
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE Vendedor SET ")
                    .append("apellido = ?,")
                    .append("nombre = ?,")
                    .append("puestoArea = ?,")
                    .append("usuario = ?,")
                    .append("password = AES_ENCRYPT(?, ?),")
                    .append("fechaIngreso = ?,")
                    .append("fechaSalida = ?")
                    .append(" WHERE idVendedor = ?");

            try (Connection c = con.getConexion()) {
                PreparedStatement ps = c.prepareStatement(sql.toString());
                ps.setString(1, vendedor.getApellidoUsuario());
                ps.setString(2, vendedor.getNombreUsuario());
                ps.setString(3, vendedor.getPuestoArea());
                ps.setString(4, vendedor.getUsuario());
                ps.setString(5, vendedor.getPassword());
                ps.setString(6, vendedor.getPassword());
                ps.setString(7, vendedor.getFechaIngreso());
                ps.setString(8, vendedor.getFechaSalida());
                ps.setInt(9, vendedor.getCodUsuario());

                mensaje = (ps.executeUpdate() == 0) ? "No se actualizó" : "Se actualizó, no te olvides tu contraseña actualizada";
            } catch (Exception e) {
                mensaje = e.getMessage();
            }
            return mensaje;
        }
    }

    @Override
    public String delete(Integer id) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM Vendedor ")
                .append("WHERE idVendedor = ?");
        try (Connection c = con.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setInt(1, id);
            mensaje = (ps.executeUpdate() == 0) ? "No se eliminó" : "Se eliminó correctamente";
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public Vendedor get(Integer id) {
        Vendedor ven = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idVendedor,")
                .append("apellido,")
                .append("nombre,")
                .append("puestoArea,")
                .append("usuario,")
                .append("fechaIngreso,")
                .append("fechaSalida")
                .append(" FROM Vendedor")
                .append(" WHERE idVendedor =?");

        try (Connection c = con.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ven = new Vendedor();
                ven.setCodUsuario(rs.getInt(1));
                ven.setApellidoUsuario(rs.getString(2));
                ven.setNombreUsuario(rs.getString(3));
                ven.setPuestoArea(rs.getString(4));
                ven.setUsuario(rs.getString(5));
                ven.setFechaIngreso(rs.getString(6));
                ven.setFechaSalida(rs.getString(7));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }

        return ven;
    }

    @Override
    public String updateFecha(Vendedor vendedor) {
        Vendedor aux = get(vendedor.getCodUsuario());
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE Vendedor SET ")
                .append("fechaIngreso = ?,")
                .append("fechaSalida = ?")
                .append(" WHERE idVendedor = ?");
        try (Connection c = con.getConexion()) {
            if (aux != null) {
                PreparedStatement ps = c.prepareStatement(sql.toString());
                ps.setString(1, vendedor.getFechaIngreso());
                ps.setString(2, vendedor.getFechaSalida());
                ps.setInt(3, vendedor.getCodUsuario());

                mensaje = (ps.executeUpdate() == 0) ? "No se actualizó" : "Se actualizaron las fechas";
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

}
