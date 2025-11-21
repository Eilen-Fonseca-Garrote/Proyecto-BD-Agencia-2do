package services;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import utils.Conexion;
import model.Reclamacion;

// ... otras importaciones si las necesitas

public class ReclamacionServices {
    Conexion cx;

    public ReclamacionServices() {
        cx = new Conexion();
    }

    public boolean insertarReclamacion(Reclamacion reclamacion) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("INSERT INTO public.reclamacion( fechasiniestro, montoreclamado, montoindemnizado, numpoliza, idestadoreclamacion, idsiniestro)VALUES ( ?, ?, ?, ?, ?, ?);");
            ps.setDate(1, reclamacion.getFechaSiniestro());
            ps.setDouble(2, reclamacion.getMontoReclamado());
            ps.setDouble(3, reclamacion.getMontoIndemnizado());
            ps.setInt(4, reclamacion.getNumPoliza());
            ps.setInt(5, reclamacion.getIdEstadoReclamacion());
            ps.setInt(6, reclamacion.getIdSiniestro());
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

    public ArrayList<Reclamacion> consultarReclamaciones() {
        ArrayList<Reclamacion> lista = new ArrayList<Reclamacion>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM reclamacion");
            rs = ps.executeQuery();
            while (rs.next()) {
                Reclamacion r = new Reclamacion(rs.getInt("numeroreclamacion"), rs.getDate("fechasiniestro"), rs.getDouble("montoreclamado"), rs.getDouble("montoindemnizado"), rs.getInt("numpoliza"), rs.getInt("idestadoreclamacion"), rs.getInt("idsiniestro"));
                lista.add(r);
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

    public boolean eliminarReclamacion(int id) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("DELETE FROM reclamacion WHERE numeroreclamacion = ?");
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

    public boolean modificarReclamacion(Reclamacion reclamacion) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("UPDATE reclamacion SET fechasiniestro = ?, montoreclamado = ?, montoindemnizado = ?, numpoliza = ?, idestadoreclamacion = ?, idsiniestro = ? WHERE numeroreclamacion = ?");
            ps.setDate(1, reclamacion.getFechaSiniestro());
            ps.setDouble(2, reclamacion.getMontoReclamado());
            ps.setDouble(3, reclamacion.getMontoIndemnizado());
            ps.setInt(4, reclamacion.getNumPoliza());
            ps.setInt(5, reclamacion.getIdEstadoReclamacion());
            ps.setInt(6, reclamacion.getIdSiniestro());
            ps.setInt(7, reclamacion.getNumeroReclamacion());
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

