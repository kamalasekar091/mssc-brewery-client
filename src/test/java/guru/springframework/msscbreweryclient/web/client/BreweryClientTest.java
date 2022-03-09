package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;


    @Test
    void getBeerById() {
        BeerDto beerDto= breweryClient.getBeerById(UUID.randomUUID());

        assertNotNull(beerDto);
    }

    @Test
    void testSaveBeer(){
        BeerDto beerDto = BeerDto.builder().beerName("King King").build();
        assertNotNull(breweryClient.saveNewBeer(beerDto));
    }

    @Test
    void testUpdateBeer(){
        BeerDto beerDto = BeerDto.builder().beerName("King King").build();
        breweryClient.updateBeer(UUID.randomUUID(),beerDto);
    }

    @Test
    void testDeleteBeer(){
        breweryClient.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomerById() {
        Customer customer = breweryClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customer);
    }

    @Test
    void saveNewBeer() {
        Customer customer=Customer.builder().name("Jaya").build();

        assertNotNull(breweryClient.saveNewCust(customer));
    }

    @Test
    void updateBeer() {
        Customer customer=Customer.builder().name("Jaya").build();

        breweryClient.updateCust(UUID.randomUUID(),customer);
    }

    @Test
    void deleteCustomer() {

        breweryClient.deleteCustomer(UUID.randomUUID());
    }
}