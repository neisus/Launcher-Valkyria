package fr.arinonia.valkyria.auth.premium.responses;

import fr.arinonia.valkyria.auth.premium.Profile;

public class AuthenticationResponse extends LoginResponse {

    private Profile[] availableProfiles;

    public AuthenticationResponse(String acessToken, String clientToke, Profile selectedProfile, Profile[] availableProfiles) {
        super(acessToken, clientToke, selectedProfile);
        this.availableProfiles = availableProfiles;
    }

    public Profile[] getAvaibleProfiles() {
        return availableProfiles;
    }
}
