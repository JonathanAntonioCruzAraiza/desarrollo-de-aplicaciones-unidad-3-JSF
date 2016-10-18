/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Proveedor;

/**
 *
 * @author jony
 */
public class ProveedorDAO extends DAO<Proveedor>{

    public ProveedorDAO() {
        super(new Proveedor());
    }
    
    public Proveedor getOneById (Proveedor proveedor) throws HibernateException{
        return  super.getOneById(proveedor.getIdProveedor());
    }
    
    
}
