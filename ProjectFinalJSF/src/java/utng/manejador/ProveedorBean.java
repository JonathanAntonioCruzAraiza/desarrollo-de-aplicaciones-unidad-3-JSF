/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.manejador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.datos.ProveedorDAO;
import utng.modelo.Proveedor;

/**
 *
 * @author Jonathan Antonio Cruz Araiza jonycruz1996@gmail.com
 */
@ManagedBean(name = "proveedorBean")
@SessionScoped
public class ProveedorBean implements Serializable {

 private List<Proveedor> proveedores;
 private Proveedor proveedor;
 public ProveedorBean() {}

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    
    
    public String listar(){
        ProveedorDAO dao = new ProveedorDAO();
        try {
            proveedores=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Proveedores";
    }
    
    public String eliminar(){
         ProveedorDAO dao = new ProveedorDAO();
        try {
            dao.delete(proveedor);
            proveedores=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";
    }
    
    public String iniciar(){
        proveedor= new Proveedor();
        return "Iniciar";
    }
    
    public String guardar(){
        ProveedorDAO dao = new ProveedorDAO();
        try {
            if(proveedor.getIdProveedor()!= 0){
                dao.update(proveedor);
            }else {
                dao.insert(proveedor);
            }
            proveedores=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }
    
    public String cancelar(){
    return "Cancelar";
    }
    
    public String editar(Proveedor proveedor){
        this.proveedor=proveedor;
        return "Editar";
    }
    
}
