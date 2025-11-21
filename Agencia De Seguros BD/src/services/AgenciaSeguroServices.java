package services;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import utils.Conexion;
import model.AgenciaSeguro;

// ... otras importaciones si las necesitas

public class AgenciaSeguroServices {
    Conexion cx;

    public AgenciaSeguroServices() {
        cx = new Conexion();
    }

    public boolean insertarAgenciaSeguro(AgenciaSeguro agenciaSeguro) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("INSERT INTO public.agenciaseguro( nombreagencia, direccionpostal, telefono, correoelectronico, idtiposeguro, directorgeneral, jefedepartamentoseguros, jefedepartamentoreclamaciones)VALUES ( ?, ?, ?, ?, ?, ?, ?, ?);");
            ps.setString(1, agenciaSeguro.getNombreAgencia());
            ps.setString(2, agenciaSeguro.getDireccionPostal());
            ps.setString(3, agenciaSeguro.getTelefono());
            ps.setString(4, agenciaSeguro.getCorreoElectronico());
            ps.setInt(5, agenciaSeguro.getIdTipoSeguro());
            ps.setString(6, agenciaSeguro.getDirectorGeneral());
            ps.setString(7, agenciaSeguro.getJefeDepartamentoSeguros());
            ps.setString(8, agenciaSeguro.getJefeDepartamentoReclamaciones());
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

    public ArrayList<AgenciaSeguro> consultarAgenciasSeguro() {
        ArrayList<AgenciaSeguro> lista = new ArrayList<AgenciaSeguro>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM agenciaseguro");
            rs = ps.executeQuery();
            while (rs.next()) {
                AgenciaSeguro a = new AgenciaSeguro(rs.getInt("idagencia"), rs.getString("nombreagencia"), rs.getString("direccionpostal"), rs.getString("telefono"), rs.getString("correoelectronico"), rs.getInt("idtiposeguro"), rs.getString("directorgeneral"), rs.getString("jefedepartamentoseguros"), rs.getString("jefedepartamentoreclamaciones"));
                lista.add(a);
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

    public boolean eliminarAgenciaSeguro(int id) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("DELETE FROM agenciaseguro WHERE idagencia = ?");
            ps.setInt(1, id);
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

    public boolean modificarAgenciaSeguro(AgenciaSeguro agenciaSeguro) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("UPDATE agenciaseguro SET nombreagencia = ?, direccionpostal = ?, telefono = ?, correoelectronico = ?, idtiposeguro = ?, directorgeneral = ?, jefedepartamentoseguros = ?, jefedepartamentoreclamaciones = ? WHERE idagencia = ?");
            ps.setString(1, agenciaSeguro.getNombreAgencia());
            ps.setString(2, agenciaSeguro.getDireccionPostal());
            ps.setString(3, agenciaSeguro.getTelefono());
            ps.setString(4, agenciaSeguro.getCorreoElectronico());
            ps.setInt(5, agenciaSeguro.getIdTipoSeguro());
            ps.setString(6, agenciaSeguro.getDirectorGeneral());
            ps.setString(7, agenciaSeguro.getJefeDepartamentoSeguros());
            ps.setString(8, agenciaSeguro.getJefeDepartamentoReclamaciones());
            ps.setInt(9, agenciaSeguro.getIdAgencia());
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

