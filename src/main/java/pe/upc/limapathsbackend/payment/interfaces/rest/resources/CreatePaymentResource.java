package pe.upc.limapathsbackend.payment.interfaces.rest.resources;

import jakarta.validation.constraints.NotBlank;

public record CreatePaymentResource(
        String busName,
        String originStop,
        String originLatitude,
        String originLongitude,
        String destinationStop,
        String destinationLatitude,
        String destinationLongitude,
        String exchange,
        String price,
        String hour,
        String minutes,
        String dayTime
) {

}
