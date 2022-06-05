
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "detalleventa")
@NamedQueries({
    @NamedQuery(name = "ListVenta.findAll", query = "SELECT L FROM ListVenta L")})
public class ListVenta implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "ventaId")
    private Integer ventaId;
    @JoinColumn(name = "IdentificacionVenta", referencedColumnName = "IdentificacionVenta")
    @ManyToOne(optional = false)
    private Venta identificacionVenta;

    public ListVenta() {
    }

    public ListVenta(Integer ventaId, Venta identificacionVenta) {
        this.identificacionVenta = identificacionVenta;
        this.ventaId = ventaId;
    }

    public Integer getVentaId() {
        return ventaId;
    }

    public void setVentaId(Integer ventaId) {
        this.ventaId = ventaId;
    }

    public Venta getIdentificacionVenta() {
        return identificacionVenta;
    }

    public void setIdentificacionVenta(Venta identificacionVenta) {
        this.identificacionVenta = identificacionVenta;
    }
}