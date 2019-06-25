package exceptions;

public class NoSuchSeedsSizeException extends Exception {

    private String seedsSize;

    public String getSeedsSize() {
        return seedsSize;
    }

    public NoSuchSeedsSizeException(String message, String seedsSize) {
        super(message);
        this.seedsSize = seedsSize;
        System.out.printf("Unexpected seeds size [%s] .", seedsSize);
    }
}
