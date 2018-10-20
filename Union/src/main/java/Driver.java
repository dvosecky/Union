import java.util.List;

import com.revature.beans.Account;
import com.revature.dao.AccountDaoImpl;
public class Driver {

	public static void main(String[] args) {
		
		
		AccountDaoImpl account= new AccountDaoImpl();
		List<Account> accounts;
		
		accounts=account.selectAllAccount();
		
		for( Account a: accounts) {
			System.out.println(a);
		}
		
		
		System.exit(0);

	}

}
