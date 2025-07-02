import java.util.*;
import java.util.List;

class TaxiBookingSystem{


    static List<Taxi> taxis = new ArrayList<>();

    static Scanner sc  = new Scanner(System.in);

    static int customerCounter = 1;

    public static void main(String[] args) {


        System.out.print("Enter number of taxis :");
        int numOfTaxis = sc.nextInt();
        initTaxis(numOfTaxis);

        while(true){
            System.out.println("\n1. BOok a Taxi\n2. Display Taxi Details\n3. Exit");
            System.out.print("Enter your choice ");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    bookTaxi();
                    break;
                case 2:
                    displayTaxiDetails();
                    break;
                case 3:
                    System.out.println("Application Exited !");
                    break;
                default:
                    System.out.println("Invalid choice\n" +
                            "Try Again");
            }
        }
    }
    public static void initTaxis(int n){
            for(int i = 0 ;i<n;i++){
                 taxis.add(new Taxi(i));
            }
    }
    public static void bookTaxi(){
        int customerId = customerCounter++;

        System.out.print("Enter Pickup Point (A - F) :");
        char pickup =sc.next().toUpperCase().charAt(0);
        System.out.print("Enter Drop Point (A _ F):" );
        char drop = sc.next().toUpperCase().charAt(0);

        System.out.print("Enter PickUp Time in Hours(24H - Format) :");
        int pickUpTime = sc.nextInt();

        Taxi selectedTaxi =null;
        int minDistance = Integer.MAX_VALUE;

        for(Taxi taxi : taxis){
            if(taxi.isAvailable(pickUpTime)){

                int distance = Math.abs(taxi.currentPoint - pickup);

                if(distance<minDistance || (distance==minDistance && (taxi.totalEarnigs < selectedTaxi.totalEarnigs))){
                    selectedTaxi = taxi;
                    minDistance = distance;

                }
            }
        }
        if(selectedTaxi == null){
            System.out.println("Booking rejected. No Taxis available right now !");

        }
        int dropTime = pickUpTime + Math.abs(drop - pickup);
        assert selectedTaxi != null;
        int amount = selectedTaxi.calculateEarnings(pickup,drop);

        int bookingId = selectedTaxi.bookings.size()+1;

        Booking booking = new Booking(bookingId,customerId,pickUpTime,dropTime,amount,pickup,drop);

        selectedTaxi.addBooking(booking);

        System.out.println("Taxi - "+ selectedTaxi.id + "is allocated");
    }

    public static void displayTaxiDetails(){
        for(Taxi taxi :taxis){
            System.out.println("Taxi-"+taxi.id +"Total Earnings: Rs."+taxi.totalEarnigs);

            System.out.printf("%-10s %-10s %-5s %-5s %-12s %-9s %-6s%n","Booking ID ","Customer ID","From","To" ,"PickUp Time","Drop Time","Amount");

            for(Booking booking : taxi.bookings){
                System.out.printf("%-10d %-10d %-5s %-5s %-12s %-9d %-6d%n",
                        booking.bookingId,booking.customerId,booking.from,booking.to,booking.pickUptime,booking.dropTime,booking.amount);
            }

        }
    }
}