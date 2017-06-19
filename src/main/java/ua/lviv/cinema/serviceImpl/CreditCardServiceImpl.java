/**
 *  EJB 3 in Action
 *  Book: http://manning.com/panda2/
 *  Code: http://code.google.com/p/action-bazaar/
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package ua.lviv.cinema.serviceImpl;

import org.springframework.stereotype.Service;
import ua.lviv.cinema.entity.CreditCard;
import ua.lviv.cinema.service.CreditCardService;
import ua.lviv.cinema.validator.creditCard.CreditProcessingException;

import java.math.BigDecimal;

@Service
public class CreditCardServiceImpl implements CreditCardService {


    @Override
    public void chargeCreditCard(CreditCard creditCard, BigDecimal amount) throws CreditProcessingException {

    }

    @Override
    public void validateCard(CreditCard creditCard) {

    }
}
