package ru.example.coyul.single.responsibility.better;

import ru.example.coyul.single.responsibility.Account;
import ru.example.coyul.single.responsibility.AccountEntity;

public class AccountConverter implements Converter<AccountEntity, Account> {
    @Override
    public Account convert(AccountEntity value) {
        return null;
    }
}
