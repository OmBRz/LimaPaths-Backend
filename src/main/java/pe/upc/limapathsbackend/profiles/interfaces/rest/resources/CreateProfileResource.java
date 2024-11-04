package pe.upc.limapathsbackend.profiles.interfaces.rest.resources;

public record CreateProfileResource(String firstName,
                                    String lastName,
                                    String email,
                                    String userType,
                                    String password,
                                    String transportCompany) {
}
