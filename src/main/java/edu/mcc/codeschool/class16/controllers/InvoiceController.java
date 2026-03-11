package edu.mcc.codeschool.class16.controllers;

import edu.mcc.codeschool.class16.models.Invoice;
import edu.mcc.codeschool.class16.services.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/invoices")
public class InvoiceController {
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public ResponseEntity<List<Invoice>> listInvoices(){
        return ResponseEntity.ok(invoiceService.listAllInvoices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Integer id){
        Optional<Invoice> resp = invoiceService.findInvoiceById(id);
        return resp.isPresent() ? ResponseEntity.ok(resp.get()) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/byCustomer/{id}")
    public ResponseEntity<List<Invoice>> findInvoicesByCustomerId(@PathVariable Integer id){
        return ResponseEntity.ok(invoiceService.findByCustomerId(id));
    }

    @GetMapping("/distinctCities")
    public ResponseEntity<List<String>> findDistinctCities(){
        return ResponseEntity.ok(invoiceService.findDistinctCities());
    }
}
