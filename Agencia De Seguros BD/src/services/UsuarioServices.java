package services;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import utils.Conexion;
import model.Usuario;

// ... otras importaciones si las necesitas

public class UsuarioServices {
    Conexion cx;

    public UsuarioServices() {
        cx = new Conexion();
    }

    public boolean insertarUsuario(Usuario usuario) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("INSERT INTO public.usuario( nombreusuario, contrasena, idrol)VALUES ( ?, ?, ?);");
            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getContrasena());
            ps.setInt(3, usuario.getIdRol());
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

    public ArrayList<Usuario> consultarUsuarios() {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM usuario");
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario(rs.getInt("idusuario"), rs.getString("nombreusuario"), rs.getString("contrasena"), rs.getInt("idrol"));
                lista.add(u);
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

    public boolean eliminarUsuario(int id) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("DELETE FROM usuario WHERE idusuario = ?");
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

    public boolean modificarUsuario(Usuario usuario) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("UPDATE usuario SET nombreusuario = ?, contrasena = ?, idrol = ? WHERE idusuario = ?");
            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getContrasena());
            ps.setInt(3, usuario.getIdRol());
            ps.setInt(4, usuario.getIdUsuario());
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

