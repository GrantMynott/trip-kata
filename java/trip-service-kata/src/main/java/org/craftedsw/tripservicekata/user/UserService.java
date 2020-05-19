package org.craftedsw.tripservicekata.user;

public class UserService {

    public User getLoggedInUser() {
        return UserSession.getInstance().getLoggedUser();
    }

}
