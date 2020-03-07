package ru.example.coyul.single.responsibility.better;

import ru.example.coyul.single.responsibility.Account;
import ru.example.coyul.single.responsibility.AccountEntity;
import ru.example.coyul.single.responsibility.AccountNotFoundException;

public class DefaultAccountInteractor implements AccountInteractor {
    private final AccountRepository accountRepository;
    private final Converter<AccountEntity, Account> converter;
    private final Converter<Account, AccountEntity> accountEntityConverter;

    public DefaultAccountInteractor(AccountRepository accountRepository, Converter<AccountEntity, Account> converter, Converter<Account, AccountEntity> accountEntityConverter) {
        this.accountRepository = accountRepository;
        this.converter = converter;
        this.accountEntityConverter = accountEntityConverter;
    }

    @Override
    public Account fetchAccountInfo(Long id) throws AccountNotFoundException {
        AccountEntity accountEntity = accountRepository.findAccount(id);
        return converter.convert(accountEntity);
    }

    @Override
    public void updateAccount(Account account) {
        accountRepository.save(
                accountEntityConverter.convert(account)
        );
    }
}
