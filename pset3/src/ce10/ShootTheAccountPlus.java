
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class ShootTheAccount {
  private int balance = 0;
  private List<Transaction> ListOfAllTransactions = new ArrayList<Transaction>();
  private String lastDebitTime;
  private String lastCreditTime;
  private String accountType;
  
  public ShootTheAccount () {
    this.accountType = "personal";
  }

  public ShootTheAccount (int balance, String accountType) {
    this.balance = balance;
    this.accountType = accountType;
  }
  
  public void deposite (int amount) {
    balance += amount;
  }
    
  public void setBalance (int amount) {
    balance = amount;
  }
  
  public int getBalance () {
    return balance;
  }
  
  
  // this method has a long method smell
  public void DebitTransaction(int amount) {
	  
	  if (!personalaccountexceed()) {
		  //reduce the amount
		  balance = balance - amount;
	  
		  //add to the transaction list
		  ListOfAllTransactions.add(new Transaction("debit", amount));
	  
		  //update the last debit date
		  
		  lastDebitTime = getTransactionTime();
	  }	  
    else{
      sendWarning();
    }
  }

  public void CreditTransaction(int amount) {
    balance = balance + amount;

    ListOfAllTransactions.add(new Transaction("credit", amount));

    lastCreditTime = getTransactionTime();

  }
  
  // this method has a long method smell
  public void Transfer(int amount, ShootTheAccountPlus Benf) {
	  
	  if (!personalaccountexceed()) {
		  this.DebitTransaction(amount); 
		  
		  Benf.CreditTransaction(amount);
	  }
    else{
      sendWarning();
    }
  }
  
  private String getTransactionTime(){
    Calendar cal = Calendar.getInstance();
	  
	  lastTransactionTime = cal.get(Calendar.DATE) + "." + cal.get(Calendar.MONTH) + "." + cal.get(Calendar.YEAR);  

    return lastTransactionTime;
  }

  public void sendWarning() {
		  System.out.println("Balance must be more than 500, please deposit");
  }	  
  
  private boolean personalAccountExceed(){
    return accountType == "personal" && balance < 500;
  }
}                                                                                                                                                                                                       
