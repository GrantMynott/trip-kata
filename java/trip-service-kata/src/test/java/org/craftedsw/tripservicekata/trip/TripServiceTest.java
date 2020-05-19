package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TripServiceTest {

    private final UserService userServiceMock = mock(UserService.class);
    private final TripService tripService = new TripService(userServiceMock);

    @Test
    public void givenUserNotLoggedInThenThrowException() {
        when(userServiceMock.getLoggedInUser()).thenReturn(null);

        User user = new User();
        Executable getTripByUser = () -> new TripService(userServiceMock).getTripsByUser(user);

        Assertions.assertThrows(UserNotLoggedInException.class, getTripByUser);
    }
    
    @Test
    void givenUserLoggedInAndNotFriendsReturnEmptyList() {
        when(userServiceMock.getLoggedInUser()).thenReturn(new User());

        User user = new User();
        List resultList = tripService.getTripsByUser(user);

        Assertions.assertEquals(0, resultList.size());
    }
    @Test
    public void givenUserLoggenInAndFriendsfrindTripsByUserIScalledwithCorrectUSer(){
        User fred = new User();
                User loggedUser = new User();
                fred.addFriend(loggedUser);
        when(userServiceMock.getLoggedInUser()).thenReturn(loggedUser);
     tripService.getTripsByUser(fred);
        //Assertions.assert
    }
}
