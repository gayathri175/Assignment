package com.example.transaction_logger;



import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    @GetMapping("/transaction")
    public String processTransaction(@RequestParam("amount") String amount) {
        return "<h2 style='color:green;'>Transaction of Rs." + amount + " processed successfully.</h2>";
    }
}
