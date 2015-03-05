import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {

	Account account;

	@Before
	public void setUp() throws Exception {
		account = new Account(1112, 20000);
		account.setAnnualInterestRate(4.5);
	}

	@After
	public void tearDown() throws Exception {
		account = null;
	}

	@Test
	public final void testWithdraw() throws InsufficientFundsException {
		account.withdraw(2500);
		assertEquals(
				"Withdrawing $2,500 from the account leaves a $17,500 balance",
				(double) 17500, (double) account.getBalance(), 0.001);
	}

	@Test
	public final void testDeposit() {
		account.deposit(3000);
		assertEquals(
				"Depositing $3,000 to the account leaves a $23,000 balance",
				23000, account.getBalance(), 0.001);
	}

	@Test
	public final void testPrintout() {
		System.out.print("Balance: $" + account.getBalance());
		System.out.print("Monthly Interest Rate: "
				+ account.getMonthlyInterestRate() + "%");
		System.out.print("Account created on: " + account.getDateCreated());
		assertEquals("Balance: $20000", "Balance: $" + account.getBalance());
		assertEquals("Monthly Interest Rate: .375%", "Monthly Interest Rate: "
				+ account.getMonthlyInterestRate() + "%");
		assertEquals("Account created on:" + account.getDateCreated(),
				"Account created on: " + account.getDateCreated());
	}

	@Test(expected = InsufficientFundsException.class)
	public final void testWithdrawError() throws InsufficientFundsException {
		account.withdraw(30000);
	}

}
