package pe.upc.limapathsbackend.profiles.interfaces.rest.transform;

import pe.upc.limapathsbackend.profiles.domain.model.aggregates.Profile;
import pe.upc.limapathsbackend.profiles.interfaces.rest.resources.ProfileResource;

public class ProfileResourceFromEntityAssembler {
    public static ProfileResource transformResourceFromEntity(Profile entity){
        return new ProfileResource(entity.getId(), entity.getFullName(), entity.getEmail(),
                entity.getUserType(), entity.getPassword(), entity.getTransportCompany());
    }
}
