/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author georg
 */
public class ComputadoraDataSource implements JRDataSource{

    private int index;
    
    private String idReporte;
    private String descripcion;
    private String fecha;
    private int computadora;
    private String tecnico;
    private int mantenimiento;
    private String departamento;
    private String marca;
    private String modelo;
    
    public ComputadoraDataSource(String idReporte, String descripcion, String fecha, int computadora, String tecnico, int mantenimiento, String departamento, String marca, String modelo) {
        this.idReporte = idReporte;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.computadora = computadora;
        this.tecnico = tecnico;
        this.mantenimiento = mantenimiento;
        this.departamento = departamento;
        this.marca = marca;
        this.modelo = modelo;
        this.index = -1;
    }
    @Override
    public boolean next() throws JRException {
        index++;
        return (index < 1);
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object value = null;
        
        String fieldName = jrf.getName();
        
        switch(fieldName) {
            
            case "n_computadora":
                value = this.computadora;
                break;
            
            case "depto_computadora":
                value = this.departamento;
                break;
            
            case "marca":
                value = this.marca;
                break;
            case "modelo":
                value = this.modelo;
                break;
            case "descripcion":
                value = this.descripcion;
                break;
            case "id_reporte":
                value = this.idReporte;
                break;
            case "id_tecnico":
                value = this.tecnico;
                break;
            case "id_mantenimiento":
                value = this.mantenimiento;
                break;
               
           
        }
        return value;
    }
    
}
