package ua.lviv.cinema.validator.creditCard;

import org.springframework.stereotype.Component;
import ua.lviv.cinema.dto.CreditCardDTO;
import ua.lviv.cinema.entity.CreditCard;
import ua.lviv.cinema.validator.Validator;

import java.time.YearMonth;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component("creditCardDTOValidator")
public class CreditCardDTOValidator implements Validator {



    @Override
    public void validator(Object o) throws CreditCardDTOException {

        CreditCardDTO creditCardDTO = (CreditCardDTO) o;
        System.out.println(   (creditCardDTO.getAccountNumberI() == null) || "".equals(creditCardDTO.getAccountNumberI()));
        if ((creditCardDTO.getAccountNumberI() == null) || "".equals(creditCardDTO.getAccountNumberI())) {
            throw new CreditCardDTOException(CreditCardDTOValidatorMessages.EMPTY_ACOUNT_NUMBER_I);
        } else if ((creditCardDTO.getAccountNumberI() == null) || "".equals(creditCardDTO.getAccountNumberII())) {
            throw new CreditCardDTOException(CreditCardDTOValidatorMessages.EMPTY_ACOUNT_NUMBER_II);
        } else if ((creditCardDTO.getAccountNumberI() == null) || "".equals(creditCardDTO.getAccountNumberIII())) {
            throw new CreditCardDTOException(CreditCardDTOValidatorMessages.EMPTY_ACOUNT_NUMBER_III);
        } else if ((creditCardDTO.getAccountNumberI() == null) || "".equals(creditCardDTO.getAccountNumberIV())) {
            throw new CreditCardDTOException(CreditCardDTOValidatorMessages.EMPTY_ACOUNT_NUMBER_IV);
        } else if ((creditCardDTO.getSecurityCode() == null) || "".equals(creditCardDTO.getSecurityCode())) {
            throw new CreditCardDTOException(CreditCardValidatorMessages.EMPTY_SECURITY_CODE);
        } else  if (creditCardDTO.getExpirationYear() == null || "null".equals(creditCardDTO.getExpirationYear() )) {
            throw new CreditCardDTOException(CreditCardDTOValidatorMessages.EMPTY_EXPIRATION_YEAR);
        }else  if (creditCardDTO.getExpirationMonth() == null || "null".equals(creditCardDTO.getExpirationMonth() )) {
            throw new CreditCardDTOException(CreditCardDTOValidatorMessages.EMPTY_EXPIRATION_MONTH);
        }

    }



}
