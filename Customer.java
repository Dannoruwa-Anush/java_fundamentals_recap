public class Customer {
    private int customerId;
    private String name;
    private String email;

    // no arg constructor
    public Customer() {

    }

    // all arg constructor
    public Customer(int customerId, String name, String email) {
        setCustomerId(customerId);
        setName(name);
        setEmail(email);
    }

    // getters & setters
    public int getCustomerId() {
        return this.customerId;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setCustomerId(int customerId) {
        if (customerId <= 0) {
            throw new IllegalArgumentException("Customer ID must be greater than 0");
        }
        this.customerId = customerId;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name.trim();
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!email.matches(emailRegex)) {
            throw new IllegalArgumentException("Invalid email format");
        }

        this.email = email.trim();
    }

    // toString()
    @Override
    public String toString() {
        String out = "";
        out += " Customer ID: " + customerId;
        out += " Name : " + name;
        out += " Email : " + email;

        return out;
    }
}