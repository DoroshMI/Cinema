package ua.lviv.cinema.editor;

import ua.lviv.cinema.entity.Address;
import ua.lviv.cinema.entity.Cinema;

import java.beans.PropertyEditorSupport;

/**
 * Created by User on 25.05.2017.
 */
public class AddressEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String idAddressFromJSP) throws IllegalArgumentException {
        System.out.println("EDITOR : "+ idAddressFromJSP);
        Address address = new Address();
        address.setId(Integer.parseInt(idAddressFromJSP));

        setValue(address);
    }
}
