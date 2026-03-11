package edu.mcc.codeschool.class16.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "invoices")
public class Invoice {

    @Id
    @Column(name = "invoiceid")
    private Integer id;

    @Column(name = "customerid")
    private Integer customerId;

    @Column(name = "invoicedate")
    private Date invoiceDate;

    @Column(name = "billingaddress")
    private String address;

    @Column(name = "billingcity")
    private String city;

    @Column(name = "billingstate")
    private String state;

    @Column(name = "billingcountry")
    private String country;

    @Column(name = "billingpostalcode")
    private String postalCode;

    @Column(name = "total")
    private BigDecimal total;

    public Integer getId() {
        return id;
    }

    public Invoice setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Invoice setCustomerId(Integer customerId) {
        this.customerId = customerId;
        return this;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public Invoice setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Invoice setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Invoice setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public Invoice setState(String state) {
        this.state = state;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Invoice setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Invoice setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Invoice setTotal(BigDecimal total) {
        this.total = total;
        return this;
    }
}
