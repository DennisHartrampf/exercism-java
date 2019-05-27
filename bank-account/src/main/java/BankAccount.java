class BankAccount {
    private int balance;
    private boolean open;

    synchronized void open() {
        open = true;
    }

    synchronized void close() {
        open = false;
    }

    synchronized int getBalance() throws BankAccountActionInvalidException {
        checkIsOpen();
        return balance;
    }

    synchronized void deposit(int amount) throws BankAccountActionInvalidException {
        checkIsDepositAllowed(amount);
        balance += amount;
    }

    synchronized void withdraw(int amount) throws BankAccountActionInvalidException {
        checkIsWithdrawalAllowed(amount);
        balance -= amount;
    }

    private void checkIsDepositAllowed(int amount) throws BankAccountActionInvalidException {
        checkIsOpen();
        check(amount < 0, "Cannot deposit or withdraw negative amount");
    }

    private void checkIsWithdrawalAllowed(int amount) throws BankAccountActionInvalidException {
        checkIsOpen();
        check(amount < 0, "Cannot deposit or withdraw negative amount");
        check(balance == 0, "Cannot withdraw money from an empty account");
        check(amount > balance, "Cannot withdraw more money than is currently in the account");
    }

    private void checkIsOpen() throws BankAccountActionInvalidException {
        check(!open, "Account closed");
    }

    private void check(boolean condition, String exceptionMessage)
    throws BankAccountActionInvalidException {
        if (condition) {
            throw new BankAccountActionInvalidException(exceptionMessage);
        }
    }

}
