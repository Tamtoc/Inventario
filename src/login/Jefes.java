/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import connectionSQL.connectionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author georg
 */
public class Jefes {
    private String id;
    private String nombre;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return this.nombre;
    }
    
    public Vector<Jefes> mostrarJefes() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        connectionMySQL conn = new connectionMySQL();
        Connection con = conn.connection();
        
        Vector<Jefes> datos = new Vector<Jefes>();
        Jefes dat = null;
        try{
            String sql = "SELECT * FROM usuario WHERE tipo='jefe' AND NOT EXISTS (SELECT NULL FROM jefe WHERE jefe.identificador=usuario.id) ";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            dat = new Jefes();
            dat.setId("0");
            dat.setNombre("Selecciona Jefe");
            datos.add(dat);
            
            while(rs.next()) {
                dat = new Jefes();
                dat.setId(rs.getString("id"));
                dat.setNombre(rs.getString("nombre"));
                datos.add(dat);
            }
            rs.close();
            
        } catch(SQLException e) {
            System.out.println(e.toString());
        }
        return datos;
    }
}
