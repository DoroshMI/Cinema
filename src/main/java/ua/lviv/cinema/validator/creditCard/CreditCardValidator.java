package ua.lviv.cinema.validator.creditCard;

import org.springframework.stereotype.Component;
import ua.lviv.cinema.entity.CreditCard;
import ua.lviv.cinema.validator.Validator;

import java.time.YearMonth;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component("creditCardValidator")
public class CreditCardValidator implements Validator {



    @Override
    public void validator(Object o) throws CreditCardDTOException {

        CreditCard creditCard = (CreditCard) o;

        if ((creditCard.getAccountNumber() == null) || "".equals(creditCard.getAccountNumber())) {
            throw new CreditCardDTOException(CreditCardValidatorMessages.EMPTY_ACOUNT_NUMBER);
        } else if (!checkWithRegExpAccountNumber(creditCard.getAccountNumber())) {
            throw new CreditCardDTOException(CreditCardValidatorMessages.INCORRECT_ACOUNT_NUMBER);
        } else  if ((creditCard.getSecurityCode() == null) || "".equals(creditCard.getSecurityCode())) {
            throw new CreditCardDTOException(CreditCardValidatorMessages.EMPTY_SECURITY_CODE);
        } else if (!checkWithRegExpSecurityCode(creditCard.getSecurityCode())) {
            throw new CreditCardDTOException(CreditCardValidatorMessages.INCORRECT_SECURITY_CODE);
        }  if (creditCard.getExpirationYearMonth() == null ) {
            throw new CreditCardDTOException(CreditCardValidatorMessages.EMPTY_EXPIRATION_YEAR_MONTH);
        } else if (creditCard.getExpirationYearMonth().isBefore(YearMonth.now())) {
            throw new CreditCardDTOException(CreditCardValidatorMessages.INCORRECT_ACOUNT_NUMBER);
        }

    }

    private static boolean checkWithRegExpAccountNumber(String accountNumber){
        Pattern p = Pattern.compile("^[0-9-]{12,12}$");
        Matcher m = p.matcher(accountNumber);

        if(accountNumber.length() != 12) {return false;}

        return m.matches();
    }

    private static boolean checkWithRegExpSecurityCode(String securityCode){
        Pattern p = Pattern.compile("^[0-9]{3,3}$");
        Matcher m = p.matcher(securityCode);

        if(securityCode.length() != 3) {return false;}
        return m.matches();
    }

}
