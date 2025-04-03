package org.example.model;

import java.util.LinkedList;
import java.util.Queue;

public class QueueLine {
    private final String name;
    private final int lineNumber;
    Queue<Customer> queue;

    public QueueLine(String name, int lineNumber){
        this.name = name;
        this.lineNumber = lineNumber;
        this.queue = new LinkedList<>();
    }

    public void addCustomer(Customer cust){
        queue.add(cust);
    }

    public Customer popCustomer(){
        return queue.poll();
    }

    public Customer peekCustomer(){
        return queue.peek();
    }

    public int size(){
        return queue.size();
    }

    public String getLineName(){
        return name;
    }
    public int getLineNumber(){
        return lineNumber;
    }

    public void printAllCustomers(){
        if(queue.isEmpty()){
            System.out.println("No customer found");
        }
        else {
            System.out.print(name + ": ");
            for(Customer cust : queue){
                System.out.print(cust.getName() + " _ ");
            }
            System.out.println("");
        }
    }

}
