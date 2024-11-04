package pe.upc.limapathsbackend.payment.interfaces.rest;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.limapathsbackend.payment.domain.model.queries.GetPaymentByIdQuery;
import pe.upc.limapathsbackend.payment.domain.services.PaymentCommandService;
import pe.upc.limapathsbackend.payment.domain.services.PaymentQueryService;
import pe.upc.limapathsbackend.payment.interfaces.rest.resources.CreatePaymentResource;
import pe.upc.limapathsbackend.payment.interfaces.rest.resources.PaymentResource;
import pe.upc.limapathsbackend.payment.interfaces.rest.transform.CreatePaymentCommandFromResourceAssembler;
import pe.upc.limapathsbackend.payment.interfaces.rest.transform.PaymentResourceFromEntityAssembler;

/*
    PaymentController
    <p>
        This class is the entry point for all the REST endpoints related to the Payment Entity
    </p>
*/

@RestController
@RequestMapping(value = "/api/v1/payment")
@Tag( name = "Payments", description = "Payments Management Endpoints")
public class PaymentController {

    private final PaymentQueryService paymentQueryService;
    private final PaymentCommandService paymentCommandService;

    public PaymentController(PaymentQueryService paymentQueryService, PaymentCommandService paymentCommandService) {
        this.paymentQueryService = paymentQueryService;
        this.paymentCommandService = paymentCommandService;
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentResource> getPaymentById(@PathVariable Long paymentId) {
        var getPaymentByIdQuery = new GetPaymentByIdQuery(paymentId);
        var payment = paymentQueryService.handle(getPaymentByIdQuery);
        if (payment.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(PaymentResourceFromEntityAssembler.transformResourceFromEntity(payment.get()));
    }

    @PostMapping
    public ResponseEntity<PaymentResource> createPayment(@RequestBody CreatePaymentResource resource) {
        var createPaymentCommand = CreatePaymentCommandFromResourceAssembler.toCommandFromResource(resource);
        var payment = paymentCommandService.handle(createPaymentCommand);
        if(payment.isEmpty()) return ResponseEntity.badRequest().build();

        var paymentResource =  PaymentResourceFromEntityAssembler.transformResourceFromEntity(payment.get());
        return new ResponseEntity<PaymentResource>(paymentResource, HttpStatus.CREATED);
    }
}
