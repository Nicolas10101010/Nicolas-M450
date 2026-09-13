package ch.tbz.m450.junit5;

import ch.tbz.m450.controller.AddressController;
import ch.tbz.m450.repository.*;
import ch.tbz.m450.service.AddressService;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AddressServiceTests {
    private Address address;
    private AddressRepository addressRepository;
    private AddressService addressService;
    private AddressController addressController;

    @BeforeEach
    void setUp() {
        addressRepository = mock(AddressRepository.class);
        addressService = new AddressService(addressRepository);
        addressController = new AddressController(addressService);

        address = new Address();
        address.setId(1);
        address.setFirstname("John");
        address.setLastname("Doe");
        address.setPhonenumber("123456789");
    }

    @Test
    void createAddress() {
        assertEquals(1, address.getId());
        assertEquals("John", address.getFirstname());
        assertEquals("Doe", address.getLastname());
        assertEquals("123456789", address.getPhonenumber());
    }

    @Test
    void getAddress() {
        when(addressRepository.findById(1)).thenReturn(Optional.of(address));

        assertEquals(address, addressService.getAddress(1).get());
    }

    @Test
    void getAddressList() {
        var address2 = new Address();
        address2.setId(2);
        address2.setFirstname("Anna");
        address2.setLastname("Meier");
        var address3 = new Address();
        address3.setId(3);
        address3.setFirstname("Peter");
        address3.setLastname("Berger");

        var addressList = List.of(address, address2, address3);
        when(addressRepository.findAll()).thenReturn(addressList);

        var expected = List.of(address3, address, address2);
        assertEquals(expected, addressService.getAll());
    }

    @Test
    void saveAddress() {
        when(addressRepository.save(address)).thenReturn(address);
        assertEquals(address, addressService.save(address));
    }
}