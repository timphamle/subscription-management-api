package com.timle.subscriptionapi.controller;

import com.timle.subscriptionapi.model.Subscription;
import com.timle.subscriptionapi.model.PaymentMethod;
import com.timle.subscriptionapi.service.SubscriptionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController{
    private SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService){
        this.subscriptionService = subscriptionService;
    }

    // requests
    @GetMapping
    public List<Subscription> getAllSubscriptions(){
        return subscriptionService.getAllSubscriptions();
    }

    @PostMapping
    public void postSubscription(@RequestBody Subscription subscription){
        subscriptionService.addSubscription(subscription);
    }

    @GetMapping("/{id}")
    public Subscription getSubscriptionById(@PathVariable int id){
        return subscriptionService.getSubscriptionById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSubscriptionById(@PathVariable int id){
        subscriptionService.deleteSubscriptionById(id);
    }

    // request for payment method of a subscription
    @GetMapping("/{id}/payment-method")
    public PaymentMethod getPaymentMethodBySubscriptionId(@PathVariable int id){
        return subscriptionService.getPaymentMethodBySubscriptionId(id);
    }

    @PutMapping("/{id}/payment-method")
    public void setPaymentMethodBySubscriptionId(@PathVariable int id, @RequestBody PaymentMethod paymentMethod){
        subscriptionService.setPaymentMethodBySubscriptionId(id, paymentMethod);
    }

    @DeleteMapping("/{id}/payment-method")
    public void deletePaymentMethodBySubscriptionId(@PathVariable int id){
        subscriptionService.deletePaymentMethodBySubscriptionId(id);
    }
}