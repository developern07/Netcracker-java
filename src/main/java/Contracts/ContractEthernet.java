package Contracts;

import java.time.LocalDate;

/**
 * Ethernet Contracts.Contract model
 * @see Contract
 */
public class ContractEthernet extends Contract implements IContract {

    /**
     * Method of getting speed connection
     * @return speedConnection
     */
    public int getSpeedConnection() {
        return speedConnection;
    }

    /**
     * Method of setting speed connection
     * @param speedConnection
     */
    public void setSpeedConnection(int speedConnection) {
        this.speedConnection = speedConnection;
    }

    /**
     * Speed connection
     */
    protected int speedConnection;

    /**
     * Constructor Contracts.Contract Ethernet
     * @param id
     * @param startDate
     * @param endDate
     * @param numberOfContract
     * @param human
     * @param speed
     */
    public ContractEthernet(int id, LocalDate startDate, LocalDate endDate, int numberOfContract, Human human, int speed) {
        super(id, startDate, endDate, numberOfContract, human);
        setSpeedConnection(speed);
    }
}
