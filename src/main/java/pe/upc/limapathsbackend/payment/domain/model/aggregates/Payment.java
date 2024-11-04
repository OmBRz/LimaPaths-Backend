package pe.upc.limapathsbackend.payment.domain.model.aggregates;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.*;
import pe.upc.limapathsbackend.payment.domain.model.valueobjects.*;
import pe.upc.limapathsbackend.shared.domain.model.aggregate.AuditableAbstractAggregateRoot;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment extends AuditableAbstractAggregateRoot<Payment> {

    @Embedded
    private Bus bus;
    @Embedded
    private Destination destination;
    @Embedded
    private Origin origin;
    @Embedded
    private TicketAmount ticket;
    @Embedded
    private TimeTrip timeTrip;

    public String getFullDestinationCoordinate(){
        return destination.getFullDestinationCoordinate();
    }

    public String getFullOriginCoordinate(){
        return origin.getFullOriginCoordinate();
    }

    public String getFullTicketAmount(){
        return ticket.getFullTicketAmount();
    }

    public String getFullTimeTrip(){
        return timeTrip.getTimeTrip();
    }

    public String getFullBusName(){
        return bus.getFullBusName();
    }
}
