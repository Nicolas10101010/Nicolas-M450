package ch.schule.bank.junit5;

import ch.schule.Account;
import ch.schule.SalaryAccount;
import ch.schule.SavingsAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests für die Klasse Account.
 *
 * @author xxxx
 * @version 1.0
 */
class AccountTests {
    /**
     * Tested die Initialisierung eines Kontos.
     */

    private Account account;

    @BeforeEach
    void setUp() {
        account = new SavingsAccount("1");
    }

    @Test
    void testInit() {
        assertEquals("1", account.getId());
    }

    /**
     * Testet das Einzahlen auf ein Konto.
     */
    @Test
    void testDeposit() {
        assertTrue(account.deposit(12, 13));
    }

    /**
     * Testet das Abheben von einem Konto.
     */
    @Test
    public void testWithdraw() {
        account.deposit(12, 13);
        assertTrue(account.withdraw(12, 13));
    }

    /**
     * Tests the reference from SavingsAccount
     */
    @Test
    public void testReferences() {
        fail("toDo");
    }

    /**
     * teste the canTransact Flag
     */
    @Test
    public void testCanTransact() {
        fail("toDo");
    }

    /**
     * Experimente mit print().
     */
    @Test
    public void testPrint() {
        fail("toDo");
    }

    /**
     * Experimente mit print(year,month).
     */
    @Test
    public void testMonthlyPrint() {
        fail("toDo");
    }

}
