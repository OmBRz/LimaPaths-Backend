package pe.upc.limapathsbackend.payment.interfaces.rest.transform;

import pe.upc.limapathsbackend.payment.domain.model.commands.CreatePaymentCommand;
import pe.upc.limapathsbackend.payment.interfaces.rest.resources.CreatePaymentResource;

public class CreatePaymentCommandFromResourceAssembler {
    public static CreatePaymentCommand toCommandFromResource(CreatePaymentResource resource){
        return new CreatePaymentCommand(
                resource.busName(),
                resource.originStop(),
                resource.originLatitude(),
                resource.originLongitude(),
                resource.destinationStop(),
                resource.destinationLatitude(),
                resource.destinationLongitude(),
                resource.exchange(),
                resource.price(),
                resource.hour(),
                resource.minutes(),
                resource.dayTime()
        );
    }
}
