package pe.upc.limapathsbackend.payment.domain.model.commands;

import jakarta.validation.constraints.NotBlank;

public record CreatePaymentCommand(
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
