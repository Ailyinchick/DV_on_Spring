package MainPack.service;

import MainPack.DAO.*;
import MainPack.model.User;

import java.util.List;

public class MyService {
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
        String out = da.findRichest().toString();
        return out;
    }

    public String bankSumm() {
        String out = "";
        out += da.totalBank();
        return out;
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

    public List listAll() {
        return du.findAll();
    }
}
