package Contracts;

import java.time.LocalDate;

/**
 * Contract model
 */

public class Contract implements IContract {

    /**
     * Method of getting Contract ID
     * @return ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Method of setting Contract ID
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Contract ID
     */
    protected int ID;

    /**
     * Method of getting Human
     * @return human
     */
    public Human getHuman() {
        return human;
    }

    /**
     * Method of setting Human
     * @param human
     */
    public void setHuman(Human human) {
        this.human = human;
    }

    /**
     * Contract owner
     */
    protected Human human;

    /**
     * Method of getting Date of start Contract
     * @return startDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Method of setting Date of start Contract
     * @param startDate
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * Date of start contract
     */
    protected LocalDate startDate;

    /**
     * Method of getting Date of end Contract
     * @return endDate
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Method of setting Date of end Contract
     * @param endDate
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * Date of end contract
     */
    protected LocalDate endDate;

    /**
     * Method of getting number of contract
     * @return numberOfContract
     */
    public int getNumberOfContract() {
        return numberOfContract;
    }

    /**
     * Method of setting number of contract
     * @param numberOfContract
     */
    public void setNumberOfContract(int numberOfContract) {
        this.numberOfContract = numberOfContract;
    }

    /**
     * Number of contract
     */
    protected int numberOfContract;

    /**
     * Constructor Contracts.Contract
     * @param id
     * @param startDate
     * @param endDate
     * @param numberOfContract
     * @param human
     */
    public Contract(int id, LocalDate startDate, LocalDate endDate, int numberOfContract, Human human) {
        setID(id);
        setStartDate(startDate);
        setEndDate(endDate);
        setNumberOfContract(numberOfContract);
        setHuman(human);
    }
}

