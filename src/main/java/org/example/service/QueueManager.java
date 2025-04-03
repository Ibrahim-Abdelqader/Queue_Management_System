package org.example.service;

import org.example.model.Customer;
import org.example.model.QueueLine;

import java.util.ArrayList;
import java.util.List;

public class QueueManager {
    private List<QueueLine> lines;

    public QueueManager(){
        lines = new ArrayList<QueueLine>();
        lines.add(new QueueLine("line1",1));
        lines.add(new QueueLine("line2",2));
        lines.add(new QueueLine("line3",3));
    }

    public void assignCustomer(Customer cust){
        QueueLine shortestLine = findShortestQueue();
        if(shortestLine != null){
            shortestLine.addCustomer(cust);
            cust.setLine_number(shortestLine.getLineNumber());
        }
    }

    public Customer serveCustomer(){
        QueueLine finishedLine = findFinishedCustomer();
        if(finishedLine != null){
            return finishedLine.popCustomer();
        }
        return null;
    }

    public QueueLine findShortestQueue(){
        int s1 = lines.get(0).size();
        int s2 = lines.get(1).size();
        int s3 = lines.get(2).size();

        if(s1 <= s2 && s1 <= s3)
            return lines.get(0);
        else if(s2 <= s1 && s2 <= s3)
            return lines.get(1);
        else
            return lines.get(2);
    }

    public QueueLine findFinishedCustomer(){
        for(QueueLine line : lines){
            if(line.peekCustomer().getPeriod()==0)
                return line;
        }
        return null;
    }

    public void printAllQueues(){
        for(QueueLine line : lines){
            line.printAllCustomers();
        }
    }

}
