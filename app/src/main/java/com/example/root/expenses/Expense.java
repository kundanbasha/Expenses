package com.example.root.expenses;

/**
 * Created by root on 17/5/17.
 */
public class Expense {
    private String subject;
    private String description;
    private String moneyPaid;
    private String dates;

    public Expense(){}

    public Expense(String subject, String description, String moneyPaid, String date){
        this.subject = subject;
        this.description = description;
        this.moneyPaid = moneyPaid;
        this.dates=date;
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMoneyPaid() {
        return moneyPaid;
    }

    public void setMoneyPaid(String moneyPaid) {
        this.moneyPaid = moneyPaid;
    }

    public String getDates() {
        return dates;
    }

    public void setDate(String date) {
        this.dates = date;
    }
}
