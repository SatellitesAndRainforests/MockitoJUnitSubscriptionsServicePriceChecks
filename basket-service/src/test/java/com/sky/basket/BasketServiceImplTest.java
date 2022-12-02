package com.sky.basket;

import com.sky.subscription.SubscriptionService;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;



/**
 * @author Mark Start
 * @Date 02/12/2022
 */



@RunWith(MockitoJUnitRunner.class)
public class BasketServiceImplTest {

    @Mock private SubscriptionService subscriptionService;
    @InjectMocks private BasketServiceImpl basketServiceImpl = new BasketServiceImpl();
    private AutoCloseable autoCloseable;


    @BeforeEach
    public void setUp() {
        autoCloseable = MockitoAnnotations.openMocks( this );
    }

    @AfterEach
    public void tearDown() throws Exception {
        autoCloseable.close();
    }


    /**
     * Scenario tests:
     */


    @Test
    public void givenSingleENTERTAINMENTSubscription_whenCalculated_ThenReturnCorrectTotal(){

        // given
        List<String> subscriptions = new ArrayList<>();
        subscriptions.add("ENTERTAINMENT");
        BigDecimal entertainmentPrice = new BigDecimal( String.valueOf(9.99) ).setScale(2, RoundingMode.CEILING);


        // when
        when( subscriptionService.getSubscriptionPrice("ENTERTAINMENT") ).thenReturn( entertainmentPrice );
        BigDecimal result = basketServiceImpl.calculate( subscriptions );


        // then
        assertEquals( entertainmentPrice, result );


    }



    @Test(expected = BasketConditionNotMetException.class)
    public void givenPurchaseOfUnknownMOVIESubscription_whenSubscriptionPriceReturnsNull_thenThrow() {

        // given
        List<String> subscriptions = new ArrayList<>();
        subscriptions.add("MOVIES");

        // when
        when( subscriptionService.getSubscriptionPrice("MOVIES") ).thenReturn( null );
        basketServiceImpl.calculate(subscriptions);

        // then above error is thrown


    }



    @Test
    public void givenMultipleValidSubscriptions_whenCalculated_thenReturnCorrectTotal() {

        // given
        List<String> subscriptions = new ArrayList<>();
        subscriptions.add("ENTERTAINMENT");
        subscriptions.add("SPORTS");

        BigDecimal entertainmentPrice = new BigDecimal( String.valueOf(9.99) ).setScale(2, RoundingMode.CEILING);
        BigDecimal sportsPrice = new BigDecimal( String.valueOf(19.99) ).setScale(2, RoundingMode.CEILING);

        BigDecimal totalSubscriptionsPrice = entertainmentPrice.add( sportsPrice );


        // when
        when( subscriptionService.getSubscriptionPrice("ENTERTAINMENT") ).thenReturn( entertainmentPrice );
        when( subscriptionService.getSubscriptionPrice("SPORTS") ).thenReturn( sportsPrice );
        BigDecimal result = basketServiceImpl.calculate(subscriptions);


        // then
        assertEquals( totalSubscriptionsPrice, result );


    }





}





