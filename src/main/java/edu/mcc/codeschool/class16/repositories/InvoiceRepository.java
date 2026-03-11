package edu.mcc.codeschool.class16.repositories;

import edu.mcc.codeschool.class16.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    List<Invoice> findByCustomerId(Integer customerId);

    List<Invoice> findByAddressContains(String address);

    @Query("SELECT DISTINCT i.city from invoices i")
    List<String> findDistinctCities();
}
