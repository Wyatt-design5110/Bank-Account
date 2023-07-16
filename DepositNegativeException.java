public class DepositNegativeException extends Exception {
    private String message;

    public void DepositNegativeException(String m){
        //super("You can not withdraw an amount below zero");
        this.message = m;
    }
}