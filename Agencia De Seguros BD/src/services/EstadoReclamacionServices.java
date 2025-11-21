package services;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import utils.Conexion;
import model.EstadoReclamacion;

// ... otras importaciones si las necesitas

public class EstadoReclamacionServices {
    Conexion cx;

    public EstadoReclamacionServices() {
        cx = new Conexion();
    }

    public boolean insertarEstadoReclamacion(EstadoReclamacion estadoReclamacion) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("INSERT INTO public.estadoreclamacion( tiporeclamacion, motivo)VALUES ( ?, ?);");
            ps.setString(1, estadoReclamacion.getTipoReclamacion());
            ps.setString(2, estadoReclamacion.getMotivo());
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

    public ArrayList<EstadoReclamacion> consultarEstadosReclamacion() {
        ArrayList<EstadoReclamacion> lista = new ArrayList<EstadoReclamacion>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM estadoreclamacion");
            rs = ps.executeQuery();
            while (rs.next()) {
                EstadoReclamacion e = new EstadoReclamacion(rs.getInt("idestadoreclamacion"), rs.getString("tiporeclamacion"), rs.getString("motivo"));
                lista.add(e);
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

    public boolean eliminarEstadoReclamacion(int id) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("DELETE FROM estadoreclamacion WHERE idestadoreclamacion = ?");
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

    public boolean modificarEstadoReclamacion(EstadoReclamacion estadoReclamacion) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("UPDATE estadoreclamacion SET tiporeclamacion = ?, motivo = ? WHERE idestadoreclamacion = ?");
            ps.setString(1, estadoReclamacion.getTipoReclamacion());
            ps.setString(2, estadoReclamacion.getMotivo());
            ps.setInt(3, estadoReclamacion.getIdEstadoReclamacion());
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
