package ua.lviv.cinema.validator.address;

import org.springframework.stereotype.Component;

import ua.lviv.cinema.entity.Address;

import ua.lviv.cinema.validator.Validator;


@Component
public class AddressValidator implements Validator {

	@Override
	public void validator(Object o) throws Exception {

		Address address  = (Address) o;

		if ( (address.getAddressLine() == null) || (address.getAddressLine() == "") || (address.getAddressLine().length() == 0) ) {
			throw new Exception(AddressValidatorMessages.EMPTY_ADDRESSLINE_FIELD);
		}else if ((address.getCity() == null) || (address.getCity() == "")  || (address.getCity().length() == 0)) {
			throw new AddressException(AddressValidatorMessages.EMPTY_CITY_FIELD);
		}else if ((address.getState() == null) || (address.getState() == "")  || (address.getState().length() == 0)) {
			throw new AddressException(AddressValidatorMessages.EMPTY_STATE_FIELD);
		}else if ((address.getZipcode() == null) || (address.getZipcode() == "")  || (address.getZipcode().length() == 0)) {
			throw new AddressException(AddressValidatorMessages.EMPTY_ZIPCODE_FIELD);
		}else if ((address.getCountry() == null)  || (address.getCountry().name().length() == 0)) {
			throw new AddressException(AddressValidatorMessages.EMPTY_COUNTRY_FIELD);
		}

	}

}
