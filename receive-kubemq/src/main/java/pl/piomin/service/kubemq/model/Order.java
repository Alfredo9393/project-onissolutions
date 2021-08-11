package pl.piomin.service.kubemq.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
public class Order implements Serializable {
//adap
//    private OrderType type;
    private String name;
    private String firstName;
    private String lastName;
    private String account;


//    private Integer accountIdFrom;
//    private Integer accountIdTo;
//    private LocalDateTime date;
//    private int amount;
    private String id;
    private OrderStatus status;

}
