package app.service;

import app.dao.AccountRepository;
import app.model.Account;
import app.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account getAccountDetailsonAccno(int accno) {

        Account a = new Account();
        Optional<Account> o = accountRepository.findById(accno);
        if(o.isPresent())
        {
            a = o.get();
        }
        return a;
    }
    /*
        public List<Integer> getAccountBalanceonAccno(int accno) {

            List<Integer> accountBal = a.getonaccno(accno);
            return accountBal;
        }*/

    public List<Account> getAccountDetailsonBalance(int balance) {
        List<Account> accountNo = accountRepository.getonbalance(balance);
        return accountNo;
    }
}
