package Repository;

import Contracts.Contract;
import Contracts.ContractEthernet;
import Contracts.ContractMobile;
import Contracts.ContractTV;

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

    public <T extends Contract> T get(int i) {
        return (T) array[i];
    }

    public void remove(int index) {
        if (index >= 0 && index < array.length) {
            array[index] = null;
            for (int i = index; i < array.length - 1; ++i) {
                array[i] = array[i + 1];
            }
            this.array = Arrays.copyOf(array, array.length - 1);
        }
    }
    public void PrintArray(int i){
        if (array[i] instanceof ContractEthernet) {
            System.out.println("Ethernet Contract:\n ID: " + array[i].getID() + ", date of start - date of end contract: " + array[i].getStartDate() +" - "+ array[i].getEndDate() + "\n Name of Human: " + array[i].getHuman().getNameHuman()+", Age: "+ array[i].getHuman().getAge()+", Passport: "+array[i].getHuman().getSnPassport() + "\n Speed Connection: " + ((ContractEthernet) array[i]).getSpeedConnection());
        } else if (array[i] instanceof ContractMobile) {
            System.out.println("Mobile Contract:\n ID: " + array[i].getID() + ", date of start - date of end contract: " + array[i].getStartDate() +" - "+ array[i].getEndDate() + "\n Name of Human: " + array[i].getHuman().getNameHuman()+", Age: "+ array[i].getHuman().getAge()+", Passport: "+array[i].getHuman().getSnPassport() +  "\n Amount of SMS: " + ((ContractMobile) array[i]).getaSms()+", amount of Minutes: "+((ContractMobile) array[i]).getaMinutes()+", amount of Gb Traffic: "+((ContractMobile) array[i]).getGbTraffic());
        } else if (array[i] instanceof ContractTV) {
            System.out.println("TV Contract:\n ID: " + array[i].getID() + ", date of start - date of end contract: " + array[i].getStartDate() +" - "+ array[i].getEndDate() + "\n Name of Human: " + array[i].getHuman().getNameHuman()+", Age: "+ array[i].getHuman().getAge()+", Passport: "+array[i].getHuman().getSnPassport() +  "\n Channels: " + Arrays.toString(((ContractTV) array[i]).getPackageChannel()));
        }
    }
}