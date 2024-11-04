package pe.upc.limapathsbackend.profiles.application.services;

import org.springframework.stereotype.Service;
import pe.upc.limapathsbackend.profiles.domain.model.aggregates.Profile;
import pe.upc.limapathsbackend.profiles.domain.model.queries.GetProfileByEmailQuery;
import pe.upc.limapathsbackend.profiles.domain.model.queries.GetProfileByIdQuery;
import pe.upc.limapathsbackend.profiles.domain.services.ProfileQueryService;
import pe.upc.limapathsbackend.profiles.infrastructure.persistance.jpa.repositories.ProfileRepository;

import java.util.Optional;

@Service
public class ProfileQueryServiceImpl implements ProfileQueryService {
    private final ProfileRepository profileRepository;

    public ProfileQueryServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Optional<Profile> handle(GetProfileByIdQuery query) {
        return profileRepository.findById(query.id());
    }

    @Override
    public Optional<Profile> handle(GetProfileByEmailQuery query) {
        return profileRepository.findByEmail(query.emailAddress());
    }

}
