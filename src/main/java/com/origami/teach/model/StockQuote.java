package com.origami.teach.model;

//import javax.persistence.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * A container class that contains stock data.
 */
//@Entity
//@Table(name="quotes")
public class StockQuote extends StockData {
    private int id;
    private BigDecimal price;
    private Calendar date;
    private String symbol;


    /**
     * @return return the id of the stock quote.
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return The date of the share price
     */
    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    /**
     * @return The stock symbol.
     */
//    @Basic
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }


    @Override
    public String toString() {
        return String.format("StockQuote{Symbol=%s, Price=%s, Date=%s}", price, simpleDateFormat.format(date.getTime()), symbol);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockQuote that = (StockQuote) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}