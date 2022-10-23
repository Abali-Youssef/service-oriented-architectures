package com.projet.ensetbillingservice.service;

import com.projet.ensetbillingservice.dto.InvoiceRequestDTO;
import com.projet.ensetbillingservice.dto.InvoiceResponseDTO;
import com.projet.ensetbillingservice.entities.Customer;
import com.projet.ensetbillingservice.entities.Invoice;
import com.projet.ensetbillingservice.mappers.InvoiceMapper;
import com.projet.ensetbillingservice.openfeign.CustomerRestClient;
import com.projet.ensetbillingservice.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {
    private InvoiceRepository invoiceRepository ;
    private InvoiceMapper invoiceMapper ;
    private CustomerRestClient customerRestClient ;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper, CustomerRestClient customerRestClient) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.customerRestClient = customerRestClient;
    }

    @Override
    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) {
        Invoice invoice = invoiceMapper.fromInvoiceRequestDTO(invoiceRequestDTO);
        invoice.setId(UUID.randomUUID().toString());
        invoice.setDate(new Date());
        /*
        verifier si le client existe
         */
        Invoice savedInvoice = invoiceRepository.save(invoice);
        return invoiceMapper.fromInvoice(invoice);
    }

    @Override
    public InvoiceResponseDTO getInvoice(String invoiceId) {
       Invoice invoice= invoiceRepository.findById(invoiceId).get();
       Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
       invoice.setCustomer(customer);
        return invoiceMapper.fromInvoice(invoice);
    }

    @Override
    public List<InvoiceResponseDTO> invoicesByCustomerId(String customerId) {
        List<Invoice> invoices= invoiceRepository.findByCustomerId(customerId);
        return invoices.stream().map(inv -> invoiceMapper.fromInvoice((inv))).collect(Collectors.toList());
    }
}
