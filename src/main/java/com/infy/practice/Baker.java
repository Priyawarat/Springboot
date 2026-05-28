package com.infy.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Baker {
    private final Syrup syrup;
    private final Frosting frosting;

    @Autowired
    public Baker(@Qualifier("choco") Syrup syrup, @Qualifier("berry") Frosting frosting) {
        this.syrup = syrup;
        this.frosting = frosting;
    }

    public void bakeCake()
    {
        System.out.println("Starting baking the cake..");
        frosting.getFrosting();
        syrup.getSyrup();
        System.out.println("Cake is Ready");
    }
}
