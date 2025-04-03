package org.example.dao;

import org.example.model.Customer;

public interface cusDao {
    int create(Customer cust);
    void delete(Customer cust);
}
