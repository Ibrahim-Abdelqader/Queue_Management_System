package org.example.model;

public class Customer {
    private int id;
    private String name;
    private int period;
    private int lineNumber;

    public Customer(String name, int period){
        this.id=-1;
        this.name= name;
        this.period=period;
        this.lineNumber=0;
    }

    public void setId(int id){
        this.id = id;
        setName();
    }

    public int getId(){
        return this.id;
    }

    public void setName(){
        name= name + "-" + this.id;
    }

    public String getName(){
        return this.name;
    }

    public void setPeriod(int period){
        this.period=period;
    }

    public int getPeriod(){
        return this.period;
    }

    public void setLine_number(int line_number){
        this.lineNumber = line_number;
    }

    public int getLine_number(){
        return this.lineNumber;
    }

}
