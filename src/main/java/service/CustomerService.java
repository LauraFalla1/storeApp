
package service;

import java.util.List;
import models.Customer;

public interface CustomerService {
    public List<Customer> findAllCustomer();
    public List<Customer> findAllCustomer(String filtro);
    public List<Customer> findIdCustomer(String filter);
    public Customer findCustomerbyId(Customer customer);
    public Customer findCustomerbyEmail(Customer customer);
    public List<Customer> findByCustomerName(String customer);
    public void insertCustomer(Customer customer);
    public void deleteCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    
}
