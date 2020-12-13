import Contracts.ContractEthernet;
import Contracts.ContractMobile;
import Contracts.ContractTV;
import Contracts.Human;
import Helpers.Gender;
import Repository.Repository;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Random;

public class task1 {
        String[][] names = new String[][]{
                {"Dima", "Nikita", "Danil", "Vlad"},
                {"Alina", "Lena", "Katya", "Dasha"}
        };
        String[][] secondNames = new String[][]{
                {"Vasiliev", "Kryuchkov", "Potapov", "Yakushihin"},
                {"Popova", "Tomashevskaya", "Shilyaeva", "Minakova"}
        };
        String[] channels = new String[]{"First Channel", "TNT", "STS", "Disney", "Russia", "TV3", "MusicTV", "Karusel", "Nikelodion", "Kids"};
        Random r = new Random();
    @Test
        public void add(){
            Repository contracts = new Repository();
            int amount = r.nextInt(10), typeOfContract, name, secondName, gender, speed, aChannel, aSms, aMinutes, aGB, y, m, d, yc, mc, dc, sPassport, nPassport;
            System.out.println(amount + " contracts are registered in the system!");
            for (int i = 0; i < amount; i++) {
                    typeOfContract = r.nextInt(3) + 1;
                    name = r.nextInt(4);
                    secondName = r.nextInt(4);
                    gender = r.nextInt(2);
                    y = 2002 - r.nextInt(70);
                    m = r.nextInt(12) + 1;
                    d = r.nextInt(28) + 1;
                    sPassport = r.nextInt(8999) + 1000;
                    nPassport = r.nextInt(899999) + 100000;
                    Human human = new Human(i + 1, names[gender][name] + " " + secondNames[gender][secondName], LocalDate.of(y, m, d), Gender.values()[gender], sPassport + " " + nPassport);
                    switch (typeOfContract) {
                            case 1 -> {
                                    speed = r.nextInt(500);
                                    contracts.add(new ContractEthernet(i + 1, LocalDate.of(yc = 2020 - r.nextInt(20), mc = m = r.nextInt(12) + 1, dc = d = r.nextInt(28) + 1), LocalDate.of(yc += r.nextInt(20), mc = m = r.nextInt(12) + 1, dc = d = r.nextInt(28) + 1), i + 1, human, speed));
                            }
                            case 2 -> {
                                    aSms = r.nextInt(1000);
                                    aMinutes = r.nextInt(1000);
                                    aGB = r.nextInt(1000);
                                    contracts.add(new ContractMobile(i + 1, LocalDate.of(yc = 2020 - r.nextInt(20), mc = m = r.nextInt(12) + 1, dc = d = r.nextInt(28) + 1), LocalDate.of(yc += r.nextInt(20), mc = m = r.nextInt(12) + 1, dc = d = r.nextInt(28) + 1), i + 1, human, aSms, aMinutes, aGB));
                            }
                            case 3 -> {
                                    aChannel = r.nextInt(10);
                                    String[] packageChannels = new String[aChannel];
                                    for (int j = 0; j < aChannel; j++) {
                                            packageChannels[j] = channels[j];
                                    }
                                    contracts.add(new ContractTV(i + 1, LocalDate.of(yc = 2020 - r.nextInt(20), mc = m = r.nextInt(12) + 1, dc = d = r.nextInt(28) + 1), LocalDate.of(yc += r.nextInt(20), mc = m = r.nextInt(12) + 1, dc = d = r.nextInt(28) + 1), i + 1, human, aChannel, packageChannels));
                            }
                    }
                    contracts.PrintArrayByID(i+1);
            }
        }

    @Test
        public void delete(){
            Repository contracts = new Repository();
            int amount = r.nextInt(10), typeOfContract, name, secondName, gender, speed, aChannel, aSms, aMinutes, aGB, y, m, d, yc, mc, dc, sPassport, nPassport;
            System.out.println(amount + " contracts are registered in the system!");
            for (int i = 0; i < amount; i++) {
                    typeOfContract = r.nextInt(3) + 1;
                    name = r.nextInt(4);
                    secondName = r.nextInt(4);
                    gender = r.nextInt(2);
                    y = 2002 - r.nextInt(70);
                    m = r.nextInt(12) + 1;
                    d = r.nextInt(28) + 1;
                    sPassport = r.nextInt(8999) + 1000;
                    nPassport = r.nextInt(899999) + 100000;
                    Human human = new Human(i + 1, names[gender][name] + " " + secondNames[gender][secondName], LocalDate.of(y, m, d), Gender.values()[gender], sPassport + " " + nPassport);
                    switch (typeOfContract) {
                            case 1 -> {
                                    speed = r.nextInt(500);
                                    contracts.add(new ContractEthernet(i + 1, LocalDate.of(yc = 2020 - r.nextInt(20), mc = m = r.nextInt(12) + 1, dc = d = r.nextInt(28) + 1), LocalDate.of(yc += r.nextInt(20), mc = m = r.nextInt(12) + 1, dc = d = r.nextInt(28) + 1), i + 1, human, speed));
                            }
                            case 2 -> {
                                    aSms = r.nextInt(1000);
                                    aMinutes = r.nextInt(1000);
                                    aGB = r.nextInt(1000);
                                    contracts.add(new ContractMobile(i + 1, LocalDate.of(yc = 2020 - r.nextInt(20), mc = m = r.nextInt(12) + 1, dc = d = r.nextInt(28) + 1), LocalDate.of(yc += r.nextInt(20), mc = m = r.nextInt(12) + 1, dc = d = r.nextInt(28) + 1), i + 1, human, aSms, aMinutes, aGB));
                            }
                            case 3 -> {
                                    aChannel = r.nextInt(10);
                                    String[] packageChannels = new String[aChannel];
                                    for (int j = 0; j < aChannel; j++) {
                                            packageChannels[j] = channels[j];
                                    }
                                    contracts.add(new ContractTV(i + 1, LocalDate.of(yc = 2020 - r.nextInt(20), mc = m = r.nextInt(12) + 1, dc = d = r.nextInt(28) + 1), LocalDate.of(yc += r.nextInt(20), mc = m = r.nextInt(12) + 1, dc = d = r.nextInt(28) + 1), i + 1, human, aChannel, packageChannels));
                            }
                    }
                    contracts.PrintArrayByID(i+1);
            }
            if (amount > 0) {
                    int deleteThisId=(amount+1)/2;
                    contracts.remove(deleteThisId);
                    System.out.println("\n ID: " + deleteThisId + " contract deleted from system!");
                    amount--;
                    System.out.println("\n");
                    System.out.println(amount + " contracts are registered in the system!");
                    for (int i = 0; i < amount+1; i++) {
                            if (i!=(deleteThisId-1)){
                                    contracts.PrintArrayByID(contracts.get(i+1).getID());}
                    }
            }
    }
}


