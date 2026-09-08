package ch.schule.bank.junit5;

import ch.schule.Bank;
import ch.schule.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests für die Klasse Booking.
 *
 * @author Luigi Cavuoti
 * @version 1.1
 */
class BookingTests
{

	private Booking booking;

	@BeforeEach
	void init(){
		booking = new Booking(12, 200);
	}

	/**
	 * Tests f�r die Erzeugung von Buchungen.
	 */
	@Test
	void testInitialization()
	{
		assertNotNull(booking);
	}

	/**
	 * Experimente mit print().
	 */
	@Test
	public void testPrint()
	{
		fail("toDo");
	}
}
