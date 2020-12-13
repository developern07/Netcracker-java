package Repository;

import Contracts.Contract;
import Contracts.ContractEthernet;
import Contracts.ContractMobile;
import Contracts.ContractTV;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Repository model
 */
public class Repository {
    /**
     * array of contracts
     */
    protected Contract[] array;

    /**
     * Constructor repository
     */
    public Repository() {
        this.array = new Contract[0];
    }

    /**
     * Method of add contract in Repository
     * @param element
     * @param <T>
     */
    public <T extends Contract> void add(T element) {
        this.array = Arrays.copyOf(array, array.length + 1);
        this.array[array.length - 1] = element;
    }

    /**
     * Method of getting all contracts from repository
     * @param <T>
     * @return
     */
    public <T extends Contract> T[] getAll() { return (T[])array; }

    /**
     * Method of getting contract from repository by ID
     * @param id
     * @param <T>
     * @return
     */
    public <T extends Contract> T get(int id) {
        for (int i=0; i < array.length; i++){
            if (array[i].getID()==id) {
                return (T) array[i];
            }
        }
        return null;
    }

    /**
     * Method of delete contract from repository by ID
     * @param id
     */
    public void remove(int id) {
        if (id > 0 && id <= array.length) {
            for (int i=0; i < array.length; i++){
                if (array[i].getID()==id){
                    array[i] = null;
                    for (int y = i; y < array.length - 1; ++y) {
                        array[y] = array[y + 1];
                    }
                    this.array = Arrays.copyOf(array, array.length - 1);
                    break;
                }
            }
        }
    }

    /**
     * Method of print contract by id
     * @param id
     */
    public void PrintArrayByID(int id){
        int i=-1;
        for (int y=0; y < array.length; y++){
            if (array[y].getID()==id)
                i=y;
        }
        if(i>-1) {
            if (array[i] instanceof ContractEthernet) {
                System.out.println("Ethernet Contract:\n ID: " + array[i].getID() + ", date of start - date of end contract: " + array[i].getStartDate() + " - " + array[i].getEndDate() + "\n Name of Human: " + array[i].getHuman().getNameHuman() + ", Age: " + array[i].getHuman().getAge() + ", Passport: " + array[i].getHuman().getSnPassport() + "\n Speed Connection: " + ((ContractEthernet) array[i]).getSpeedConnection());
            } else if (array[i] instanceof ContractMobile) {
                System.out.println("Mobile Contract:\n ID: " + array[i].getID() + ", date of start - date of end contract: " + array[i].getStartDate() + " - " + array[i].getEndDate() + "\n Name of Human: " + array[i].getHuman().getNameHuman() + ", Age: " + array[i].getHuman().getAge() + ", Passport: " + array[i].getHuman().getSnPassport() + "\n Amount of SMS: " + ((ContractMobile) array[i]).getaSms() + ", amount of Minutes: " + ((ContractMobile) array[i]).getaMinutes() + ", amount of Gb Traffic: " + ((ContractMobile) array[i]).getGbTraffic());
            } else if (array[i] instanceof ContractTV) {
                System.out.println("TV Contract:\n ID: " + array[i].getID() + ", date of start - date of end contract: " + array[i].getStartDate() + " - " + array[i].getEndDate() + "\n Name of Human: " + array[i].getHuman().getNameHuman() + ", Age: " + array[i].getHuman().getAge() + ", Passport: " + array[i].getHuman().getSnPassport() + "\n Channels: " + Arrays.toString(((ContractTV) array[i]).getPackageChannel()));
            }
        }
    }

    /**
     * Method of print array of contracts
     * @param elements
     */
    public void PrintContracts(Contract[] elements){
        for (int i=0; i<elements.length; i++){
            if (elements[i] instanceof ContractEthernet) {
                System.out.println("Ethernet Contract:\n ID: " + elements[i].getID() + ", date of start - date of end contract: " + elements[i].getStartDate() +" - "+ elements[i].getEndDate() + "\n Name of Human: " + elements[i].getHuman().getNameHuman()+", Age: "+ elements[i].getHuman().getAge()+", Passport: "+elements[i].getHuman().getSnPassport() + "\n Speed Connection: " + ((ContractEthernet) elements[i]).getSpeedConnection());
            } else if (elements[i] instanceof ContractMobile) {
                System.out.println("Mobile Contract:\n ID: " + elements[i].getID() + ", date of start - date of end contract: " + elements[i].getStartDate() +" - "+ elements[i].getEndDate() + "\n Name of Human: " + elements[i].getHuman().getNameHuman()+", Age: "+ elements[i].getHuman().getAge()+", Passport: "+elements[i].getHuman().getSnPassport() +  "\n Amount of SMS: " + ((ContractMobile) elements[i]).getaSms()+", amount of Minutes: "+((ContractMobile) elements[i]).getaMinutes()+", amount of Gb Traffic: "+((ContractMobile) elements[i]).getGbTraffic());
            } else if (elements[i] instanceof ContractTV) {
                System.out.println("TV Contract:\n ID: " + elements[i].getID() + ", date of start - date of end contract: " + elements[i].getStartDate() +" - "+ elements[i].getEndDate() + "\n Name of Human: " + elements[i].getHuman().getNameHuman()+", Age: "+ elements[i].getHuman().getAge()+", Passport: "+elements[i].getHuman().getSnPassport() +  "\n Channels: " + Arrays.toString(((ContractTV) elements[i]).getPackageChannel()));
            }
        }
    }

    /**
     * Method of find contract in repository
     * @param filter
     * @param <T>
     * @return
     */
    public <T extends Contract> T[] findElements(Predicate<T> filter){
        Contract[] elements = new Contract[0];
        int j=0;
        boolean bool=false;
        for (int i=0; i < array.length; i++){
            if (this.array[i] != null && filter.test((T)array[i])){
                bool = true;
                elements = Arrays.copyOf(elements, j+1);
                elements[j] = array[i];
                j++;
            }
        }
        if (bool){
            if (j>1){
                System.out.println("Found " + j + " contracts");}
            if (j==1){
                System.out.println("Found " + j + " contract");
            }
            return (T[]) elements;
        }
        else {
            System.out.println("Contracts not found");
        }
        return (T[]) elements;
    }
}