package services;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import utils.Conexion;
import model.Seguro;

// ... otras importaciones si las necesitas

public class SeguroServices {
    Conexion cx;

    public SeguroServices() {
        cx = new Conexion();
    }

    public boolean insertarSeguro(Seguro seguro) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("INSERT INTO public.seguro( tipo)VALUES ( ?);");
            ps.setString(1, seguro.getTipo());
            ps.executeUpdate();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
          if (e instanceof SQLException) {
              // Maneja la excepción SQLException
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

    public ArrayList<Seguro> consultarSeguros() {
        ArrayList<Seguro> lista = new ArrayList<Seguro>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM seguro");
            rs = ps.executeQuery();
            while (rs.next()) {
                Seguro s = new Seguro(rs.getInt("idtiposeguro"), rs.getString("tipo"));
                lista.add(s);
            }
        } catch (SQLException e) {
          if (e instanceof SQLException) {
              // Maneja la excepción SQLException
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

    public boolean eliminarSeguro(int id) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("DELETE FROM seguro WHERE idtiposeguro = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
          if (e instanceof SQLException) {
              // Maneja la excepción SQLException
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

    public boolean modificarSeguro(Seguro seguro) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("UPDATE seguro SET tipo = ? WHERE idtiposeguro = ?");
            ps.setString(1, seguro.getTipo());
            ps.setInt(2, seguro.getIdTipoSeguro());
            ps.executeUpdate();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
          if (e instanceof SQLException) {
              // Maneja la excepción SQLException
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

