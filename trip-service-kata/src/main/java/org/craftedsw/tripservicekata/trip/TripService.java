package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService {

    public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
        User loggedUser = getLoggedUser();
		if (loggedUser == null) {
            throw new UserNotLoggedInException();
        }
        return isFriendWithLoggerUser(user) ? getTripsByUserFromDb(user) : new ArrayList<>();
    }

    protected List<Trip> getTripsByUserFromDb(User user) {
        return TripDAO.findTripsByUser(user);
    }

    protected User getLoggedUser() {
        return UserSession.getInstance().getLoggedUser();
    }

    private boolean isFriendWithLoggerUser(User user) {
		User loggedUser = getLoggedUser();
		return user.getFriends().stream().anyMatch(friend -> friend.equals(loggedUser));
	}
}
