package pl.piomin.service.kubemq.service;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.piomin.service.kubemq.exception.InsufficientFundsException;
import pl.piomin.service.kubemq.model.Order;
import pl.piomin.service.kubemq.model.OrderStatus;
import pl.piomin.service.kubemq.repository.AccountRepository;

@Service
public class OrderProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProcessor.class);

    private AccountRepository accountRepository;

    public OrderProcessor(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Order process(Order order) {
        try {
            if(order.getAccount().length()==10 && order.getAccount()!=""){
                System.out.println("Cuenta valida "+ order.getAccount());

                System.out.println("select data from account where F1 = " +order.getAccount());
                Order ord = accountRepository.getDataAccount(order.getAccount());

                if(order.getAccount().equals("0100002392")){
                    System.out.println("Peticion realizada con exito");
                }else{
                    System.out.println("Cuenta no existe "+order.getAccount() );
                }
                ord.setAccount(order.getAccount());
                order = ord;
            }else{
                System.out.println("Falled - Ingresar una cuenta valida");
            }
            order.setStatus(OrderStatus.CONFIRMED);
        } catch (InsufficientFundsException e) {
            order.setStatus(OrderStatus.REJECTED);
        }
        return order;
    }
   
}
