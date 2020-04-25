package com.example.parking.model;

import com.example.parking.util.Credits;

import org.junit.Assert;
import org.junit.Test;

public class CreditsTest {
    @Test
    public void addCreditsTest(){
        Credits c = new Credits();
        c.addCredits(10);
        Assert.assertEquals(10,c.getPoints());
    }

    @Test
    public void removeValidCreditsTest(){
        Credits c = new Credits();
        c.addCredits(10);
        c.removeCredits(5);
        Assert.assertEquals(5,c.getPoints());
    }

    @Test
    public void removeInvalidCreditsTest(){
        Credits c = new Credits();
        c.addCredits(10);
        c.removeCredits(11);
        Assert.assertEquals(10,c.getPoints());
    }
}