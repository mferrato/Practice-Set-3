import java.util.Date;

public class Account {
	private int id = 0;
	private double balance = 0;
	private double annualInterestRate = 0;
	private Date dateCreated;

	// No arg constructor
	public Account() {
	}

	// Constructor
	public Account(int givenID, double initialBalance) {
		this.id = givenID;
		this.balance = initialBalance;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate / 100;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	// Monthly Interest Rate method
	public double getMonthlyInterestRate() {
		return (annualInterestRate * 100) / 12;
	}

	// Withdraw and deposit methods
	public void withdraw(double moneyWithdrawn)
			throws InsufficientFundsException {
		if (balance < moneyWithdrawn) {
			this.balance -= moneyWithdrawn;
		} else {
			double needs = moneyWithdrawn - balance;
			throw new InsufficientFundsException(needs);
		}
	}

	public void deposit(double moneyDeposited) {
		this.balance += moneyDeposited;
	}
}
