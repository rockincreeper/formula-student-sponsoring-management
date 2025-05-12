package fs.sponsoring.management.donation_manager.exceptions;

public class UnauthorizedRoleException extends RuntimeException {
    public UnauthorizedRoleException(String message) {
        super(message);
    }
}
