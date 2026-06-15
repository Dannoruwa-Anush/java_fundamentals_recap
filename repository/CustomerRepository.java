package repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import model.Customer;

public class CustomerRepository implements IRepository<Customer>{

    private Map<Integer, Customer> customers; 

    // all arg constrctor
    public CustomerRepository(){
        customers = new HashMap<>(); // polymorphism via an interface
    }

    @Override
    public void add(Customer customer) {
        customers.put(customer.getCustomerId(), customer);
    }

    @Override
    public void remove(Customer customer) {
        customers.remove(customer.getCustomerId());
    }

    @Override
    public Collection<Customer> getAll() {
        return customers.values();
    }

    @Override
    public Customer getById(int id) {
        return customers.get(id);
    }
}
