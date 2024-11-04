package pe.upc.limapathsbackend.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;

@Embeddable
public record EmailAddress(@Email String emailAddress) {
    public EmailAddress() { this(null); }

    public String getEmailAddress() {return emailAddress;}
}
