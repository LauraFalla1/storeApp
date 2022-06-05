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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sales")
@NamedQueries({
    @NamedQuery(name = "sales.findAll", query = "SELECT s FROM Sales s"),
    @NamedQuery(name = "sales.findByProductId", query = "SELECT s FROM Sales s WHERE s.SaleID = :SaleID"),
    @NamedQuery(name = "sales.findByCustomerId", query = "SELECT s FROM Sales s WHERE s.CustomerId = :CustomerId")})
public class Sales implements Serializable {
    
    @Id
    @Column(name = "SaleID")
    private Integer SaleID;
    
  
    @NotNull
    @Column(name = "CustomerId")
    private String CustomerId;
    
  
   
    
    
            
            
    @NotNull
    @Column(name = "Cant")
    private Integer Cant;
    
    
    @NotNull
    @Column(name = "Price")
    private String Price;

    public Sales(){
        
    }
    
    public Sales(Integer SalesID){
        this.SaleID = SalesID;
    }
    
    public Sales(Integer SalesID, String CustomerID, Integer Cant, String Price){
        this.SaleID = SalesID;
        this.Cant = Cant;
        this.CustomerId = CustomerID;
        this.Price = Price;
    }
    /**
     * @return the SaleID
     */
    public Integer getSaleID() {
        return SaleID;
    }

    /**
     * @param SaleID the SaleID to set
     */
    public void setSaleID(Integer SaleID) {
        this.SaleID = SaleID;
    }

    /**
     * @return the CustomerId
     */
    public String getCustomerId() {
        return CustomerId;
    }

    /**
     * @param CustomerId the CustomerId to set
     */
    public void setCustomerId(String CustomerId) {
        this.CustomerId = CustomerId;
    }

   

    /**
     * @return the Cant
     */
    public Integer getCant() {
        return Cant;
    }

    /**
     * @param Cant the Cant to set
     */
    public void setCant(Integer Cant) {
        this.Cant = Cant;
    }

    /**
     * @return the Price
     */
    public String getPrice() {
        return Price;
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(String Price) {
        this.Price = Price;
    }
    

    
    
    
}
