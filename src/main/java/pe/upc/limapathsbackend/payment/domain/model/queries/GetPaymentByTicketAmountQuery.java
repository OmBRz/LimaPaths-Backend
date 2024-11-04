package pe.upc.limapathsbackend.payment.domain.model.queries;

import pe.upc.limapathsbackend.payment.domain.model.valueobjects.TicketAmount;

public record GetPaymentByTicketAmountQuery(TicketAmount ticket) {

}
