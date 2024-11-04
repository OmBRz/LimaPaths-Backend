package pe.upc.limapathsbackend.payment.application.services;

import org.springframework.stereotype.Service;
import pe.upc.limapathsbackend.payment.domain.model.aggregates.Payment;
import pe.upc.limapathsbackend.payment.domain.model.commands.CreatePaymentCommand;
import pe.upc.limapathsbackend.payment.domain.model.valueobjects.*;
import pe.upc.limapathsbackend.payment.domain.services.PaymentCommandService;
import pe.upc.limapathsbackend.payment.infraestructure.persistence.jpa.repositories.PaymentRepository;

import java.util.Optional;
@Service
public class PaymentCommandServiceImpl implements PaymentCommandService {

    private final PaymentRepository paymentRepository;

    public PaymentCommandServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Optional<Payment> handle(CreatePaymentCommand command) {

        String busName = command.busName();

        paymentRepository.findByBus_BusName(busName).ifPresent(payment -> {
            throw new IllegalArgumentException("Bus " + busName + " already exists");
        });


        var payment = Payment.builder()
                .bus(new Bus(busName))
                .destination(new Destination(command.destinationStop(), command.destinationLatitude(), command.destinationLongitude()))
                .origin(new Origin(command.originStop(), command.originLatitude(), command.originLongitude()))
                .ticket(new TicketAmount(command.exchange(), command.price()))
                .timeTrip(new TimeTrip(command.hour(), command.minutes(), command.dayTime()))
                .build();

        paymentRepository.save(payment);

        return Optional.of(payment);
    }
}
