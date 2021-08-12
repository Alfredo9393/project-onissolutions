package pl.piomin.service.kubemq.repository;

import org.springframework.stereotype.Repository;
import pl.piomin.service.kubemq.exception.InsufficientFundsException;
import pl.piomin.service.kubemq.model.Order;

@Repository
public class AccountRepository {

    public Order getDataAccount(String account) throws InsufficientFundsException {
        System.out.println("select data from account where F1 = " +account);
        Order order =  Order.builder().name("MARCELI ELIZABETH").lastName("ROMERO").firstName("MORENO").build();
        return order;    
    }
}
