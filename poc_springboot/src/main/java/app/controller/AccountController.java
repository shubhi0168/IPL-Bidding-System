package app.controller;

import app.model.Account;

import app.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/getonaccno")
    public Account getAccountDetailsonAccno(@RequestParam("x") int accno)
    {
        Account a = accountService.getAccountDetailsonAccno(accno);
        return a;
    }
    /*
        @GetMapping("/getbalanceonaccno")
        public List<Integer> getAccountBalanceonAccno(@RequestParam("x") int accno)
        {
            List<Integer> l = accountService.getAccountBalanceonAccno(accno);
            return l;
        }*/

    @GetMapping("/getonbalance")
    public List<Account> getAccountDetailsnoonBalance(@RequestParam("x") int balance)
    {
        List<Account> l = accountService.getAccountDetailsonBalance(balance);
        return l;
    }
}
