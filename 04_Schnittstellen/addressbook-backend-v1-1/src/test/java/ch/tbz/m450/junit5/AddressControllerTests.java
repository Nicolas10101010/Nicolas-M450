package ch.tbz.m450.junit5;

import ch.tbz.m450.controller.AddressController;
import ch.tbz.m450.repository.Address;
import ch.tbz.m450.service.AddressService;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AddressControllerTests {
    private Address address;
    private AddressService addressService;
    private AddressController addressController;

    @BeforeEach
    void setUp() {
        addressService = mock(AddressService.class);
        addressController = new AddressController(addressService);

        address = new Address();
        address.setId(1);
        address.setFirstname("John");
        address.setLastname("Doe");
    }

    @Test
    void createAddress() {
        when(addressService.save(address)).thenReturn(address);

        var response = addressController.createAddress(address);

        assertEquals(201, response.getStatusCode().value());
        assertEquals(address, response.getBody());
    }

    @Test
    void getAddresses() {
        when(addressService.getAll()).thenReturn(List.of(address));

        var response = addressController.getAddresses();

        assertEquals(200, response.getStatusCode().value());
        assertEquals(List.of(address), response.getBody());
    }

    @Test
    void getAddress() {
        when(addressService.getAddress(1)).thenReturn(Optional.of(address));

        var response = addressController.getAddress(1);

        assertEquals(200, response.getStatusCode().value());
        assertEquals(address, response.getBody());
    }

    @Test
    void getAddressNotFound() {
        when(addressService.getAddress(99)).thenReturn(Optional.empty());

        var response = addressController.getAddress(99);

        assertEquals(404, response.getStatusCode().value());
    }
}