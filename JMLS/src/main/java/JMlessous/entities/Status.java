package JMlessous.entities;


public enum Status {
    APPROVED("APPROVED"),
    DISAPPROVED("DISAPPROVED"),
	UNCHECKED("UNCHECKED");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
