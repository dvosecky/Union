import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Event;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.EventDaoImpl;
//import com.revature.services.UserService;
public class Driver {

	public static void main(String[] args) {
	
	List<Account> accounts;
//	
		
	System.out.println("===================================");
	
	AccountDaoImpl account= new AccountDaoImpl();
	
	System.out.println("===================================");
	//Account acc=account.selectAccountById(2);

	
	System.out.println("===================================");

	//Event event = new Event(null, null, "landons party", "a cool party", "landons house",acc);
	//EventDaoImpl manager = new EventDaoImpl();
	//System.out.println(manager.selectEventById(2));
	
	//System.out.println(event);
	System.out.println("---=-=-=-=-=-=-=-=--------------------------");
	//Account acc=null;
	//acc = UserService.loginToUnion("d", "d");
	
//	if(acc != null) {
//		System.out.println("Workss===========================================");
//	}
//		
////		
 //	Account acc= null;
////		
////		acc = account.selectAccountById(2);
//		
//		//System.out.println("By id: "+ acc);
//		
//		System.out.println("===================================");
//		
//		acc=account.selectAccountByUsername("a");
////		
//		System.out.println("By username: " + acc );
//		
//		System.out.println("===================================");
//		int index;
////		
//		acc= new Account(null,"ff","f","first","last",acc.getDep(),1);
//		index= account.insertAccount(acc);
//		System.out.println( index  );
//		
//		System.out.println("===================================");
////		
////		acc=account.selectAccountById(index);
////		System.out.println("Deleting id: "+index+ acc);
////		
////		account.deleteAccountById(index);
////		
//		System.out.println("===============Deleting====================");
//		
		//acc=account.selectAccountByUsername("z");
		//System.out.println("Deleting id: "+"z "+ acc);
		//work if record exist 
		//acc=account.selectAccountByUsername("z");
		//System.out.println("Deleting id: "+"z "+ acc);
		//account.deleteAccountByUsername("z");
		
		System.out.println("===================================");
		//account.deleteAccount(4);
		accounts = account.selectAllAccount();

		System.out.println();
		System.out.println("===================================");
		for( Account a: accounts) {
			System.out.println(a);
		}
		
		System.out.println();
		System.out.println("================Department===================");
		
//		List<Department> departments=null;
//		DepartmentDaoImpl depart = new DepartmentDaoImpl();
//		
//		departments= depart.selectAllDepartment();
//		
//		for( Department d: departments) {
//			System.out.println(d);
//			System.out.println(d.getAccount());
//		}
		
		
		System.exit(0);

	}

}
