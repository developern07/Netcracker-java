package Validators;

import Contracts.Contract;
import Contracts.ContractTV;
import Helpers.CheckStatus;
import Helpers.Message;

/**
 * Model TV validator
 * @see Validators.IValidator
 */
public class ValidatorTV implements IValidator{
    @Override
    public <T extends Contract> Message validate(T contract) {
        if (((ContractTV)contract).getPackageChannel().length <= 1){
            return new Message("Package channel", CheckStatus.ERROR);
        }
        return new Message("TV parameters of contract", CheckStatus.OK);
    }

    @Override
    public Class<?> getAppliableFor() {
        return ContractTV.class;
    }
}
