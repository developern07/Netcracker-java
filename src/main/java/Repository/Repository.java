package Repository;

import Contracts.Contract;
import Contracts.ContractEthernet;
import Contracts.ContractMobile;
import Contracts.ContractTV;

import javax.management.relation.RelationTypeNotFoundException;
import java.util.Arrays;

public class Repository {
    protected Contract[] array;

    public Repository() {
        this.array = new Contract[0];
    }

    public <T extends Contract> void add(T element) {
        this.array = Arrays.copyOf(array, array.length + 1);
        this.array[array.length - 1] = element;
    }

    public <T extends Contract> T get(int id) {
        for (int i=0; i < array.length; i++){
            if (array[i].getID()==id) {
                return (T) array[i];
            }
        }
        return null;
    }

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
}