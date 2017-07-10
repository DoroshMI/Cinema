package ua.lviv.cinema.dto;

import java.time.YearMonth;

/**
 * Created by n.dorosh on 06.07.2017.
 */
public class CreditCardDTO {

    private String accountNumberI;
    private String accountNumberII;
    private String accountNumberIII;
    private String accountNumberIV;

    private String expirationYear;
    private String expirationMonth;

    private String securityCode;

    public CreditCardDTO() {
    }

    public CreditCardDTO(String accountNumberI, String accountNumberII, String accountNumberIII, String accountNumberIV, String expirationYear, String expirationMonth, String securityCode) {
        this.accountNumberI = accountNumberI;
        this.accountNumberII = accountNumberII;
        this.accountNumberIII = accountNumberIII;
        this.accountNumberIV = accountNumberIV;
        this.expirationYear = expirationYear;
        this.expirationMonth = expirationMonth;
        this.securityCode = securityCode;
    }

    public String getAccountNumberI() {
        return accountNumberI;
    }

    public void setAccountNumberI(String accountNumberI) {
        this.accountNumberI = accountNumberI;
    }

    public String getAccountNumberII() {
        return accountNumberII;
    }

    public void setAccountNumberII(String accountNumberII) {
        this.accountNumberII = accountNumberII;
    }

    public String getAccountNumberIII() {
        return accountNumberIII;
    }

    public void setAccountNumberIII(String accountNumberIII) {
        this.accountNumberIII = accountNumberIII;
    }

    public String getAccountNumberIV() {
        return accountNumberIV;
    }

    public void setAccountNumberIV(String accountNumberIV) {
        this.accountNumberIV = accountNumberIV;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    @Override
    public String toString() {
        return "CreditCardDTO{" +
                "accountNumberI='" + accountNumberI + '\'' +
                ", accountNumberII='" + accountNumberII + '\'' +
                ", accountNumberIII='" + accountNumberIII + '\'' +
                ", accountNumberIV='" + accountNumberIV + '\'' +
                ", expirationYear='" + expirationYear + '\'' +
                ", expirationMonth='" + expirationMonth + '\'' +
                ", securityCode='" + securityCode + '\'' +
                '}';
    }
}
