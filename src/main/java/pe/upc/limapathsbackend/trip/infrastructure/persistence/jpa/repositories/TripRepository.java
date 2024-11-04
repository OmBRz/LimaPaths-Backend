package pe.upc.limapathsbackend.trip.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upc.limapathsbackend.trip.domain.model.aggregates.Trip;
import pe.upc.limapathsbackend.trip.domain.model.valueobjects.Origin;
import pe.upc.limapathsbackend.trip.domain.model.valueobjects.Fare;

import java.util.Optional;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    Optional<Trip> findByOrigin(Origin origin);

    Optional<Trip> findByFare(Fare fare);

}
