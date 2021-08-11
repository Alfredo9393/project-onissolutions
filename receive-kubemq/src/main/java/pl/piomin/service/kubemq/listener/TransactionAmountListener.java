package pl.piomin.service.kubemq.listener;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.net.ssl.SSLException;

import io.grpc.stub.StreamObserver;
import io.kubemq.sdk.basic.ServerAddressNotSuppliedException;
import io.kubemq.sdk.event.EventReceive;
import io.kubemq.sdk.event.Subscriber;
import io.kubemq.sdk.subscription.EventsStoreType;
import io.kubemq.sdk.subscription.SubscribeRequest;
import io.kubemq.sdk.subscription.SubscribeType;
import io.kubemq.sdk.tools.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.piomin.service.kubemq.model.Order;

import org.springframework.stereotype.Component;

@Component
public class TransactionAmountListener implements StreamObserver<EventReceive> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionAmountListener.class);

    private Subscriber subscriber;

    public TransactionAmountListener(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public void onNext(EventReceive eventReceive) {
        try {
            Order order = (Order) Converter.FromByteArray(eventReceive.getBody());
            LOGGER.info("Receive event: {}", order);
        } catch (IOException | ClassNotFoundException  e) {
            LOGGER.error("Error", e);
        }
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onCompleted() {

    }

    @PostConstruct
    public void init() {
        SubscribeRequest subscribeRequest = new SubscribeRequest();
        subscribeRequest.setChannel("transactions");
        subscribeRequest.setClientID("amount-listener");
        subscribeRequest.setSubscribeType(SubscribeType.EventsStore);
        subscribeRequest.setEventsStoreType(EventsStoreType.StartNewOnly);
        try {
            subscriber.SubscribeToEvents(subscribeRequest, this);
        } catch (ServerAddressNotSuppliedException | SSLException e) {
            e.printStackTrace();
        }
    }
}
