
public class InsufficientFundsException extends Exception {

	private double value;

	public InsufficientFundsException(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}
}

