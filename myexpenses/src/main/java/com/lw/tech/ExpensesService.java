package com.lw.tech;
import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;
@ApplicationScoped
public class ExpensesService {

    Set<Expenses> expenses= Collections.newSetFromMap(Collections.synchronizedMap(new HashMap<>()));

    public Set<Expenses> list(){
        return expenses;
    }
    public Expenses create(Expenses expense){
        expenses.add(expense);
        return expense;
    }

    public boolean delete(UUID uuid)
    {
        return expenses.removeIf(expenses-> expenses.getUuid().equals(uuid));
    }


    public void update(Expenses expense)
    {
        delete(expense.getUuid());
        create(expense);
    }
}
