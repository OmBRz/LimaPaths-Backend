package pe.upc.limapathsbackend.payment.domain.services;

import org.springframework.stereotype.Service;
import pe.upc.limapathsbackend.payment.domain.model.aggregates.Payment;
import pe.upc.limapathsbackend.payment.domain.model.queries.GetPaymentByBusNameQuery;
import pe.upc.limapathsbackend.payment.domain.model.queries.GetPaymentByIdQuery;
import pe.upc.limapathsbackend.payment.domain.model.queries.GetPaymentByTicketAmountQuery;

import java.util.Optional;

@Service
public interface PaymentQueryService {
    Optional<Payment> handle(GetPaymentByIdQuery query);
    Optional<Payment> handle(GetPaymentByTicketAmountQuery query);
    Optional<Payment> handle(GetPaymentByBusNameQuery query);
}
