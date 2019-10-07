package net.proselyte.springmvc.DAO;

import org.junit.Assert;
import org.junit.Test;

public class DAOuserTest {
    DAOuser us = new DAOuser();


    @Test
    public void findAll() {
        System.out.println(us.findAll());
    }

    @Test
    public void foundByID() {
        Assert.assertEquals("Akim", us.foundByID(3).getName());
    }


 @Test
    public void testUser() {
     System.out.println(us.testUser("Mike").getName());
    }
}