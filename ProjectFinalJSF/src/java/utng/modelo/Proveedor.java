/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jony
 */
@Entity
@Table(name = "proveedor")
public class Proveedor implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Long idProveedor;
    @Column(length = 70)
    private String nombre;
    @Column(name = "rfc", length = 15)
    private String rfc;
    @Column(name = "producto_suministra",length = 50)
    private  String productosSuministra;

    public Proveedor() {
        this.idProveedor = 0L;
    }
    
    
    

    public Long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

 

    public String getProductosSuministra() {
        return productosSuministra;
    }

    public void setProductosSuministra(String productosSuministra) {
        this.productosSuministra = productosSuministra;
    }


    
     
    
    
}
