package Helpers;

import Contracts.*;
import Repository.Repository;
import Validators.*;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
     * Parameters of validate
     */
    protected List<IValidator> validatorList = new ArrayList<>();

    /**
     * Messages of check
     */
    protected List<Message> messages = new ArrayList<>();

    /**
     * Contract
     */
    protected Contract contract;

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
        Human humansArray[] = new Human[personId];
        while ((nextLine = reader.readNext()) != null) {
            human = new Human(personId, nextLine[2], LocalDate.parse(nextLine[4], format), Gender.valueOf(nextLine[3]), nextLine[5]);
            for (int i=0; i<personId-2; i++){
                if (humansArray[i] == human){
                    human.setIdOfHuman(i+1);
                    personId--;
                    break;
                }
                else {
                    humansArray = Arrays.copyOf(humansArray, humansArray.length + 1);
                    humansArray[humansArray.length - 1] = human;
                }
            }
            typeOfContract=nextLine[6];
            String[] addInfo = nextLine[7].split(", ");

            messages = new ArrayList<>();
            validatorList=new ArrayList<>();
            DefaultValidator defaultValidator = new DefaultValidator();
            ValidatorHuman validatorHuman = new ValidatorHuman();
            validatorList.add(defaultValidator);
            validatorList.add(validatorHuman);

            switch (typeOfContract){
                case ("Ethernet") -> {
                    int speed = Integer.parseInt(nextLine[7]);
                    contract = new ContractEthernet(numberString, LocalDate.parse(nextLine[0], format), LocalDate.parse(nextLine[1], format), numberString, human, speed);
                    ValidatorEthernet validatorEthernet = new ValidatorEthernet();
                    validatorList.add(validatorEthernet);
                }
                case ("Mobile") -> {
                    String packageOfServices = nextLine[7];
                    contract = new ContractMobile(numberString, LocalDate.parse(nextLine[0], format), LocalDate.parse(nextLine[1], format), numberString, human, Integer.parseInt(addInfo[0]), Integer.parseInt(addInfo[1]), Integer.parseInt(addInfo[2]));
                    ValidatorMobile validatorMobile = new ValidatorMobile();
                    validatorList.add(validatorMobile);
                }
                case ("TV") -> {
                    String packageChannels = nextLine[7];
                    contract = new ContractTV(numberString, LocalDate.parse(nextLine[0], format), LocalDate.parse(nextLine[1], format), numberString, human, addInfo.length-1, addInfo);
                    ValidatorTV validatorTV = new ValidatorTV();
                    validatorList.add(validatorTV);
                }
            }

            messages = check(contract,validatorList);
            int errorC = 0;
            System.out.println("\n");
            for (Message m : messages) {
                if (!m.getStatus().equals(CheckStatus.OK)) {
                    System.out.println(m.toString());
                    errorC++;
                }
            }

            if (errorC == 0) {
                System.out.println("Contract " + numberString+ " is added to the repository");
                contracts.add(contract);
                contracts.PrintArrayByID(numberString);
            }
            else {
                System.out.println("Contract " + numberString + " cannot be added to the repository");
            }
            numberString++;
            personId++;
        }
        reader.close();
    }

    /**
     * Method of getting results of checks
     * @param contract
     * @param validatorList
     * @param <T>
     * @return messageList
     * @throws ClassNotFoundException
     */
    public static <T extends Contract> List<Message> check(T contract, List<IValidator> validatorList) throws ClassNotFoundException {
        List<Message> messageList = new ArrayList<>();
        for (IValidator v: validatorList) {
            if (v.getAppliableFor().isInstance(contract)) {
                messageList.add(v.validate(contract));
            }
        }
        return  messageList;
    }
}