package ch.schule.bank.junit5;

import ch.schule.SavingsAccount;



/**
 * Tests f�r die Klasse SavingsAccount.
 *
 * @author Roger H. J&ouml;rg
 * @version 1.0
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests für die Klasse SavingsAccount.
 *
 * @author XXX
 * @version 1.0
 */
class SavingsAccountTests
{
	@Test
    void test()
	{
		SavingsAccount savingsAccount = new SavingsAccount("1");
		assertFalse(savingsAccount.withdraw(12, 200));
	}
}

