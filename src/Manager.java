import java.util.ArrayList;

public class Manager {
    private Passenger passenger;
    private ArrayList<Flight> availableFlights;

    public Manager(Passenger passenger) {
        this.passenger = passenger;
        availableFlights = new ArrayList<Flight>();
        availableFlights.add(new Flight("New York", "Paris", "8:00", "15:00"));
        availableFlights.add(new Flight("Paris", "Tokyo", "8:00", "15:00"));
        availableFlights.add(new Flight("Tokyo", "Dakar", "8:00", "15:00"));
        availableFlights.add(new Flight("Dakar", "Orlando", "8:00", "15:00"));
        availableFlights.add(new Flight("Orlando", "New York", "8:00", "15:00"));
    }

    public String viewPassengerInformation() {
        String str = "";
        str += "Name: " + passenger.getFirstName() + " " + passenger.getLastName() + "\n";
        boolean isMembership = false;
        if (passenger.getMembershipNum() != 0) {
            isMembership = true;
        }
        if (isMembership) {
            str += "Membership status: member" + "\n";
            str += "Membership number: " + passenger.getMembershipNum() + "\n";
            str += "Current bonus miles: " + passenger.getBonusMiles() + "\n";
        } else {
            str += "Membership status: not member" + "\n";
        }
        str += "Flights booked: \n";
        str += displayPassengerItinerary() + "\n";
        //ADD CODE TO DISPLAY WHY ITINERARY IS NOT COMPLETE
        return str;
    }

    // cancels flight by removing flight from passenger itinerary
    public void cancelFlight(int flightIndex) {
        passenger.getItinerary().getFlightsList().remove(flightIndex);
    }

    // formats all the flights in the passenger's itinerary
    public String displayPassengerItinerary() {
        String str = "";
        for (int i = 0; i < passenger.getItinerary().getFlightsList().size(); i++) {
            str += (i + 1) + ". " + passenger.getItinerary().getFlightsList().get(i).toString() + "\n";
        }
        return str;
    }

    // book flight, I didnt add conditions to check if user choice is valid
    // TO DO
    public void bookFlight(int flightIndex) {
        // check how many flights are in itinerary
        int numFlightInItinerary = passenger.getItinerary().getFlightsList().size();
        if (numFlightInItinerary == 0) {
            //here we are assuming the passenger is booking a departing flight

        } else if (numFlightInItinerary == 1) {
            //here we will ask if this is a departing or return flight
            //Ill assume that this is a connection for a departing flight BUT THIS IS WRONG

        } else if (numFlightInItinerary == 2) {
            //here we are assuming the passenger is booking a return flight

        } else if (numFlightInItinerary == 3) {
            //here we are assuming the passenger is booking a connection for return flight

        }
        passenger.getItinerary().getFlightsList().add(availableFlights.get(flightIndex));
    }

    public String displayAllAvailableFlights() {
        String str = "";
        for (int i = 0; i < availableFlights.size(); i++) {
            str += (i + 1) + ". " + availableFlights.get(i).toString() + "\n";
        }
        str += "-1. No flight\n";
        return str;
    }
    // create membership
    public void createMembership() {
        passenger.setMembershipNum(generateMembershipNum());
        passenger.setBonusMiles(25000);
    }
    // returns a random 8 digit membership number
    public int generateMembershipNum() {
        String number = "";
        for (int i = 0; i < 8; i++) {
            number += (int) (Math.random() * 10) + "";
        }
        return Integer.valueOf(number);
    }

    //getter
    public Passenger getPassenger() {
        return passenger;
    }

    public ArrayList<Flight> getAvailableFlights() {
        return availableFlights;
    }
}
