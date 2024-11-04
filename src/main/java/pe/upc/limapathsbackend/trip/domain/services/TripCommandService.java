package pe.upc.limapathsbackend.trip.domain.services;

import org.springframework.stereotype.Service;
import pe.upc.limapathsbackend.trip.domain.model.aggregates.Trip;
import pe.upc.limapathsbackend.trip.domain.model.commands.CreateTripCommand;

import java.util.Optional;

@Service
public interface TripCommandService {
    Optional<Trip> handle(CreateTripCommand command);
}