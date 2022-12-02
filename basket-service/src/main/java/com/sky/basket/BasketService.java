package com.sky.basket;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Mark Start
 * @Date 02/12/2022
 */
public interface BasketService {

    public BigDecimal calculate(List<String> subscriptions) throws BasketConditionNotMetException;



}
