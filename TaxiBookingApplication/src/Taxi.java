import java.util.ArrayList;
import java.util.List;

public class Taxi {
    int id;
    char currentPoint ='A';

    int totalEarnigs =0;
    List<Booking> bookings = new ArrayList<>();

    public Taxi(int id) {
        this.id = id;
    }

    public boolean isAvailable(int requestTime){
        if(bookings.isEmpty()) return true;

        Booking lastBooking = bookings.get(bookings.size() - 1);

        return lastBooking.dropTime <= requestTime;
    }
    public int calculateEarnings(char from , char to){
        int distance  = Math.abs((from - to)*15);

        return 100 + (distance - 5)*10;
    }
    public void addBooking(Booking booking){
        bookings.add(booking);
        totalEarnigs+=booking.amount;
        currentPoint = booking.to;

    }
}
