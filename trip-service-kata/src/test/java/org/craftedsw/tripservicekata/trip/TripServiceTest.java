package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TripServiceTest {

    @Test
    void should_throw_an_exception_when_user_is_not_logged() {
        // arrange
        TripService tripService = new TestableTripService(null);
        User user = new User();

        // act
        // assert
        assertThatThrownBy(() -> tripService.getTripsByUser(user)).isInstanceOf(UserNotLoggedInException.class);
    }

    @Test
    void should_return_an_empty_list_if_logged_in_user_has_no_friends() {
        // arrange
        TripService tripService = new TestableTripService(new User());
        User anotherUser = new User();

        // act
        List<Trip> tripsForUserWithoutFriends = tripService.getTripsByUser(anotherUser);

        // assert
        assertThat(tripsForUserWithoutFriends).isEmpty();
    }


    @Test
    void should_return_friends_trips_when_users_are_friends() {
        // arrange
        User user = new User();

        User userFriend = new User();
        userFriend.addTrip(new Trip());
        userFriend.addFriend(user);


        TripService tripService = new TestableTripService(user);

        // act
        List<Trip> tripsForFriend = tripService.getTripsByUser(userFriend);


        // assert
        assertThat(tripsForFriend).hasSize(1);
    }


    private class TestableTripService extends TripService {

        private User loggedUser;

        private TestableTripService(User loggedUser) {
            this.loggedUser = loggedUser;
        }

        @Override
        protected User getLoggedUser() {
            return loggedUser;
        }

        @Override
        protected List<Trip> getTripsByUserFromDb(User user) {
            return user.trips();
        }
    }
}
