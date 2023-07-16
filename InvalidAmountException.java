public class InvalidAmountException extends Exception {
    private String message;

    public void InvalidAmountException(String m){
        //super("You have zero Balance");
        this.message = m;
    }
}

