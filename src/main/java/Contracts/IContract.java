package Contracts;

/**
 * Contract interface
 * @see Contract
 */
public interface IContract {
    int getID();
    void setID(int ID);
    Human getHuman();
    void setHuman(Human human);
}
