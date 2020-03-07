package ru.example.coyul.single.responsibility.better;

import ru.example.coyul.single.responsibility.Account;
import ru.example.coyul.single.responsibility.AccountEntity;

public class AccountEntityConverter implements Converter<Account, AccountEntity> {
    @Override
    public AccountEntity convert(Account value) {
        return null;
    }
}
