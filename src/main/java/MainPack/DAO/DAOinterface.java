package MainPack.DAO;

import MainPack.model.Account;
import MainPack.model.User;

import java.util.List;

public interface DAOinterface {
    User foundByID(int id);

    List<Account> allAccounts();
}

