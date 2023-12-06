package dev.brighten.isitbad.structures;

public class FailedResponse {
    private final boolean success;
    private final String reason;

    public FailedResponse(boolean success, String reason) {
        this.success = success;
        this.reason = reason;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getReason() {
        return reason;
    }
}
