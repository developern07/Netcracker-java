package Validators;

import Contracts.Contract;
import Helpers.CheckStatus;
import Helpers.Message;

/**
 * Model human validator
 * @see Validators.IValidator
 */
public class ValidatorHuman implements IValidator{
    @Override
    public <T extends Contract> Message validate(T contract) {
        if (contract.getHuman().getNameHuman().length()<=0){
            return new Message("Name of human", CheckStatus.ERROR);
        }
        if (contract.getHuman().getAge()<18){
            return new Message("Age of human", CheckStatus.ERROR);
        }
        if (contract.getHuman().getSnPassport().length()<11){
            return new Message("Passport of human", CheckStatus.ERROR);
        }
        return new Message("Human", CheckStatus.OK);
    }

    @Override
    public Class<?> getAppliableFor() {
        return Contract.class;
    }
}
