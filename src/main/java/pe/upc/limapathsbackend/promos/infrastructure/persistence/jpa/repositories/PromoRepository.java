package pe.upc.limapathsbackend.promos.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upc.limapathsbackend.promos.domain.model.entities.Promo;

@Repository
public interface PromoRepository extends JpaRepository<Promo, Long> {
}
