package Contracts;

import java.time.LocalDate;

/**
 * TV contract model
 * @see Contract
 */
public class ContractTV extends Contract implements IContract {

    /**
     * Method of getting amount of channels
     * @return aChannel
     */
    public int getaChannel() {
        return aChannel;
    }

    /**
     * Method of setting amount of channels
     * @param aChannel
     */
    public void setaChannel(int aChannel) {
        this.aChannel = aChannel;
    }

    protected int aChannel;

    protected String[] packageChannel;

    /**
     * Method of getting amount of channels
     * @return packageChannel
     */
    public String[] getPackageChannel() {
        return packageChannel;
    }

    /**
     * Method of setting amount of channels
     * @param packageChannel
     */
    public void setPackageChannel(String[] packageChannel) {
        this.packageChannel = packageChannel;
    }

    /**
     * Constructor TV contract
     * @param id
     * @param startDate
     * @param endDate
     * @param numberOfContract
     * @param human
     * @param aChannel
     * @param packageChannel
     */
    public ContractTV(int id, LocalDate startDate, LocalDate endDate, int numberOfContract, Human human, int aChannel, String[] packageChannel) {
        super(id, startDate, endDate, numberOfContract, human);
        setaChannel(aChannel);
        setPackageChannel(packageChannel);
    }
}
