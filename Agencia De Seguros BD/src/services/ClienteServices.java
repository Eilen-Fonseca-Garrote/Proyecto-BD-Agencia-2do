package services;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Cliente;
import utils.Conexion;

// ... otras importaciones si las necesitas

public class ClienteServices {
    Conexion cx;

    public ClienteServices() {
        cx = new Conexion();
    }

    public boolean insertarCliente(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("INSERT INTO public.cliente( id, sexo, nombre, apellidos, edad, direccionpostal, telefono, correoelectronico, pais)VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            ps.setString(1, cliente.getId());
            ps.setString(2, String.valueOf(cliente.getSexo()));
            ps.setString(3, cliente.getNombre());
            ps.setString(4, cliente.getApellidos());
            ps.setInt(5, cliente.getEdad());
            ps.setString(6, cliente.getDireccionPostal());
            ps.setString(7, cliente.getTelefono());
            ps.setString(8, cliente.getCorreoElectronico());
            ps.setString(9, cliente.getPais());
            ps.executeUpdate();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
          if (e instanceof SQLException) {
              // Maneja la excepción PSQLException
              JOptionPane.showMessageDialog(null, 
                      e.getMessage(),
                      "Error SQL",
                      JOptionPane.ERROR_MESSAGE);

          } else {
              // Maneja otras excepciones SQL

          }
          return false;
      }
    }

    public ArrayList<Cliente> consultarClientes() {
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM cliente");
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente(rs.getString("id"), rs.getString("sexo").charAt(0), rs.getString("nombre"), rs.getString("apellidos"), rs.getInt("edad"), rs.getString("direccionpostal"), rs.getString("telefono"), rs.getString("correoelectronico"), rs.getString("pais"));
                lista.add(c);
            }
        } catch (SQLException e) {
          if (e instanceof SQLException) {
              // Maneja la excepción PSQLException
              JOptionPane.showMessageDialog(null, 
                      e.getMessage(),
                      "Error SQL",
                      JOptionPane.ERROR_MESSAGE);

          } else {
              // Maneja otras excepciones SQL

          }
      }
        return lista;
    }

    public boolean eliminarCliente(String id) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("DELETE FROM cliente WHERE id = ?");
            ps.setString(1, id);
            ps.executeUpdate();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
          if (e instanceof SQLException) {
              // Maneja la excepción PSQLException
              JOptionPane.showMessageDialog(null, 
                      e.getMessage(),
                      "Error SQL",
                      JOptionPane.ERROR_MESSAGE);

          } else {
              // Maneja otras excepciones SQL

          }
          return false;
      }
    }

    public boolean modificarCliente(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("UPDATE cliente SET sexo = ?, nombre = ?, apellidos = ?, edad = ?, direccionpostal = ?, telefono = ?, correoelectronico = ?, pais = ? WHERE id = ?");
            ps.setString(1, String.valueOf(cliente.getSexo()));
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellidos());
            ps.setInt(4, cliente.getEdad());
            ps.setString(5, cliente.getDireccionPostal());
            ps.setString(6, cliente.getTelefono());
            ps.setString(7, cliente.getCorreoElectronico());
            ps.setString(8, cliente.getPais());
            ps.setString(9, cliente.getId());
            ps.executeUpdate();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
          if (e instanceof SQLException) {
              // Maneja la excepción PSQLException
              JOptionPane.showMessageDialog(null, 
                      e.getMessage(),
                      "Error SQL",
                      JOptionPane.ERROR_MESSAGE);

          } else {
              // Maneja otras excepciones SQL

          }
          return false;
      }
    }
}

