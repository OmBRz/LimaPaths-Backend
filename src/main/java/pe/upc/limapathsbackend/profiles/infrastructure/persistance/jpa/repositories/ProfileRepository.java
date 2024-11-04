package pe.upc.limapathsbackend.profiles.infrastructure.persistance.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upc.limapathsbackend.profiles.domain.model.aggregates.Profile;
import pe.upc.limapathsbackend.profiles.domain.model.valueobjects.EmailAddress;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByEmail(EmailAddress id);
}
