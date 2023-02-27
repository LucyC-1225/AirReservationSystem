import java.util.ArrayList;

public class Manager {
    private Passenger passenger;
    private ArrayList<Flight> availableFlights;

    public Manager(Passenger passenger) {
        this.passenger = passenger;
        availableFlights = new ArrayList<Flight>();
        availableFlights.add(new Flight("New York", "Paris", "8:00", "15:00"));
        availableFlights.add(new Flight("Paris", "Tokyo", "18:00", "7:00"));
        availableFlights.add(new Flight("Tokyo", "Dakar", "9:00", "4:00"));
        availableFlights.add(new Flight("Dakar", "Orlando", "8:00", "19:00"));
        availableFlights.add(new Flight("Orlando", "New York", "21:00", "0:00"));
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

        Flight firstFlight = passenger.getItinerary().getFlightsList().get(0);
        Flight lastFlight = passenger.getItinerary().getFlightsList().get(passenger.getItinerary().getFlightsList().size() - 1);

        if (firstFlight.getDepartureLocation().equals(lastFlight.getDestinationLocation())) {
            str += "\nItinerary Complete: Yes\n";
        } else {
            str += "\nItinerary Complete: No\n";
        }
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

    public boolean bookFlight(int flightIndex) {
        // check how many flights are in itinerary
        int numFlightInItinerary = passenger.getItinerary().getFlightsList().size();
        // flight the user chose
        Flight userChoiceFlight = availableFlights.get(flightIndex);
        if (numFlightInItinerary == 0) {
            //here we are assuming the passenger is booking a departing flight
            //book the flight
            passenger.getItinerary().getFlightsList().add(availableFlights.get(flightIndex));
            return true;
        } else {
            int sizeOfUserFlightList = passenger.getItinerary().getFlightsList().size() - 1;
            Flight lastUserFlight = passenger.getItinerary().getFlightsList().get(sizeOfUserFlightList);

            if (lastUserFlight.getDestinationLocation().equals(userChoiceFlight.getDepartureLocation())) {
                // book the flight
                passenger.getItinerary().getFlightsList().add(availableFlights.get(flightIndex));
                return true;
            } else {
                return false;
            }
        }
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
        return Integer.parseInt(number);
    }

    //getter
    public Passenger getPassenger() {
        return passenger;
    }

    public ArrayList<Flight> getAvailableFlights() {
        return availableFlights;
    }
}
