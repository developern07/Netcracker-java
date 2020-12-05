package Contracts;

import java.time.LocalDate;

/**
 * Contracts.Contract model
 */

public class Contract implements IContract {

    /**
     * Method of getting Contracts.Contract ID
     * @return ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Method of setting Contracts.Contract ID
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    protected int ID;

    /**
     * Method of getting Contracts.Human
     * @return human
     */
    public Human getHuman() {
        return human;
    }

    /**
     * Method of setting Contracts.Human
     * @param human
     */
    public void setHuman(Human human) {
        this.human = human;
    }

    protected Human human;

    /**
     * Method of getting Date of start Contracts.Contract
     * @return startDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Method of setting Date of start Contracts.Contract
     * @param startDate
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    protected LocalDate startDate;

    /**
     * Method of getting Date of end Contracts.Contract
     * @return endDate
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Method of setting Date of end Contracts.Contract
     * @param endDate
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

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
