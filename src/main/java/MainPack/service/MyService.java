package MainPack.service;

import MainPack.DAO.*;
import MainPack.model.User;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class MyService {

    DAOAccount da = new DAOAccount();
    DAOuser du = new DAOuser();

    @Bean
    public MyService ms() {
        return new MyService();
    }

    public String displayAll() {
        String output = "";
        List<User> varList = du.findAll();
        for (int i = 0; i < varList.size(); i++) {
            output += varList.get(i).toString() + "\n";
        }
        return output;
    }

    public String showRichest() {
        String out = da.findRichest();
        return out;
    }

    public String bankSumm() {
        return da.totalBank();
    }

    public String findById(String id) {
        try {
            int outID = Integer.parseInt(id);
            return du.foundByID(outID).toString();
        } catch (ArithmeticException ex) {
            System.out.println("Эксептиона арифметик каст то инт : \n" + ex.getMessage());
        }
        return null;
    }

}
