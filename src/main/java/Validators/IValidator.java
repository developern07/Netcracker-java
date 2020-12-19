package Validators;

import Contracts.Contract;
import Helpers.Message;

/**
 * Interface validator
 */
public interface IValidator {
    /**
     * Method of getting result of check
     * @param contract
     * @param <T>
     * @return Message
     */
    public <T extends Contract> Message validate(T contract);

    /**
     * Method of getting class
     * @return *.class
     * @throws ClassNotFoundException
     */
    public Class<?> getAppliableFor() throws ClassNotFoundException;
}
