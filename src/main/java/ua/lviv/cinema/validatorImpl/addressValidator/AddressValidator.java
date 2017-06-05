package ua.lviv.cinema.validatorImpl.addressValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.lviv.cinema.entity.Address;

import ua.lviv.cinema.validator.Validator;


@Component
public class AddressValidator implements Validator {

	@Override
	public void validator(Object o) throws AddressException {

		Address address  = (Address) o;

		if ((address.getAddressLine() == null) || (address.getAddressLine() == "")) {
			throw new AddressException(AddressValidatorMessages.EMPTY_ADDRESSLINE_FIELD);
		}else if ((address.getCity() == null) || (address.getCity() == "")) {
			throw new AddressException(AddressValidatorMessages.EMPTY_CITY_FIELD);
		}else if ((address.getState() == null) || (address.getState() == "")) {
			throw new AddressException(AddressValidatorMessages.EMPTY_STATE_FIELD);
		}else if ((address.getZipcode() == null) || (address.getZipcode() == "")) {
			throw new AddressException(AddressValidatorMessages.EMPTY_ZIPCODE_FIELD);
		}else if ((address.getCountry() == null)) {
			throw new AddressException(AddressValidatorMessages.EMPTY_COUNTRY_FIELD);
		}

		
	}

}
