class Account {
    private int id;
    private double balance;
    private static double annualInterestRate;
    private java.util.Date dateCreated;
    public Account() {
        dateCreated = new java.util.Date();
    }
    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        dateCreated = new java.util.Date();
    }
    public int getID() {
        return this.id;
    }
    public double getBalance() {
        return this.balance;
    }
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }
    public void setID(int id) {
        this.id = id;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public static void setAnnualInterestRate(double newAnnualInterestRate) {
        annualInterestRate = newAnnualInterestRate;
    }
    public double getMonthlyInterest() {
        return balance * (annualInterestRate / 1200);
    }
    public java.util.Date getDateCreated() {
        return dateCreated;
    }
    public void withdraw(double amount) {
        this.balance -= amount;
    }
    public void deposit(double amount) {
        this.balance += amount;
    }

}
