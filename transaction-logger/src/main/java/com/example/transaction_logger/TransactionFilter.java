package com.example.transaction_logger;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TransactionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        // Get amount
        String amount = request.getParameter("amount");

        // Get IP
        String ip = request.getRemoteAddr();

        // Get timestamp
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        // Log the message
        System.out.println("[" + timestamp + "] Transaction Request from IP: " + ip + " | Amount: Rs." + amount);

        // Continue with request
        chain.doFilter(request, response);
    }
}
