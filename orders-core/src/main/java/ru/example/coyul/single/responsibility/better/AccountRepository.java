package ru.example.coyul.single.responsibility.better;

import ru.example.coyul.single.responsibility.AccountEntity;
import ru.example.coyul.single.responsibility.AccountNotFoundException;

public class AccountRepository {
    public AccountEntity findAccount(Long id) throws AccountNotFoundException {
        return null;
    }

    public void save(AccountEntity accountEntity) {

    }
}
