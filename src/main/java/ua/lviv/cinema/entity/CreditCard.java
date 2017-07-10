package ua.lviv.cinema.entity;

import java.io.Serializable;
import java.time.YearMonth;
import javax.persistence.*;
import javax.validation.constraints.*;


//import javax.validation.constraints.DecimalMax;
//import javax.validation.constraints.DecimalMin;
//import javax.validation.constraints.Digits;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import com.actionbazaar.account.BillingInfo;
//import com.actionbazaar.util.CreditCardCheck;

/**
 * Encapsulates information about a credit card.
 * @author Ryan Cuprak
 */
@Entity

public class CreditCard implements Serializable {

    /**
     * Credit card identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    /**
     * Account number
     */
    private String accountNumber;

    /**
     * Expiration month on the card
     */
    private YearMonth expirationYearMonth;


    /**
     * Security code appear on the back of the card
     */

    private String securityCode;

    /**
     * Type of the credit card
     */
    @Enumerated(EnumType.STRING)
    private CreditCardType creditCardType;

    /**
     * Default constructor
     */
    public CreditCard() {
        // Default Constructor
    }

    public CreditCard(String accountNumber, YearMonth expirationYearMonth, String securityCode, CreditCardType creditCardType) {
        this.accountNumber = accountNumber;
        this.expirationYearMonth = expirationYearMonth;
        this.securityCode = securityCode;
        this.creditCardType = creditCardType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public YearMonth getExpirationYearMonth() {
        return expirationYearMonth;
    }

    public void setExpirationYearMonth(YearMonth expirationYearMonth) {
        this.expirationYearMonth = expirationYearMonth;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public CreditCardType getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(CreditCardType creditCardType) {
        this.creditCardType = creditCardType;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", expirationYearMonth=" + expirationYearMonth +
                ", securityCode='" + securityCode + '\'' +
                ", creditCardType=" + creditCardType +
                '}';
    }
}