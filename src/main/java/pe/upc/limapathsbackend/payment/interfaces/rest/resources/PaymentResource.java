package pe.upc.limapathsbackend.payment.interfaces.rest.resources;

public record PaymentResource(Long id, String bus, String origin, String destination, String TicketAmount, String TimeTrip ) {
}
