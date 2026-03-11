package edu.mcc.codeschool.class16.services;

import edu.mcc.codeschool.class16.models.Invoice;
import edu.mcc.codeschool.class16.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<Invoice> listAllInvoices(){
        return invoiceRepository.findAll();
    }

    public Optional<Invoice> findInvoiceById(Integer id){
        return invoiceRepository.findById(id);
    }

    public List<Invoice> findByCustomerId(Integer customerId){
        return invoiceRepository.findByCustomerId(customerId);
    }

    public List<String> findDistinctCities(){
        return invoiceRepository.findDistinctCities();
    }
}
