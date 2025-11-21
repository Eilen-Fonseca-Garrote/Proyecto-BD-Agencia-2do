package services;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import utils.Conexion;
import model.Siniestro;

// ... otras importaciones si las necesitas

public class SiniestroServices {
    Conexion cx;

    public SiniestroServices() {
        cx = new Conexion();
    }

    public boolean insertarSiniestro(Siniestro siniestro) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("INSERT INTO public.siniestro( tiposiniestro)VALUES ( ?);");
            ps.setString(1, siniestro.getTipoSiniestro());
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

    public ArrayList<Siniestro> consultarSiniestros() {
        ArrayList<Siniestro> lista = new ArrayList<Siniestro>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM siniestro");
            rs = ps.executeQuery();
            while (rs.next()) {
                Siniestro s = new Siniestro(rs.getInt("idsiniestro"), rs.getString("tiposiniestro"));
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

    public boolean eliminarSiniestro(int id) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("DELETE FROM siniestro WHERE idsiniestro = ?");
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

    public boolean modificarSiniestro(Siniestro siniestro) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("UPDATE siniestro SET tiposiniestro = ? WHERE idsiniestro = ?");
            ps.setString(1, siniestro.getTipoSiniestro());
            ps.setInt(2, siniestro.getIdSiniestro());
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

