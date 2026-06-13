public class BookingDriver{
    public static void main (String[] args){
        Concert e_obj = new Concert(1, "Padura", 5000, 1000, "Ridma");
        System.out.println(e_obj);

        RegularCustomer c_obj = new RegularCustomer(1, "test", "test@gmail.com");
        c_obj.calculateTicketPrice(120);
        System.out.println(c_obj);
    }
}