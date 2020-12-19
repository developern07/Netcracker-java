package Validators;

import Contracts.Contract;
import Contracts.ContractEthernet;
import Helpers.CheckStatus;
import Helpers.Message;

/**
 * Model ethernet validator
 * @see Validators.IValidator
 */
public class ValidatorEthernet implements IValidator{
    @Override
    public <T extends Contract> Message validate(T contract) {
        if (((ContractEthernet)contract).getSpeedConnection() <= 0){
            return new Message("Speed connection", CheckStatus.ERROR);
        }
        return new Message("Ethernet parameters of contract", CheckStatus.OK);
    }

    @Override
    public Class<?> getAppliableFor() {
        return ContractEthernet.class;
    }
}
