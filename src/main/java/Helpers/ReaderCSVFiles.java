package Helpers;

import Contracts.ContractEthernet;
import Contracts.ContractMobile;
import Contracts.ContractTV;
import Contracts.Human;
import Repository.Repository;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReaderCSVFiles
{
    /**
     * Method of set true date formatting
     */
    protected DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    /**
     * Contracts repository
     */
    protected Repository contracts = new Repository();

    public Repository getContracts() {
        return contracts;
    }

    /**
     * Contract owner
     */
    protected Human human;

    /**
     * Parser
     */
    protected CSVParser pars = new CSVParserBuilder().withSeparator(';').withIgnoreQuotations(true).build();

    /**
     * Method of reading data from a file and writing this data to a repository
     * @throws Exception
     */
    public void readCSVFiles() throws Exception
    {
        CSVReader reader = new CSVReaderBuilder(new FileReader("DB java.csv")).withCSVParser(pars).withSkipLines(0).build();
        String[] nextLine;
        int personId = 1;
        int numberString = 1;
        String typeOfContract;
        while ((nextLine = reader.readNext()) != null) {
            human = new Human(personId, nextLine[2], LocalDate.parse(nextLine[4], format), Gender.valueOf(nextLine[3]), nextLine[5]);
            typeOfContract=nextLine[6];
            String[] addInfo = nextLine[7].split(", ");
            switch (typeOfContract){
                case ("Ethernet") -> {
                    int speed = Integer.parseInt(nextLine[7]);
                    contracts.add(new ContractEthernet(numberString, LocalDate.parse(nextLine[0], format), LocalDate.parse(nextLine[1], format), numberString, human, speed));
                }
                case ("Mobile") -> {
                    String packageOfServices = nextLine[7];
                    contracts.add(new ContractMobile(numberString, LocalDate.parse(nextLine[0], format), LocalDate.parse(nextLine[1], format), numberString, human, Integer.parseInt(addInfo[0]), Integer.parseInt(addInfo[1]), Integer.parseInt(addInfo[2])));
                }
                case ("TV") -> {
                    String packageChannels = nextLine[7];
                    contracts.add(new ContractTV(numberString, LocalDate.parse(nextLine[0], format), LocalDate.parse(nextLine[1], format), numberString, human, addInfo.length-1, addInfo));
                }
            }
            numberString++;
            personId++;
        }
    }
}