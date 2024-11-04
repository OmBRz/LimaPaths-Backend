package pe.upc.limapathsbackend.promos.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.limapathsbackend.promos.domain.model.entities.Promo;
import pe.upc.limapathsbackend.promos.domain.model.queries.GetPromosQuery;
import pe.upc.limapathsbackend.promos.domain.services.PromoQueryService;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/promos")
@Tag(name="Promos", description = "Promos Management Endpoints")
public class PromosController {

    private final PromoQueryService promoQueryService;

    public PromosController(PromoQueryService promoQueryService) {
        this.promoQueryService = promoQueryService;
    }

    @GetMapping
    public ResponseEntity<List<Promo>> getAllPromos() {
        var promos = promoQueryService.handle(new GetPromosQuery());
        if (promos.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(promos);
    }
}
