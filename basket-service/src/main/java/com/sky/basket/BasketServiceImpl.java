package com.sky.basket;

import com.sky.subscription.SubscriptionService;

import java.math.BigDecimal;
import java.util.List;



public class BasketServiceImpl implements BasketService {


    private SubscriptionService subscriptionService;


    public BigDecimal calculate( List<String> subscriptions ) throws BasketConditionNotMetException {


        BigDecimal total = BigDecimal.ZERO;

        for ( String s: subscriptions ) {

            BigDecimal subscriptionPrice = subscriptionService.getSubscriptionPrice(s);

            if (subscriptionPrice == null) throw new BasketConditionNotMetException( "subscriptionService returned null" );

            total = total.add( subscriptionService.getSubscriptionPrice(s) );


        }

        return total;


    }










}




