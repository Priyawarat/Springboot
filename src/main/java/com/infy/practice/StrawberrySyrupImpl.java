package com.infy.practice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("berry")
public class StrawberrySyrupImpl implements Syrup{
    @Override
    public void getSyrup() {
        System.out.println("Adding Strawberry Syrup..");
    }
}
