public class Booking {

    int bookingId;
    int customerId;
    int pickUptime;
    int dropTime;
    int amount;

    char from ,to;


    public Booking(int bookingId, int customerId, int pickUptime, int dropTIme, int amount, char from, char to) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.pickUptime = pickUptime;
        this.dropTime = dropTIme;
        this.amount = amount;
        this.from = from;
        this.to = to;
    }



}
