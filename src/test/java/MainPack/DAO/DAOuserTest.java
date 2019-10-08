package MainPack.DAO;

import MainPack.service.MyService;
import org.junit.Assert;
import org.junit.Test;

public class DAOuserTest {
    DAOuser us = new DAOuser();
    MyService ms = new MyService();

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


    @Test
    public void findRichest() {
        System.out.println(ms.showRichest());
    }

    @Test
    public void msSumm() {
        System.out.println(ms.bankSumm());
    }

}