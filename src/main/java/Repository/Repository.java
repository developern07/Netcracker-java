package Repository;

import Contracts.Contract;
import Contracts.ContractEthernet;
import Contracts.ContractMobile;
import Contracts.ContractTV;

import java.util.Arrays;
import java.util.function.Predicate;

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

    public <T extends Contract> T[] getAll() { return (T[])array; }

    public void remove(int index) {
        if (index >= 0 && index < array.length) {
            array[index] = null;
            for (int i = index; i < array.length - 1; ++i) {
                array[i] = array[i + 1];
            }
            this.array = Arrays.copyOf(array, array.length - 1);
        }
    }

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

    public void PrintArrays(int[] indexes){
        for(int i=0; i<indexes.length; i++) {
            if (array[indexes[i]] instanceof ContractEthernet) {
                System.out.println("Ethernet Contract:\n ID: " + array[indexes[i]].getID() + ", date of start - date of end contract: " + array[indexes[i]].getStartDate() + " - " + array[indexes[i]].getEndDate() + "\n Name of Human: " + array[indexes[i]].getHuman().getNameHuman() + ", Age: " + array[indexes[i]].getHuman().getAge() + ", Passport: " + array[indexes[i]].getHuman().getSnPassport() + "\n Speed Connection: " + ((ContractEthernet) array[indexes[i]]).getSpeedConnection());
            } else if (array[indexes[i]] instanceof ContractMobile) {
                System.out.println("Mobile Contract:\n ID: " + array[indexes[i]].getID() + ", date of start - date of end contract: " + array[indexes[i]].getStartDate() + " - " + array[indexes[i]].getEndDate() + "\n Name of Human: " + array[indexes[i]].getHuman().getNameHuman() + ", Age: " + array[indexes[i]].getHuman().getAge() + ", Passport: " + array[indexes[i]].getHuman().getSnPassport() + "\n Amount of SMS: " + ((ContractMobile) array[indexes[i]]).getaSms() + ", amount of Minutes: " + ((ContractMobile) array[indexes[i]]).getaMinutes() + ", amount of Gb Traffic: " + ((ContractMobile) array[indexes[i]]).getGbTraffic());
            } else if (array[indexes[i]] instanceof ContractTV) {
                System.out.println("TV Contract:\n ID: " + array[indexes[i]].getID() + ", date of start - date of end contract: " + array[indexes[i]].getStartDate() + " - " + array[indexes[i]].getEndDate() + "\n Name of Human: " + array[indexes[i]].getHuman().getNameHuman() + ", Age: " + array[indexes[i]].getHuman().getAge() + ", Passport: " + array[indexes[i]].getHuman().getSnPassport() + "\n Channels: " + Arrays.toString(((ContractTV) array[indexes[i]]).getPackageChannel()));
            }
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

    public <T extends Contract> int[] findElementsID(Predicate<T> filter){
        int arrayElements[] = new int[0];
        int j=0;
        boolean bool=false;
        for (int i=0; i< array.length; i++){
            if (this.array[i] != null && filter.test((T)array[i])){
                bool = true;
                arrayElements = Arrays.copyOf(arrayElements, arrayElements.length + 1);
                arrayElements[j] = i;
                j++;
            }
        }
        if (bool){
            if (j>1){
            System.out.println("Found " + j + " contracts");}
            if (j==1){
                System.out.println("Found " + j + " contract");
            }
            return arrayElements;
        }
        else {
            System.out.println("Contracts not found");
        }
        return arrayElements;
    }

    public <T extends Contract> int findElementID(Predicate<T> filter){
        for (int i =0; i < array.length; i++){
            if (this.array[i] != null && filter.test((T)array[i])){
                return i;
            }
        }
        System.out.println("Object not found");
        return -1;
    }
}