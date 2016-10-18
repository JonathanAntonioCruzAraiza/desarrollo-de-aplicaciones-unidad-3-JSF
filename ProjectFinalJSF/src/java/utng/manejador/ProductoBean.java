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
import utng.datos.ProductoDAO;
import utng.datos.ProveedorDAO;
import utng.modelo.Producto;
import utng.modelo.Proveedor;

/**
 *
 * @author jony
 */
@ManagedBean (name = "productoBean")
@SessionScoped
public class ProductoBean implements Serializable {
    private List<Producto> productos;
    private Producto producto;
    private List<Proveedor> proveedores;
    
    public ProductoBean() {
        producto = new Producto();
        producto.setProveedor(new Proveedor());
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }
    
    
    public String listar() {
        ProductoDAO dao = new ProductoDAO();
        try {
            productos = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Productos";
    }
    
    public String iniciar(){
        producto = new Producto();
        producto.setProveedor(new Proveedor());
        try {
           proveedores = new ProveedorDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Iniciar";
    }

    public String eliminar() {
        ProductoDAO dao = new ProductoDAO();
        try {
            dao.delete(producto);
            productos = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";
    }

    public String guardar() {
        ProductoDAO dao = new ProductoDAO();
        try {
            if (producto.getIdProducto()!=0) {
                dao.update(producto);
            }else{
                dao.insert(producto);
            }
            productos = dao.getAll();
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  "Guardar";
    }
    
    public String cancelar(){
        return "Cancelar";
    }
    public String editar(Producto producto){
        this.producto= producto;
        try {
            proveedores = new ProveedorDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Editar";
    }
}
