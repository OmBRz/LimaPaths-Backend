package pe.upc.limapathsbackend.payment.application.services;

import org.springframework.stereotype.Service;
import pe.upc.limapathsbackend.payment.domain.model.aggregates.Payment;
import pe.upc.limapathsbackend.payment.domain.model.queries.GetPaymentByBusNameQuery;
import pe.upc.limapathsbackend.payment.domain.model.queries.GetPaymentByIdQuery;
import pe.upc.limapathsbackend.payment.domain.model.queries.GetPaymentByTicketAmountQuery;
import pe.upc.limapathsbackend.payment.domain.services.PaymentQueryService;
import pe.upc.limapathsbackend.payment.infraestructure.persistence.jpa.repositories.PaymentRepository;

import java.util.Optional;

@Service
public class PaymentQueryServiceImpl implements PaymentQueryService {

    private final PaymentRepository paymentRepository;

    public PaymentQueryServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }


    @Override
    public Optional<Payment> handle(GetPaymentByIdQuery query) {
        return paymentRepository.findById(query.id());
    }

    @Override
    public Optional<Payment> handle(GetPaymentByTicketAmountQuery query) {
        return paymentRepository.findByTicket(query.ticket());
    }

    @Override
    public Optional<Payment> handle(GetPaymentByBusNameQuery query) {
        String busName = query.busName().getFullBusName(); // O usa query.busName().busName() si es más directo
        return paymentRepository.findByBus_BusName(busName);
    }
}
