package pe.upc.limapathsbackend.trip.interfaces.rest.transform;

import pe.upc.limapathsbackend.trip.domain.model.commands.CreateTripCommand;
import pe.upc.limapathsbackend.trip.interfaces.rest.resources.CreateTripResource;

public class CreateTripCommandFromResourceAssembler {
    public static CreateTripCommand toCommandFromResource(CreateTripResource resource) {
        return new CreateTripCommand(
                resource.origin(),
                resource.destination(),
                resource.time(),
                resource.fare()
        );
    }
}
