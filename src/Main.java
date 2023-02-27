import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.print("Enter your first name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = sc.nextLine();

        Manager m = new Manager(new Passenger(lastName, firstName));

        boolean logout = false;
        while (!logout) {
            System.out.println();
            System.out.println("--------------------------------------");
            System.out.println("Hello " + m.getPassenger().getFirstName() + " " + m.getPassenger().getLastName());
            System.out.println("What would you like to do?");
            System.out.println("1. Create a membership");
            System.out.println("2. Book a flight");
            System.out.println("3. Cancel a flight");
            System.out.println("4. View passenger information");
            System.out.println("5. Logout");
            System.out.print("Choice: ");

            String userChoice = sc.nextLine();
            System.out.println("--------------------------------------");

            if (userChoice.equals("1")) {
                System.out.println("Creating membership....");
                m.createMembership();
                System.out.println("Membership created! Your unique membership number is " + m.getPassenger().getMembershipNum());
                System.out.println("Congrats, you got 25,000 bonus miles!");

                System.out.println("Click enter to continue");
                sc.nextLine();
            } else if (userChoice.equals("2")) {
                System.out.println(m.displayAllAvailableFlights());
                System.out.println("Which flight would you like to book?");
                System.out.print("Choice: ");
                String choice = sc.nextLine();
                if (!choice.equals("-1")) {
                    String flightStr = "Flight from " + m.getAvailableFlights().get(Integer.parseInt(choice) - 1).getDepartureLocation() + " to " + m.getAvailableFlights().get(Integer.parseInt(choice) - 1).getDestinationLocation();
                    // if booking flight not successful
                    if (m.bookFlight(Integer.parseInt(choice) - 1)) {
                        System.out.println(flightStr + " is booked");
                    } else {
                        System.out.println(flightStr + " unsuccessfully booked");
                    }
                }
                System.out.println("Click enter to continue");
                sc.nextLine();
            } else if (userChoice.equals("3")) {
                System.out.println("Here are the current flights in your itinerary: ");
                System.out.println(m.displayPassengerItinerary());
                System.out.println("Which flight would you like to cancel? Enter -1 to exit");
                System.out.print("Choice: ");
                String choice = sc.nextLine();
                if (!choice.equals("-1")) {
                    m.cancelFlight(Integer.parseInt(choice) - 1);
                    System.out.println("Flight canceled");
                }

                System.out.println("Click enter to continue");
                sc.nextLine();
            } else if (userChoice.equals("4")) {
                System.out.println(m.viewPassengerInformation());

                System.out.println("Click enter to continue");
                sc.nextLine();
            } else if (userChoice.equals("5")) {
                System.out.println("Logged out. Thank you");
                logout = true;
            } else {
                System.out.println("That is not a valid choice. Please try again.");
            }
        }
    }
}
