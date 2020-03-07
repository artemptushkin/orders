package ru.example.coyul.single.responsibility.better;

import ru.example.coyul.single.responsibility.Account;
import ru.example.coyul.single.responsibility.AccountNotFoundException;

public interface AccountInteractor {
    Account fetchAccountInfo(Long id) throws AccountNotFoundException;
    void updateAccount(Account account);
}
