package com.projet.ensetbillingservice.mappers;

import com.projet.ensetbillingservice.dto.InvoiceRequestDTO;
import com.projet.ensetbillingservice.dto.InvoiceResponseDTO;
import com.projet.ensetbillingservice.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice fromInvoiceRequestDTO(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO fromInvoice(Invoice invoice);
}
