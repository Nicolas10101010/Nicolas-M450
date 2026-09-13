package ch.tbz.m450.junit5;

import ch.tbz.m450.repository.Address;
import ch.tbz.m450.util.AddressComparator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class AddressComparatorTests {
    private AddressComparator comparator;
    private Address address1;
    private Address address2;

    @BeforeEach
    void setUp() {
        comparator = new AddressComparator();

        address1 = new Address();
        address1.setFirstname("John");
        address1.setLastname("Doe");

        address2 = new Address();
        address2.setFirstname("Anna");
        address2.setLastname("Meier");
    }

    @Test
    void compareByLastname() {
        assertTrue(comparator.compare(address1, address2) < 0);
        assertTrue(comparator.compare(address2, address1) > 0);
    }

    @Test
    void compareSameAddress() {
        assertEquals(0, comparator.compare(address1, address1));
    }

    @Test
    void compareByFirstnameWhenLastnameIsSame() {
        address2.setLastname("Doe");

        assertTrue(comparator.compare(address2, address1) < 0);
        assertTrue(comparator.compare(address1, address2) > 0);
    }
}