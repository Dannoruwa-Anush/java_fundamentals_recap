package enums;

public enum BookingStatusEnum {
    COMPLETED("Completed"),
    CANCELLED("Cancelled");

    private final String displayName;

    // all arg constructor
    BookingStatusEnum(String displayName) {
        this.displayName = displayName;
    }

    // getter
    public String getDisplayName() {
        return displayName;
    }
}
