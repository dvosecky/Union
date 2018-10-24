import java.util.List;

import com.revature.beans.Account;
import com.revature.dao.AccountDaoImpl;
public class Driver {

	public static void main(String[] args) {
		
		
		AccountDaoImpl account= new AccountDaoImpl();
		List<Account> accounts;
		
		System.out.println("===================================");
		
		
		Account acc= null;
		
		acc = account.selectAccountById(2);
		
		System.out.println("By id: "+ acc);
		
		System.out.println("===================================");
		
		acc=account.selectAccountByUsername("a");
		
		System.out.println("By username: " + acc );
		
		System.out.println("===================================");
		int index;
		
		acc= new Account(null,"ff","f","first","last",acc.getDep());
		index= account.insertAccount(acc);
		System.out.println( index  );
		
		System.out.println("===================================");
		
		acc=account.selectAccountById(index);
		System.out.println("Deleting id: "+index+ acc);
		
		account.deleteAccountById(index);
		
		System.out.println("===================================");
		
		acc=account.selectAccountByUsername("z");
		System.out.println("Deleting id: "+"z"+ acc);
		
		account.deleteAccountByUsername("z");
		
		System.out.println("===================================");
		accounts = account.selectAllAccount();
		
		for( Account a: accounts) {
			System.out.println(a);
		}
		
		
		
		System.out.println("===================================");
		System.exit(0);

	}

}
