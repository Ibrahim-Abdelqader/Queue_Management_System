package org.example.service;

import org.example.dao.cusDao;
import org.example.dao.cusDaoImp;
import org.example.model.Customer;

public class ReservationService {
    private cusDao cusDao;

    public ReservationService(){
        cusDao=new cusDaoImp();
    }

    public void insertReservation(Customer customer){
        int generatedID = cusDao.create(customer);
        customer.setId(generatedID);
    }

    public void deleteReservation(Customer customer){
        cusDao.delete(customer);
    }

}
