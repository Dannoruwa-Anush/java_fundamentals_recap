public class BookingDriver{
    public static void main (String[] args){
        RegularCustomer obj = new RegularCustomer(1, "test", "test@gmail.com");
        obj.calculateTicketPrice(120);
        System.out.println(obj);
    }
}