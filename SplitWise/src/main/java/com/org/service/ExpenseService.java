package com.org.service;

import com.org.dto.Transaction;
import com.org.models.Expense;
import com.org.models.ExpenseUser;
import com.org.models.Group;
import com.org.models.User;
import com.org.repository.ExpenseRepository;
import com.org.repository.ExpenseUserRepository;
import com.org.repository.GroupRepository;
import com.org.repository.UserRepository;
import com.org.strategies.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExpenseService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ExpenseUserRepository expenseUserRepository;
    @Autowired
    private SettleUpStrategy settleUpStrategy;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Transaction> settleUpUser(int userId) {
        /* Here the requirement is to Settle up the current user with All Other User*/

        /*
         * 1.  Get all the expenses which this user is part of.
         * 2. Iterate all the expenses and find out if money is lent and owed.
         * 3. use min -max algo to find the List of Transaction
         * 4. Return all the List<Transaction>
         */

        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            throw new RuntimeException();
        }

        // Since I want All the Expense which user is part of , We can get it from ExpenseUser table
        // (both Map, initially)

        List<ExpenseUser> expenseUsers = expenseUserRepository.findAllByUser(user.get());
        List<Expense> expenses = expenseUsers.stream().map(e -> e.getExpense()).collect(Collectors.toList());

        /*This List<Transaction> containing transaction for All the users*/
        List<Transaction> transactions = settleUpStrategy.settleUp(expenses);

        List<Transaction> thisUserTransactions = transactions.stream().filter(t -> t.getTo().getId() == userId || t.getFrom().getId() == userId)
                .collect(Collectors.toList());
        return thisUserTransactions;
    }

    public List<Transaction> settleUpGroup(int groupId) {


        /*
         * 1.  Get all the expenses which are part of this group.
         * 2. Iterate all the expenses and find out if money is lent and owed.
         * 3. use min -max algo to find the List of Transaction
         * 4. Return all the List<Transaction>
         */

        Optional<Group> group = groupRepository.findById(groupId);
        if (!group.isPresent()) {
            throw new RuntimeException();
        }

        List<Expense> allExpensesOfGroup = expenseRepository.findAllByGroup(group.get());
        // OR     List<Expense> expenses = group.get().getExpenses();

        List<Transaction> transactions = settleUpStrategy.settleUp(allExpensesOfGroup);
        return transactions;
    }
}
