package ru.example.coyul.single.responsibility;

import lombok.extern.slf4j.Slf4j;

/**
 * 1. Происходит модификация данных сразу сразу после их получения или при сохранении
 * 2. Возврат null заставляет клиента класса обрабатывать null кейсы
 * 3. Проброс широкого exception не дает возможность выше отследить, какиая именно ошибка происхошла. Клиенту класса остается привязываться к тексту
 *
 * Интуитивное описание:
 *
 * 1. А что если заголовок аккаунта нужно будет модифицировать, а я не хочу менять целый интерактор и его тесты? Почему именно на это уровне определяю заголовок по-умолчанию?
 * 2. Я возвращаю null, но это значит в классе выше это нужно проверить мне или коллегам. Какие варианты не возвращать?
 * 3. Я бросаю такую ошибку по которой можно подразумевать что угодно, единственный способ разобраться - читать сообщение об ошибке
 */
@Slf4j
public class AccountInteractor {

    private static final String DEFAULT_TITLE = "Накопительный счет";
    private final AccountRepository accountRepository;

    public AccountInteractor(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account fetchAccountInfo(Long id) throws AccountNotFoundException {
        Account account = null;
        try {
            AccountEntity accountEntity = accountRepository.findAccount(id);
            if (accountEntity.isActive()) {
                account = new Account();
                account.setTitle("Аккаунт: " + accountEntity.getTitle());
            }
        } catch (DatabaseException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException("Ошибка получения данных из базы данных!");
        }
        return account;
    }

    public void updateAccount(Account account) throws DatabaseException {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setTitle(account.getTitle() == null ? DEFAULT_TITLE : account.getTitle());
        accountRepository.save(accountEntity);
    }
}
