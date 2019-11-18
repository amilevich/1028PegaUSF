package Project0BankAccountM.Project0BankAccountM;

import java.io.Serializable;

public class AccountInfo implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5148755356042047206L;
	private int m_nAccountNumber;
	private short m_nFlags;
	
	private String m_fname1;
	private String m_fname2;
	private String m_lname1;
	private String m_lname2;
	private transient int m_nSSN1;		
	private transient int m_nSSN2;
	
	// In cents to avoid rounding errors
	private long m_nSavingBalance;
	private long m_nCheckBalance;
	private long m_nLoanBalance;
	
	// maybe remove these?
//	private String m_accountName1;
//	private String m_accountName2;
//	private String m_password1;
//	private String m_password2;

	public AccountInfo()
	{
		m_nAccountNumber = 0;
		m_nFlags = 0;
		m_nSavingBalance = 0;
		m_nCheckBalance = 0;
		m_nLoanBalance = 0;
		
		m_fname1 = new String("");
		m_fname2 = new String("");
		m_lname1 = new String("");
		m_lname2 = new String("");
		m_nSSN1 = 0;		
		m_nSSN2 = 0;
//		m_accountName1 = new String("");
//		m_accountName2 = new String("");
//		m_password1 = new String("");
//		m_password2 = new String("");
	}
	
	public static enum FLAGS
	{
		FROZEN,
		JOINT,
		CLOSED,
		PENDING,
		APPROVED,
		DENIED;
	}
	
	public void displayInfo()
	{
		System.out.println("Account Number: " + m_nAccountNumber + "\nName: " + m_fname1 + " " + m_lname1 + "\nSSN:" + m_nSSN1);
		if(getFlag(FLAGS.JOINT))
		{
			System.out.println("Joint Name: " + m_fname2 + " " + m_lname1 + "\nJoint SSN: " + m_nSSN2);
		}
		//Check status
		if(!getFlag(FLAGS.FROZEN))
		{
			if(getFlag(FLAGS.APPROVED))
			{
				if(m_nSavingBalance > 0)
					System.out.println("Saving Balance: " + m_nSavingBalance);
				if(m_nCheckBalance > 0)
					System.out.println("Checking Balance: " + m_nCheckBalance);
				if(m_nLoanBalance > 0)
					System.out.println("LoanBalance" + m_nLoanBalance);
			}
			else if(getFlag(FLAGS.PENDING))
			{
				System.out.println("Account is still pending approval");
			}
			else if(getFlag(FLAGS.DENIED))
			{
				System.out.println("Account has been denied. Plase call (123) 123-4567 for details");
			}
			else if(getFlag(FLAGS.CLOSED))
			{
				System.out.println("Account has been closed by account holder. Plase call (123) 123-4567 for details");
			}
		}
		else
			System.out.println("Account has been frozen. Plase call (123) 123-4567 ext 123");
	}

	@Override
	public String toString() {
		return "AccountInfo [Account Number: " + m_nAccountNumber + 
				", Name: " + m_fname1 + " " + m_lname1 +
				", Social Security Number:" + m_nSSN1 + ", " + 
				", Joint Name: " + m_fname2 + " " + m_lname2 + 
				", Joint Social Security Number: " + m_nSSN2 + 
				/*", Account User Name: "	+ m_accountName1 + 
				", Password: " + m_password1 + 
				", Joint User Name" + m_accountName2 +
				", Joint Account Password" + m_password2 +*/ 
				", Saving: " + m_nSavingBalance +
				", Checking: " + m_nCheckBalance + 
				", Loan Total: " + m_nLoanBalance + ", m_nFlags=" + m_nFlags +"]";
	}


	// Accessors/Getters
	public String getLastName2() 
	{
		return m_lname2;
	}

	public String getFirstName1() 
	{
		return m_fname1;
	}

	public String getFirstName2() 
	{
		return m_fname2;
	}
	public String getLastName1() 
	{
		return m_lname1;
	}

	public double getSaveBalance()
	{
		double dAmount = ((double)m_nSavingBalance)/100;
		return dAmount;
	}
	
	public double getCheckBalance()
	{
		double dAmount = ((double)m_nCheckBalance)/100;
		return dAmount;
	}
	
	public double getLoanBalance()
	{
		double dAmount = ((double)m_nLoanBalance)/100;
		return dAmount;
	}

	public boolean getFlag(FLAGS _flag)
	{
		int bit = getFlagBit(_flag);
		return (0 != (m_nFlags & (1<<bit)));
	}
	
	public int getAccountNumber()
	{
		return m_nAccountNumber;
	}
/*	
	public String getUserName1()
	{
		return m_accountName1;
	}
	public String getUserName2()
	{
		return m_accountName2;
	}
*/	
	public int getSSN1()
	{
		return m_nSSN1;
	}
			
	public int getSSN2()
	{
		return m_nSSN2;
	}
	
	// Mutators
	public void setFirstName1(String _fname1) {
		this.m_fname1 = _fname1;
	}

	public void setLastName1(String _lname1) {
		this.m_lname1 = _lname1;
	}

	public void setLastName2(String _lname2) {
		this.m_lname2 = _lname2;
	}

	public void setFirstName2(String _fname2) {
		this.m_fname2 = _fname2;
	}

	public void setAccountNumber(int _accNum)
	{
		m_nAccountNumber = _accNum;
	}
	
	public void setSSN1(int _nSSN)
	{
		m_nSSN1 = _nSSN;
	}
	
	public void setSSN2(int _nSSN)
	{
		m_nSSN2 = _nSSN;
	}

	public void setFlag(FLAGS _flag, boolean _bOn)
	{
		int bit = getFlagBit(_flag);
		if(_bOn)
		{
			m_nFlags |= 1<<bit;
		}
		else 
			m_nFlags &= ~(1<<bit); 
}

	public void depositSave(double _dAmount)
	{
		if(!isAccountActive())
			System.out.println("ERROR: Account not active. Plase call (123) 123-4567 for details");

			//TODO: add Id checking
		if (_dAmount < 0)
		{
			//error message and exit
			System.out.println("Error: Can't deposit a negative amount");
			return;
		}
		
		long nDepositAmount = (long)(_dAmount * 100);
//		System.out.println("Desposit Amount: " + nDepositAmount);
		// check for overflow
		if(m_nSavingBalance + nDepositAmount >= m_nSavingBalance)
			m_nSavingBalance += nDepositAmount;
		else
			System.out.println("Error: System unable to handle that much money(max amount: $92,233,720,368,547,758.07");
	}
	
	public void depositCheck(double _dAmount)
	{
		if(!isAccountActive())
			System.out.println("ERROR: Account not active. Plase call (123) 123-4567 for details");

			//TODO: add Id checking
		if (_dAmount < 0)
		{
			//error message and exit
			System.out.println("Error: Can't deposit a negative amount");
			return;
		}
		
		long nDepositAmount = (long)(_dAmount * 100);
//		System.out.println("Desposit : " + nDepositAmount);
		// check for overflow
		if(m_nCheckBalance + nDepositAmount >= m_nCheckBalance)
			m_nCheckBalance += nDepositAmount;
		else
			System.out.println("Error: System unable to handle that much money(max amount: $92,233,720,368,547,758.07");
	}
	
	public void withdrawSave(double _dAmount)
	{
		if(!isAccountActive())
			System.out.println("ERROR: Account not active. Plase call (123) 123-4567 for details");
		//TODO: add Id checking
		if (_dAmount < 0)
		{
			//error message and exit
			System.out.println("Error: Can't withdraw a negative amount");
			return;
		}
		
		long nWithAmount = (long)(_dAmount * 100);
//		System.out.println("Change amount: " + nWithAmount);
		if (m_nSavingBalance - nWithAmount >= 0)
			m_nSavingBalance -= nWithAmount;
		else
			System.out.println("Error: lack of funds to complete transaction");

	}

	public void withdrawCheck(double _dAmount)
	{
		if(!isAccountActive())
			System.out.println("ERROR: Account not active. Plase call (123) 123-4567 for details");
		//TODO: add Id checking
		if (_dAmount < 0)
		{
			//error message and exit
			System.out.println("Error: Can't withdraw a negative amount");
			return;
		}
		
		long nWithAmount = (long)(_dAmount * 100);
//		System.out.println("Change amount: " + nWithAmount);
		if (m_nCheckBalance - nWithAmount >= 0)
			m_nCheckBalance -= nWithAmount;
		else
			System.out.println("Error: lack of funds to complete transaction");

	}

	// Transfer money between accounts within the bank.
	// Must be two different accounts and the money amount must be valid
	public void transferFromSave(double _dAmount, int _nTargetAccount)
	{
		if(_nTargetAccount != m_nAccountNumber)
		{
			// Error check amount
			if(!isAccountActive())
				System.out.println("ERROR: Account not active. Plase call (123) 123-4567 for details");
			else if(_dAmount < 0)
				System.out.println("ERROR: You can not transfer a negative amount of money");
			else if (_dAmount >= getSaveBalance())
				System.out.println("ERROR: That is more money then is in the account");
			
			// Check if target account is valid and active
			
			// Transfer money to target account
		}
		else
			System.out.println("ERROR: you are trying to transfer money from this account to this account");
	}
	
	// Transfer money between accounts within the bank
	public void transferToSave(double _dAmount, int _nTargetAccount)
	{
		if(_nTargetAccount != m_nAccountNumber)
		{
			
		}
		else
			System.out.println("ERROR: you are trying to transfer money to this account from this account");
	}
	
/*	
	public Boolean logIn(String _name, String _password)
	{
		return ((_name.contentEquals(m_accountName1) && _password.contentEquals(m_password1))) || 
					((_name.contentEquals(m_accountName2) && _password.contentEquals(m_password2)));
	}
	
*/	
	private int getFlagBit(FLAGS _flag)
	{
		int bit = 0;
		switch(_flag)
		{
			case FROZEN:
				bit = 1;
			break;

			case JOINT:
				bit = 2;
			break;
			
			case CLOSED:
				bit = 3;
			break;
			
			case PENDING:
				bit = 4;
			break;
			
			case APPROVED:
				bit = 5;
			break;
			
			case DENIED:
				bit = 6;
			break;
			
			default:
				System.out.println("ERROR: invalid flag");
			break;
		}
		return bit;
	}
	
	// Check if this account is opened, approved and not frozen
	public boolean isAccountActive()
	{
		if(getFlag(FLAGS.FROZEN) || getFlag(FLAGS.CLOSED) || getFlag(FLAGS.PENDING) || getFlag(FLAGS.DENIED))
			return false;
		return true;
	}
}
