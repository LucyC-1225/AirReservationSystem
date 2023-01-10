import java.util.ArrayList;

public class Itinerary {
    private ArrayList<Flight> flightsList;
    private boolean isItineraryComplete;

    public Itinerary() {
        flightsList = new ArrayList<Flight>();
    }

    //getters and setters
    public ArrayList<Flight> getFlightsList() {
        return flightsList;
    }

    public void setFlightsList(ArrayList<Flight> flightsList) {
        this.flightsList = flightsList;
    }

    public boolean isItineraryComplete() {
        return isItineraryComplete;
    }

    public void setItineraryComplete(boolean itineraryComplete) {
        isItineraryComplete = itineraryComplete;
    }
}
