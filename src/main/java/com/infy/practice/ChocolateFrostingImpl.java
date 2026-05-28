package com.infy.practice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("choco")
public class ChocolateFrostingImpl implements Frosting{
    @Override
    public void getFrosting() {
        System.out.println("Adding Chocolate Frosting..");
    }
}
