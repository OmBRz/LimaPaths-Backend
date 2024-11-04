package pe.upc.limapathsbackend.payment.domain.model.queries;

public record GetPaymentByIdQuery(Long id) {
    public GetPaymentByIdQuery{
        if(id == null){
            throw new IllegalArgumentException("id cannot be null");
        }

        if(id < 0) {
            throw new IllegalArgumentException("id cannot be negative");
        }
    }
}
