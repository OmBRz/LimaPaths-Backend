package pe.upc.limapathsbackend.profiles.domain.services;

import org.springframework.stereotype.Service;
import pe.upc.limapathsbackend.profiles.domain.model.aggregates.Profile;
import pe.upc.limapathsbackend.profiles.domain.model.commands.CreateProfileCommand;

import java.util.Optional;

@Service
public interface ProfileCommandService {
    Optional<Profile> handle(CreateProfileCommand command);
}
