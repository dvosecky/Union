import java.util.List;

import com.revature.beans.Account;
import com.revature.dao.AccountDaoImpl;
public class Driver {

	public static void main(String[] args) {
		
		
		AccountDaoImpl account= new AccountDaoImpl();
		List<Account> accounts;
		
		accounts = account.selectAllAccount();
		
		for( Account a: accounts) {
			//System.out.println(a);
			//The problem with using this is we're getting it lazy, and if it is lazy, then
			//collections within it are not fetched and will not be fetched when we call the
			//to string method
			System.out.println(a.getFirstname());
		}
		
		
		System.out.println("===================================");
		System.exit(0);

	}

}
