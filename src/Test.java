import wrapper.ClientDAO;
import wrapper.TransactionDAO;

public class Test {

	public static void main(String[] args) {
		TransactionDAO c = new TransactionDAO();
		System.out.println((c.get(1)));
	}
}
