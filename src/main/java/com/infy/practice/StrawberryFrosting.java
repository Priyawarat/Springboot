package com.infy.practice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("berry")
public class StrawberryFrosting implements Frosting{
    @Override
    public void getFrosting() {
        System.out.println("Adding Strawberry Frosting..");
    }
}
