package com.origami.teach.controllers;

import com.origami.teach.model.StockQuote;
import com.origami.teach.services.ServiceFactory;
import com.origami.teach.services.StockService;
import com.origami.teach.services.StockServiceException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("api/StockQuotes")
public class StockQuotesController {

    /**
     * Get a historical list of stock quotes for the provide symbol
     *
     * @param symbol the stock symbol to search for
     * @param from   the date of the first stock quote
     * @param until  the date of the last stock quote
     * @return a list of StockQuote instances
     * @throws   StockServiceException if using the service generates an exception.
     * If this happens, trying the service may work, depending on the actual cause of the
     * error.
     */
    @RequestMapping("/GetStockQuotes")
    public List<StockQuote> GetStockQuotes (
            @RequestParam String symbol,
            @RequestParam String from,
            @RequestParam String until) throws StockServiceException, ParseException {

        StockService stockService = ServiceFactory.getStockServiceInstance();
        List<StockQuote> stockQuotes = stockService.getQuotes(symbol, parseDate(from), parseDate(until));
        return stockQuotes;
    }

    private Calendar parseDate(String strDate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(strDate);
        Calendar cal = Calendar.getInstance();
        cal.set(0,0,0,0,0,0);
        cal.setTime(date);
        return cal;
    }
}