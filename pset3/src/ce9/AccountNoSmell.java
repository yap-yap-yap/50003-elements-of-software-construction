import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

class Transaction {
	private String type;
	private int amount;
	
	public Transaction (String newType, int newAmount) {
		this.type = newType;
		this.amount = newAmount;
	}
}


public class AccountNoSmell {
  private int balance = 0;
  private List<Transaction> ListOfAllTransactions = new ArrayList<Transaction>();
  private String lastDebitTime;
  private String lastCreditTime;
  
  public AccountNoSmell () {
  }

  public AccountNoSmell (int balance) {
    this.balance = balance;
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
	  //reduce the amount
	  balance = balance - amount;
	  
	  //add to the transaction list
	  ListOfAllTransactions.add(new Transaction("debit", amount));
	  
	  //update the last debit date
    lastDebitTime = getTransactionTime();
	  
  }

  public void CreditTransaction(int amount) {
    balance = balance + amount;

    ListOfAllTransactions.add(new Transaction("crebit", amount));

    lastCrebitTime = getTransactionTime();

  }

  private String getTransactionTime(){
    Calendar cal = Calendar.getInstance();
	  
	  lastTransactionTime = cal.get(Calendar.DATE) + "." + cal.get(Calendar.MONTH) + "." + cal.get(Calendar.YEAR);  

    return lastTransactionTime;
  }
}                                                                                                                                                                                                       
