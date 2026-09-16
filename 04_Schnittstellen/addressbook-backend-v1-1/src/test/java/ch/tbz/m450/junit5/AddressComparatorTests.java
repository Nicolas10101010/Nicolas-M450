package ch.tbz.m450.junit5;

import ch.tbz.m450.repository.Address;
import ch.tbz.m450.util.AddressComparator;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddressComparatorTests {
    private AddressComparator comparator;
    private Address address1;
    private Address address2;
    private Address address3;
    private Address address4;
    private List<Address> addressList;
    private List<Address> correctAddressList;

    @BeforeEach
    void setUp() {
        comparator = new AddressComparator();

        address1 = new Address();
        address1.setFirstname("David");
        address1.setLastname("Meier");

        address2 = new Address();
        address2.setFirstname("Anna");
        address2.setLastname("Meier");

        address3 = new Address();
        address3.setFirstname("Bob");
        address3.setLastname("Meier");

        address4 = new Address();
        address4.setFirstname("Chelsea");
        address4.setLastname("Meier");

        addressList = new ArrayList<>();
        addressList.add(address1);
        addressList.add(address3);
        addressList.add(address4);
        addressList.add(address2);

        correctAddressList = List.of(address2, address3, address4, address1);
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

    @Test
    void addressListCorrectSort(){
        addressList.sort(comparator);

        assertEquals(correctAddressList, addressList);
    }
}