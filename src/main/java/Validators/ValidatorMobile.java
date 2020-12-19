package Validators;

import Contracts.Contract;
import Contracts.ContractMobile;
import Helpers.CheckStatus;
import Helpers.Message;

/**
 * Model mobile validator
 * @see Validators.IValidator
 */
public class ValidatorMobile implements IValidator{

    @Override
    public <T extends Contract> Message validate(T contract) {
        if (((ContractMobile)contract).getaSms() < 0){
            return new Message("Amount of sms", CheckStatus.ERROR);
        }
        if (((ContractMobile)contract).getaMinutes() < 0){
            return new Message("Amount of minutes", CheckStatus.ERROR);
        }
        if (((ContractMobile)contract).getGbTraffic() < 0){
            return new Message("Amount of gb traffic", CheckStatus.ERROR);
        }
        return new Message("Mobile parameters of contract", CheckStatus.OK);
    }

    @Override
    public Class<?> getAppliableFor() {
        return ContractMobile.class;
    }
}
