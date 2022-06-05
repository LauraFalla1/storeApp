
package models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "carro")
@NamedQueries({
     @NamedQuery(name = "carro.findAll", query ="SELECT c FROM Carro c" )
})
public class Carro implements Serializable {
    
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "productName")
    private String productName;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "precio")
    private String precio;
    @Column(name = "SaleID")
    private int SalesID;

    public Carro(){
        
    }
    
    public Carro(int id, String productName, int cantidad, String precio, int SalesID){
        this.id = id;
        this.productName = productName;
        this.cantidad = cantidad;
        this.precio = precio;
        this.SalesID = SalesID;
    }

    public int getSalesID() {
        return SalesID;
    }

    public void setSalesID(int SalesID) {
        this.SalesID = SalesID;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the precio
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
}
