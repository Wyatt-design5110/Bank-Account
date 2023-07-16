public class IllegalArgumentException extends Exception {
    private String message;

    public void DepositNegativeException(String m){
        //super("You currently do not have enough to withdraw");
        this.message = m;
    }
}