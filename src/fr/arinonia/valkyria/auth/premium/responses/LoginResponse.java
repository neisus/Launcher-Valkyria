package fr.arinonia.valkyria.auth.premium.responses;

import fr.arinonia.valkyria.auth.premium.Profile;

public class LoginResponse {

    private String acessToken;
    private String clientToke;
    private Profile selectedProfile;

    public LoginResponse(String acessToken, String clientToke, Profile selectedProfile) {
        this.acessToken = acessToken;
        this.clientToke = clientToke;
        this.selectedProfile = selectedProfile;
    }

    public String getAcessToken() {
        return acessToken;
    }

    public String getClientToke() {
        return clientToke;
    }

    public Profile getSelectedProfile() {
        return selectedProfile;
    }
}
