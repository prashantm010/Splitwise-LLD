package exception;

public class InvalidSettlementRequestException extends RuntimeException {
    public InvalidSettlementRequestException(String message) {
        super(message);
    }
}
