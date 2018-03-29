package com.stock.controller;

import com.stock.model.Quote;
import com.stock.model.Quotes;
import com.stock.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/db")
public class DBServiceController {

    @Autowired
    private QuoteRepository quoteRepository;

    public DBServiceController(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @GetMapping("/{userName}")
    public List<String> getQuotes(@PathVariable("userName") final String userName){
        return getQuotesByUserName(userName);
    }

    @PostMapping("/add")
    public List<String> add(@RequestBody final Quotes quotes){
            quotes.getQuotes().stream().map(quote->new Quote(quotes.getUserName(),quote))
                    .forEach(quote -> quoteRepository.save(quote));
            return getQuotesByUserName(quotes.getUserName());
    }

    @DeleteMapping("/delete/{username}")
    public List<String> delete(@PathVariable("userName") final String userName){
        List<Quote> quotes = quoteRepository.findByUserName(userName);
        quotes.stream().forEach(quote -> quoteRepository.delete(quote));
        return getQuotesByUserName(userName);
    }

    private List<String> getQuotesByUserName(String userName) {
        return quoteRepository.findByUserName(userName).stream().map(Quote :: getQuote)
                .collect(Collectors.toList());
    }
}
