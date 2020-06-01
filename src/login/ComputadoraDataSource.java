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
    
    private String descripcion;
    private String fecha;
    private int[] computadora;
    private String[] departamento;
    private String[] marca;
    private String[] modelo;
    private int size;
    
    public ComputadoraDataSource(String descripcion, String fecha, int computadora[], String departamento[], String marca[], String modelo[]) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.computadora = computadora;
        this.departamento = departamento;
        this.marca = marca;
        this.modelo = modelo;
        this.index = -1;
        this.size = computadora.length;
    }
    @Override
    public boolean next() throws JRException {
        index++;
        return (index < this.size);
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object value = null;
        
        String fieldName = jrf.getName();
        
        switch(fieldName) {
            
            case "n_computadora":
                value = this.computadora[index];
                break;
            case "depto_computadora":
                value = this.departamento[index];
                break;
            
            case "marca":
                value = this.marca[index];
                break;
            case "modelo":
                value = this.modelo[index];
                break;
            case "descripcion":
                value = this.descripcion;
                break;
               
        }
        return value;
    }
    
}
