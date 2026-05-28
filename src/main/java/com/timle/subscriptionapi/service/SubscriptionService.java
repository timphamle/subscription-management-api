package com.timle.subscriptionapi.service;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.timle.subscriptionapi.model.Subscription;

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
}