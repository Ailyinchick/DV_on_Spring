package MainPack.service;

import MainPack.DAO.*;
import MainPack.model.User;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {

    @Bean
    public MyService getMyService() {
        return new MyService();
    }

    DAOAccount da = new DAOAccount();
    DAOuser du = new DAOuser();

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
