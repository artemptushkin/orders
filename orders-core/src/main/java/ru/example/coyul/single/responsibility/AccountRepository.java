package ru.example.coyul.single.responsibility;

public class AccountRepository {
    public AccountEntity findAccount(Long id) throws AccountNotFoundException, DatabaseException {
        return null;
    }

    public void save(AccountEntity accountEntity) throws DatabaseException {

    }
}
