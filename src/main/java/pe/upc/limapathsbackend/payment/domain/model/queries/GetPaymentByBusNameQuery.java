package pe.upc.limapathsbackend.payment.domain.model.queries;

import pe.upc.limapathsbackend.payment.domain.model.valueobjects.Bus;

public record GetPaymentByBusNameQuery(Bus busName) {
}
