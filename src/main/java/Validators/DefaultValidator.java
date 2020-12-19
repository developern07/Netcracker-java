package Validators;

import Contracts.Contract;
import Helpers.CheckStatus;
import Helpers.Message;

/**
 * Model default validator
 * @see Validators.IValidator
 */
public class DefaultValidator implements IValidator{

    @Override
    public <T extends Contract> Message validate(T contract) {
        if (contract.getID()<=0) {
            return new Message("ID contract", CheckStatus.ERROR);
        }
        if (contract.getStartDate().getYear() > contract.getEndDate().getYear() || contract.getStartDate().getYear() == contract.getEndDate().getYear() && contract.getStartDate().getDayOfYear() > contract.getEndDate().getDayOfYear()){
            return new Message("Date of contract", CheckStatus.ERROR);
        }
        return new Message("Default parameters of contract", CheckStatus.OK);
    }

    @Override
    public Class<?> getAppliableFor() {
        return Contract.class;
    }
}
