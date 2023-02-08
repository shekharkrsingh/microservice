
package com.lw.tech;
import javax.json.bind.annotation.JsonbCreator;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Expenses {

    enum PaymentMethod{
        CASH, CREDIT_CARD, DEBIT_CARD;
    }

    private String name;
    private BigDecimal amount;
    private LocalDateTime creationDate;
    private PaymentMethod paymentMethod;
    private UUID uuid;

    public Expenses(String name, BigDecimal amount, LocalDateTime creationDate, PaymentMethod paymentMethod, UUID uuid) {
        this.name = name;
        this.amount = amount;
        this.creationDate = creationDate;
        this.paymentMethod = paymentMethod;
        this.uuid = uuid;
    }

    public Expenses(String name, BigDecimal amount, PaymentMethod paymentMethod) {
        this.name = name;
        this.amount = amount;
        this.creationDate = LocalDateTime.now();
        this.paymentMethod = paymentMethod;
        this.uuid = UUID.randomUUID() ;
    }

    @JsonbCreator
    public static Expenses of(String name, BigDecimal amount, PaymentMethod paymentMethod) {
        return new Expenses(name, amount, paymentMethod);
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
    public UUID getUuid() {
        return uuid;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

}