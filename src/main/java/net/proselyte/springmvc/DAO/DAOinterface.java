package net.proselyte.springmvc.DAO;

import net.proselyte.springmvc.model.Account;
import net.proselyte.springmvc.model.User;

import java.util.List;

public interface DAOinterface {
    User foundByID(int id);

    List<Account> allAccounts();
}

