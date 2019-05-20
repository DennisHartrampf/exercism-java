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

    private synchronized void checkIsDepositAllowed(int amount)
    throws BankAccountActionInvalidException {
        checkIsOpen();
        if (amount < 0) {
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        }
    }

    private synchronized void checkIsWithdrawalAllowed(int amount)
    throws BankAccountActionInvalidException {
        checkIsOpen();
        if (amount < 0) {
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        }
        if (balance == 0) {
            throw new BankAccountActionInvalidException(
                "Cannot withdraw money from an empty account");
        }
        if (amount > balance) {
            throw new BankAccountActionInvalidException(
                "Cannot withdraw more money than is currently in the account");
        }
    }

    private synchronized void checkIsOpen() throws BankAccountActionInvalidException {
        if (!open) {
            throw new BankAccountActionInvalidException("Account closed");
        }
    }

}
