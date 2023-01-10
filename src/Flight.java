public class Flight {
    private String departureLocation;
    private String destinationLocation;
    private String departureTime;
    private String arrivalTime;

    public Flight(String departureLocation, String destinationLocation, String departureTime, String arrivalTime) {
        this.departureLocation = departureLocation;
        this.destinationLocation = destinationLocation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String toString() {
        String str = "";
        str += departureLocation + " to " + destinationLocation + " | Departure: " + departureTime + ", Destination: " + arrivalTime;
        return str;
    }

    //getters and setters
    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
