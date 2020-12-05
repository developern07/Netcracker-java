package Contracts;

import java.time.LocalDate;

/**
 * Mobile contract model
 * @see Contract
 */
public class ContractMobile extends Contract implements IContract {

    /**
     * Method of getting amount of sms
     * @return aSms
     */
    public int getaSms() {
        return aSms;
    }

    /**
     * Method of setting amount of sms
     * @param aSms
     */
    public void setaSms(int aSms) {
        this.aSms = aSms;
    }

    protected int aSms;

    /**
     * Method of getting amount of minutes
     * @return aMinutes
     */
    public int getaMinutes() {
        return aMinutes;
    }

    /**
     * Method of setting amount of minutes
     * @param aMinutes
     */
    public void setaMinutes(int aMinutes) {
        this.aMinutes = aMinutes;
    }

    protected int aMinutes;

    /**
     * Method of getting amount of gb traffic
     * @return gbTraffic
     */
    public int getGbTraffic() {
        return gbTraffic;
    }

    /**
     * Method of setting amount of gb traffic
     * @param gbTraffic
     */
    public void setGbTraffic(int gbTraffic) {
        this.gbTraffic = gbTraffic;
    }

    protected int gbTraffic;

    /**
     * Constructor Mobile contract
     * @param id
     * @param startDate
     * @param endDate
     * @param numberOfContract
     * @param human
     * @param aSms
     * @param aMinutes
     * @param gbTraffic
     */
    public ContractMobile(int id, LocalDate startDate, LocalDate endDate, int numberOfContract, Human human, int aSms, int aMinutes, int gbTraffic) {
        super(id, startDate, endDate, numberOfContract, human);
        setaSms(aSms);
        setaMinutes(aMinutes);
        setGbTraffic(gbTraffic);
    }

}
