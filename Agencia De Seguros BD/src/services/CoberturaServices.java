package services;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Cobertura;
import utils.Conexion;

// ... otras importaciones si las necesitas

public class CoberturaServices {
    Conexion cx;

    public CoberturaServices() {
        cx = new Conexion();
    }

    public boolean insertarCobertura(Cobertura cobertura) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("INSERT INTO public.cobertura( tipocobertura)VALUES ( ?);");
            ps.setString(1, cobertura.getTipoCobertura());
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

    public ArrayList<Cobertura> consultarCoberturas() {
        ArrayList<Cobertura> lista = new ArrayList<Cobertura>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM cobertura");
            rs = ps.executeQuery();
            while (rs.next()) {
                Cobertura c = new Cobertura(rs.getInt("idcobertura"), rs.getString("tipocobertura"));
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

    public boolean eliminarCobertura(int id) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("DELETE FROM cobertura WHERE idcobertura = ?");
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

    public boolean modificarCobertura(Cobertura cobertura) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("UPDATE cobertura SET tipocobertura = ? WHERE idcobertura = ?");
            ps.setString(1, cobertura.getTipoCobertura());
            ps.setInt(2, cobertura.getIdCobertura());
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

