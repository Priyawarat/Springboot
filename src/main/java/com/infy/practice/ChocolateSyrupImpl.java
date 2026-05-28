package com.infy.practice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("choco")
public class ChocolateSyrupImpl implements Syrup{
    @Override
    public void getSyrup() {
        System.out.println("Adding Chocolate Syrup..");
    }
}
