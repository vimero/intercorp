package io.vimero.intercorp.service;

import io.architecture.response.ResponseACK;
import io.architecture.response.ResponseList;
import io.vimero.intercorp.api.data.CustomerData;
import io.vimero.intercorp.api.resource.AgeKPIResource;
import io.vimero.intercorp.api.resource.CustomerResource;
import io.vimero.intercorp.entity.Customer;
import io.vimero.intercorp.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.stream.Collectors.toList;

/**
 * @author Rony Villanueva <rony@vimero.io>
 * @since 15/12/2019
 */

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public ResponseACK save(CustomerData data){
        Customer entity = new Customer();
        entity.setFirstName(data.getFirstName());
        entity.setLastName(data.getLastName());
        entity.setDateBirthday(LocalDate.parse(data.getDateBirthday()));
        entity.setAge(data.getAge());
        entity.setDateCreated(LocalDateTime.now());
        entity.setDateDeath(getDateDeath(data.getAge()));
        customerRepository.save(entity);

        return new ResponseACK();
    }

    public CustomerResource findById(String id){
        Optional<Customer> entity = customerRepository.findById(id);
        if( entity.isPresent() ){
            return new CustomerResource(
                    entity.get().getId(),
                    entity.get().getFirstName(),
                    entity.get().getLastName(),
                    entity.get().getAge(),
                    entity.get().getDateBirthday().toString(),
                    entity.get().getDateDeath().toString(),
                    entity.get().getDateCreated().toString(),
                    entity.get().getDateUpdated() != null ? entity.get().getDateUpdated().toString() : "");
        }else{
            return  null;
        }
    }

    public ResponseList<CustomerResource> getList(){
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResource> list = customers.stream().map(
                customer -> new CustomerResource(
                        customer.getId(),
                        customer.getFirstName(),
                        customer.getLastName(),
                        customer.getAge(),
                        customer.getDateBirthday().toString(),
                        customer.getDateDeath().toString(),
                        customer.getDateCreated().toString(),
                        customer.getDateUpdated() != null ? customer.getDateUpdated().toString() : "")).collect(toList());

        return new ResponseList<>(list);
    }

    public AgeKPIResource getKPI(){
        List<Customer> customers = customerRepository.findAll();
        IntSummaryStatistics statistics = customers.stream().mapToInt( (x)-> x.getAge()).summaryStatistics();
        List<Integer> list = customers.stream().map( x -> x.getAge()).collect(toList());
        return new AgeKPIResource(statistics.getAverage(),
                calculate(list.stream().toArray(Integer[]::new), statistics.getAverage()));
    }

    public static double calculate(Integer[] v, double average) {
        double sum = 0; int i, n = v.length;

        for ( i = 0; i < n; i++ )
            sum += Math.pow ( v [ i ] - average, 2 );

        return Math.sqrt ( sum / ( double ) n );
    }

    private LocalDate getDateDeath(Integer age){
        long minDay = LocalDate.now().toEpochDay();
        long maxDay = LocalDate.now().toEpochDay() + delta(age);
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        return randomDate;
    }

    private int delta(Integer age){
        return BigInteger.TEN.
                multiply(BigInteger.TEN).
                multiply(BigInteger.TEN).
                multiply(BigInteger.TEN).
                multiply(BigInteger.TEN).
                divide(new BigInteger(age.toString())).intValue();
    }
}
