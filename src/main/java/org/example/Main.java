package org.example;


import org.example.model.Customer;
import org.example.model.QueueLine;
import org.example.service.QueueManager;
import org.example.service.ReservationService;
import org.example.ui.QueueApp;

public class Main {
    public static void main(String[] args) {
        QueueManager manager = new QueueManager();
        ReservationService res = new ReservationService();

        Customer ibrahim = new Customer("ibrahim",120);
        Customer ziad = new Customer("ziad",100);
        Customer saif = new Customer("saif",200);
        Customer mohamed = new Customer("mohamed",300);
        Customer jana = new Customer("jana",150);

        manager.assignCustomer(ibrahim);
        manager.assignCustomer(ziad);
        manager.assignCustomer(saif);
        manager.assignCustomer(mohamed);
        manager.assignCustomer(jana);

        res.insertReservation(ibrahim);
        res.insertReservation(ziad);
        res.insertReservation(saif);
        res.insertReservation(mohamed);
        res.insertReservation(jana);

        manager.printAllQueues();


    }
}