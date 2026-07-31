package com.stockexchange.controller;

import com.stockexchange.model.Trade;
import com.stockexchange.service.TradeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trades")
@CrossOrigin(origins = "*")
public class TradeController {

    private final TradeService tradeService;

    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @GetMapping
    public ResponseEntity<List<Trade>> getAllTrades() {

        return ResponseEntity.ok(
                tradeService.getTrades()
        );
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> getTradeCount() {

        return ResponseEntity.ok(
                tradeService.getTrades().size()
        );
    }

    @DeleteMapping
    public ResponseEntity<String> clearTrades() {

        tradeService.getTrades().clear();

        return ResponseEntity.ok("All trades cleared successfully.");
    }
}