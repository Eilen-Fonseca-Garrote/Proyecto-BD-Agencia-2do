package services;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import utils.Conexion;
import model.Poliza;

// ... otras importaciones si las necesitas

public class PolizaServices {
    Conexion cx;

    public PolizaServices() {
        cx = new Conexion();
    }

    public boolean insertarPoliza(Poliza poliza) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("INSERT INTO public.poliza( fechainicio, fechafin, primamensual, montototal, idagencia, id, idestadopoliza, idcobertura)VALUES ( ?, ?, ?, ?, ?, ?, ?, ?);");
            ps.setDate(1, poliza.getFechaInicio());
            ps.setDate(2, poliza.getFechaFin());
            ps.setDouble(3, poliza.getPrimaMensual());
            ps.setDouble(4, poliza.getMontoTotal());
            ps.setInt(5, poliza.getIdAgencia());
            ps.setString(6, poliza.getId());
            ps.setInt(7, poliza.getIdEstadoPoliza());
            ps.setInt(8, poliza.getIdCobertura());
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

    public ArrayList<Poliza> consultarPolizas() {
        ArrayList<Poliza> lista = new ArrayList<Poliza>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM poliza");
            rs = ps.executeQuery();
            while (rs.next()) {
                Poliza p = new Poliza(rs.getInt("numpoliza"), rs.getDate("fechainicio"), rs.getDate("fechafin"), rs.getDouble("primamensual"), rs.getDouble("montototal"), rs.getInt("idagencia"), rs.getString("id"), rs.getInt("idestadopoliza"), rs.getInt("idcobertura"));
                lista.add(p);
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

    public boolean eliminarPoliza(int id) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("DELETE FROM poliza WHERE numpoliza = ?");
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

    public boolean modificarPoliza(Poliza poliza) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("UPDATE poliza SET fechainicio = ?, fechafin = ?, primamensual = ?, montototal = ?, idagencia = ?, id = ?, idestadopoliza = ?, idcobertura = ? WHERE numpoliza = ?");
            ps.setDate(1, poliza.getFechaInicio());
            ps.setDate(2, poliza.getFechaFin());
            ps.setDouble(3, poliza.getPrimaMensual());
            ps.setDouble(4, poliza.getMontoTotal());
            ps.setInt(5, poliza.getIdAgencia());
            ps.setString(6, poliza.getId());
            ps.setInt(7, poliza.getIdEstadoPoliza());
            ps.setInt(8, poliza.getIdCobertura());
            ps.setInt(9, poliza.getNumPoliza());
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

