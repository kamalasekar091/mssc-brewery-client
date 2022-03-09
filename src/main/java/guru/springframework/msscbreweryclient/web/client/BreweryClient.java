package guru.springframework.msscbreweryclient.web.client;


import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.Customer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;
//sfg.brewery
@ConfigurationProperties(prefix="sfg.brewery", ignoreUnknownFields = false)
@Component
public class BreweryClient {

    public final String BEER_PATH_V1="/api/v1/beer/";

    public final String CUSTOMER_PATH_V1="/api/v1/customer/";

    public String apihost;

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID beerId){
        return restTemplate.getForObject(apihost+BEER_PATH_V1+beerId.toString(),BeerDto.class);
    }

    public URI saveNewBeer(BeerDto beerDto){
        return restTemplate.postForLocation(apihost+BEER_PATH_V1,beerDto);
    }

    public void updateBeer(UUID beerId,BeerDto beerDto){
        restTemplate.put(apihost + BEER_PATH_V1 + beerId.toString(), beerDto);
    }

    public void deleteBeer(UUID beerId){
        restTemplate.delete(apihost+BEER_PATH_V1+beerId.toString());
    }

    public Customer getCustomerById(UUID custId){
        return restTemplate.getForObject(apihost+CUSTOMER_PATH_V1+custId.toString(),Customer.class);
    }

    public URI saveNewCust(Customer customer){
        return restTemplate.postForLocation(apihost+CUSTOMER_PATH_V1,customer);
    }

    public void updateCust(UUID custId,Customer customer){
        restTemplate.put(apihost+CUSTOMER_PATH_V1+custId.toString(),customer);
    }

    public void deleteCustomer(UUID custId){
        restTemplate.delete(apihost+CUSTOMER_PATH_V1+custId.toString());
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}
