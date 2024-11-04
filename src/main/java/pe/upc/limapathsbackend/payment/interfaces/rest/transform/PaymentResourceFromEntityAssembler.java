package pe.upc.limapathsbackend.payment.interfaces.rest.transform;

import pe.upc.limapathsbackend.payment.domain.model.aggregates.Payment;
import pe.upc.limapathsbackend.payment.interfaces.rest.resources.PaymentResource;

public class PaymentResourceFromEntityAssembler {
    public static PaymentResource transformResourceFromEntity(Payment entity) {
        return new PaymentResource(entity.getId(), entity.getFullBusName(), entity.getFullOriginCoordinate(), entity.getFullDestinationCoordinate(), entity.getFullTicketAmount(), entity.getFullTimeTrip());
    }

}
