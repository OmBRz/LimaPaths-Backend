package pe.upc.limapathsbackend.promos.domain.services;

import org.springframework.stereotype.Service;
import pe.upc.limapathsbackend.promos.domain.model.entities.Promo;
import pe.upc.limapathsbackend.promos.domain.model.queries.GetPromoByIdQuery;
import pe.upc.limapathsbackend.promos.domain.model.queries.GetPromosQuery;

import java.util.List;
import java.util.Optional;

@Service
public interface PromoQueryService {
    Optional<Promo> handle(GetPromoByIdQuery query);
    List<Promo> handle(GetPromosQuery query);
}
