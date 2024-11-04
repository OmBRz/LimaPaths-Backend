package pe.upc.limapathsbackend.profiles.interfaces.rest.transform;

import pe.upc.limapathsbackend.profiles.domain.model.commands.CreateProfileCommand;
import pe.upc.limapathsbackend.profiles.interfaces.rest.resources.CreateProfileResource;

public class CreateProfileCommandFromResourceAssembler {
    public static CreateProfileCommand toCommandFromResource(CreateProfileResource resource) {
        return new CreateProfileCommand(
                resource.firstName(),
                resource.lastName(),
                resource.email(),
                resource.userType(),
                resource.password(),
                resource.transportCompany()
        );
    }
}
