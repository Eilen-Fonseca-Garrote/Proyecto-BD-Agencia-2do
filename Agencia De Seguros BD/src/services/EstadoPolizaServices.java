package services;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import utils.Conexion;
import model.EstadoPoliza;

// ... otras importaciones si las necesitas

public class EstadoPolizaServices {
    Conexion cx;

    public EstadoPolizaServices() {
        cx = new Conexion();
    }

    public boolean insertarEstadoPoliza(EstadoPoliza estadoPoliza) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("INSERT INTO public.estadopoliza( tipopoliza, motivo)VALUES ( ?, ?);");
            ps.setString(1, estadoPoliza.getTipoPoliza());
            ps.setString(2, estadoPoliza.getMotivo());
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

    public ArrayList<EstadoPoliza> consultarEstadosPoliza() {
        ArrayList<EstadoPoliza> lista = new ArrayList<EstadoPoliza>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM estadopoliza");
            rs = ps.executeQuery();
            while (rs.next()) {
                EstadoPoliza e = new EstadoPoliza(rs.getInt("idestadopoliza"), rs.getString("tipopoliza"), rs.getString("motivo"));
                lista.add(e);
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

    public boolean eliminarEstadoPoliza(int id) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("DELETE FROM estadopoliza WHERE idestadopoliza = ?");
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

    public boolean modificarEstadoPoliza(EstadoPoliza estadoPoliza) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("UPDATE estadopoliza SET tipopoliza = ?, motivo = ? WHERE idestadopoliza = ?");
            ps.setString(1, estadoPoliza.getTipoPoliza());
            ps.setString(2, estadoPoliza.getMotivo());
            ps.setInt(3, estadoPoliza.getIdEstadoPoliza());
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

