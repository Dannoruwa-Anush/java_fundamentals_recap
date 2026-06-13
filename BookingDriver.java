public class BookingDriver{
    public static void main (String[] args){
        Event e_obj = new Event(1, "Padura", 5000, 1000);
        System.out.println(e_obj);

        RegularCustomer c_obj = new RegularCustomer(1, "test", "test@gmail.com");
        c_obj.calculateTicketPrice(120);
        System.out.println(c_obj);
    }
}