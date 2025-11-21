package services;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import utils.Conexion;
import model.CompaniaReaseg;

// ... otras importaciones si las necesitas

public class CompaniaReasegServices {
    Conexion cx;

    public CompaniaReasegServices() {
        cx = new Conexion();
    }

    public boolean insertarCompaniaReaseg(CompaniaReaseg companiaReaseg) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("INSERT INTO public.companiareaseg( nombrecompania, paisorigen, tiporeaseg, porcentajeparticipacion, idagencia)VALUES ( ?, ?, ?, ?, ?);");
            ps.setString(1, companiaReaseg.getNombreCompania());
            ps.setString(2, companiaReaseg.getPaisOrigen());
            ps.setString(3, companiaReaseg.getTipoReaseg());
            ps.setDouble(4, companiaReaseg.getPorcentajeParticipacion());
            ps.setInt(5, companiaReaseg.getIdAgencia());
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

    public ArrayList<CompaniaReaseg> consultarCompaniasReaseg() {
        ArrayList<CompaniaReaseg> lista = new ArrayList<CompaniaReaseg>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM companiareaseg");
            rs = ps.executeQuery();
            while (rs.next()) {
                CompaniaReaseg c = new CompaniaReaseg(rs.getInt("idcompania"), rs.getString("nombrecompania"), rs.getString("paisorigen"), rs.getString("tiporeaseg"), rs.getDouble("porcentajeparticipacion"), rs.getInt("idagencia"));
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

    public boolean eliminarCompaniaReaseg(int id) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("DELETE FROM companiareaseg WHERE idcompania = ?");
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

    public boolean modificarCompaniaReaseg(CompaniaReaseg companiaReaseg) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("UPDATE companiareaseg SET nombrecompania = ?, paisorigen = ?, tiporeaseg = ?, porcentajeparticipacion = ?, idagencia = ? WHERE idcompania = ?");
            ps.setString(1, companiaReaseg.getNombreCompania());
            ps.setString(2, companiaReaseg.getPaisOrigen());
            ps.setString(3, companiaReaseg.getTipoReaseg());
            ps.setDouble(4, companiaReaseg.getPorcentajeParticipacion());
            ps.setInt(5, companiaReaseg.getIdAgencia());
            ps.setInt(6, companiaReaseg.getIdCompania());
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

