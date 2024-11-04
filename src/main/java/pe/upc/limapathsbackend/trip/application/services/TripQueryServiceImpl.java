package pe.upc.limapathsbackend.trip.application.services;

import org.springframework.stereotype.Service;
import pe.upc.limapathsbackend.trip.domain.model.aggregates.Trip;
import pe.upc.limapathsbackend.trip.domain.model.queries.GetTripByIdQuery;
import pe.upc.limapathsbackend.trip.domain.model.queries.GetTripByOriginQuery;
import pe.upc.limapathsbackend.trip.domain.model.queries.GetTripByFareQuery;
import pe.upc.limapathsbackend.trip.domain.services.TripQueryService;
import pe.upc.limapathsbackend.trip.infrastructure.persistence.jpa.repositories.TripRepository;

import java.util.Optional;

@Service
public class TripQueryServiceImpl implements TripQueryService {

    private final TripRepository tripRepository;

    public TripQueryServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public Optional<Trip> handle(GetTripByIdQuery query) {
        return tripRepository.findById(query.id());
    }

    @Override
    public Optional<Trip> handle(GetTripByOriginQuery query) {
        return tripRepository.findByOrigin(query.origin());
    }

    @Override
    public Optional<Trip> handle(GetTripByFareQuery query) {
        return tripRepository.findByFare(query.fare());
    }
}
