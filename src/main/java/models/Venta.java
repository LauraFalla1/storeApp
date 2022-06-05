package models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "venta")
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT p FROM Venta p"),
/*   @NamedQuery(name = "Venta.findById", query = "SELECT p FROM venta p WHERE p.IdentificacionVenta = :ventId")*/})
public class Venta implements Serializable {

    
    @Id
    @NotNull
    @Column(name = "IdentificacionVenta")
    private Integer identificacionVenta;
    @JoinColumn(name = "productId", referencedColumnName = "productId")
    @ManyToOne(optional = false)
    private Product productID;
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    @ManyToOne(optional = false)
    private Customer customerId;
    @NotNull
    @Column(name = "cantidad")
    private Integer cantidad;
    @NotNull
    @Column(name = "precioUnid")
    private Integer precioUnid;

    public Venta() {
    }

    public Venta(Integer identificacionVenta) {
        this.identificacionVenta = identificacionVenta;
    }

    public Venta(Integer identificacionVenta,  Integer cantidad, Integer precioUnid) {
        this.identificacionVenta = identificacionVenta;
        this.cantidad = cantidad;
        this.precioUnid = precioUnid;
    }

    public Integer getIdentificacionVenta() {
        return identificacionVenta;
    }

    public void setIdentificacionVenta(Integer identificacionVenta) {
        this.identificacionVenta = identificacionVenta;
    }

    public Product getProductID() {
        return productID;
    }

    public void setProductId(Product productID) {
        this.productID = productID;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getPrecioUnid() {
        return precioUnid;
    }

    public void setPrecioUnid(Integer precioUnid) {
        this.precioUnid = precioUnid;
    }
     
    
}