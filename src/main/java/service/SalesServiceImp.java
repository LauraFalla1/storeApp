package service;

import data.SalesDAO;
import java.util.List;
import javax.inject.Inject;
import models.Sales;


public class SalesServiceImp implements SalesService{
    @Inject
    private SalesDAO sDAO ;
    
    @Override
    public List<Sales> findAllSales() {
    return  sDAO.findAllSales();
    }

    @Override
    public List<Sales> findAllSales(String filter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sales findSalesbyId(Sales sales) {
    return sDAO.findSalesbyId(sales);
    }

    @Override
    public void insertSales(Sales sales) {
    sDAO.insertSales(sales);
    }

    @Override
    public void deleteSales(Sales sales) {
    sDAO.deleteSales(sales);
    }

    @Override
    public void updateSales(Sales sales) {
    sDAO.updateSales(sales);
    }

    @Override
    public List<Sales> findSalesbyCustomerID(String filter) {
      return sDAO.findSalesbyCustomerID(filter);
    }

    
    
}
