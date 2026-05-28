package com.timle.subscriptionapi.service;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.timle.subscriptionapi.model.Subscription;
import com.timle.subscriptionapi.model.PaymentMethod;

@Service
public class SubscriptionService{

    private List<Subscription> subscriptions = new ArrayList<>();

    // methods
    public List<Subscription> getAllSubscriptions(){
        return subscriptions;
    }

    public void addSubscription(Subscription subscription){
        subscriptions.add(subscription);
    }

    public Subscription getSubscriptionById(int id){
        for (Subscription subscription : subscriptions){
            if (subscription.getId() == id) {
                return subscription;
            }
        }
        return null;
    }

    public void deleteSubscriptionById(int id){
        for (Subscription subscription : subscriptions){
            if (subscription.getId() == id) {
                subscriptions.remove(subscription);
                break;
            }
        }
    }

    // methods for payment method of a subscription
    public PaymentMethod getPaymentMethodBySubscriptionId(int id){
        Subscription subscription = getSubscriptionById(id);
        if (subscription != null) {
            return subscription.getPaymentMethod();
        }
        return null;
    }

    public void setPaymentMethodBySubscriptionId(int id, PaymentMethod paymentMethod){
        Subscription subscription = getSubscriptionById(id);
        if (subscription != null) {
            subscription.setPaymentMethod(paymentMethod);
        }
    }

    public void deletePaymentMethodBySubscriptionId(int id){
        Subscription subscription = getSubscriptionById(id);
        if (subscription != null) {
            subscription.setPaymentMethod(null);
        }
    }
}