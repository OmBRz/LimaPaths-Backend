package pe.upc.limapathsbackend.profiles.domain.model.queries;

import pe.upc.limapathsbackend.profiles.domain.model.valueobjects.EmailAddress;

public record GetProfileByEmailQuery(EmailAddress emailAddress) {
}
