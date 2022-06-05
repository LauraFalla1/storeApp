package service;

import java.util.List;
import models.Sales;


public interface SalesService {
    public List<Sales> findAllSales();
    public List<Sales> findAllSales(String filter);
    public Sales findSalesbyId(Sales sales);
    public List<Sales> findSalesbyCustomerID(String filter);
    public void insertSales(Sales sales);
    public void deleteSales(Sales sales);
    public void updateSales(Sales sales);
}
