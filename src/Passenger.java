public class Passenger {
    private String lastName;
    private String firstName;
    private int membershipNum;
    private int bonusMiles;
    private Itinerary itinerary;

    public Passenger(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
        itinerary = new Itinerary();
    }

    //getters and setters
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getMembershipNum() {
        return membershipNum;
    }

    public void setMembershipNum(int membershipNum) {
        this.membershipNum = membershipNum;
    }

    public int getBonusMiles() {
        return bonusMiles;
    }

    public void setBonusMiles(int bonusMiles) {
        this.bonusMiles = bonusMiles;
    }

    public Itinerary getItinerary() {
        return itinerary;
    }

    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
    }
}
