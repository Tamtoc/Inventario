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
public class Computadoras {
    private String n_inventario;
    private String departamento;

    public String getN_inventario() {
        return n_inventario;
    }

    public void setN_inventario(String n_inventario) {
        this.n_inventario = n_inventario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    @Override
    public String toString() {
        return this.n_inventario;
    }
    
    public Vector<Computadoras> mostrarComputadoras(String idDepartamento) {
         PreparedStatement ps = null;
        ResultSet rs = null;
        connectionMySQL conn = new connectionMySQL();
        Connection con = conn.connection();
        
        Vector<Computadoras> datos = new Vector<Computadoras>();
        Computadoras dat = null;
        
        try{
            String sql = "SELECT * FROM computadora WHERE departamento='"+idDepartamento+"' ";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            dat = new Computadoras();
            dat.setN_inventario("Selecciona # de inventario");
            datos.add(dat);
            
            while(rs.next()) {
                dat = new Computadoras();
                dat.setN_inventario(rs.getString("n_inventario"));
                datos.add(dat);
            }
            rs.close();
            
        } catch(SQLException e) {
            System.out.println(e.toString());
        }
        return datos;
    }
    
}
