import Contracts.*;
import Helpers.Gender;
import Helpers.ReaderCSVFiles;
import Validators.*;
import org.junit.Test;

import java.time.LocalDate;

public class task4 {

    @Test
    public void validate_Default(){
        DefaultValidator defaultValidator = new DefaultValidator();
        Human person = new Human(1, "Nikita", LocalDate.of(2000, 6, 28), Gender.Male, "2014 456287");
        Contract contract = new Contract(1, LocalDate.of(2019, 1, 1),
                LocalDate.of(2021, 1, 1), 1, person);
        System.out.println(defaultValidator.validate(contract).toString());
    }

    @Test
    public void validate_Human(){
        ValidatorHuman validatorHuman = new ValidatorHuman();
        Human person = new Human(1, "Nikita", LocalDate.of(2000, 6, 28), Gender.Male, "2014 456287");
        Contract contract = new Contract(1, LocalDate.of(2019, 1, 1),
                LocalDate.of(2021, 1, 1), 1, person);
        System.out.println(validatorHuman.validate(contract).toString());
    }

    @Test
    public void validate_Ethernet(){
        ValidatorEthernet validatorEthernet = new ValidatorEthernet();
        Human person = new Human(1, "Nikita", LocalDate.of(2000, 6, 28), Gender.Male, "2014 456287");
        Contract contract = new ContractEthernet(1, LocalDate.of(2019, 1, 1),
                LocalDate.of(2021, 1, 1), 1, person, 500);
        System.out.println(validatorEthernet.validate(contract).toString());
    }

    @Test
    public void validate_Mobile(){
        ValidatorMobile validatorMobile = new ValidatorMobile();
        Human person = new Human(1, "Nikita", LocalDate.of(2000, 6, 28), Gender.Male, "2014 456287");
        Contract contract = new ContractMobile(1, LocalDate.of(2019, 1, 1),
                LocalDate.of(2021, 1, 1), 1, person, 50, 200, 10);
        System.out.println(validatorMobile.validate(contract).toString());
    }

    @Test
    public void validate_TV(){
        ValidatorTV validatorTV = new ValidatorTV();
        String [] string = {"SPORT", "KIDS", "COMEDY"};
        Human person = new Human(1, "Nikita", LocalDate.of(2000, 6, 28), Gender.Male, "2014 456287");
        Contract contract = new ContractTV(1, LocalDate.of(2019, 1, 1),
                LocalDate.of(2021, 1, 1), 1, person, 3, string);
        System.out.println(validatorTV.validate(contract).toString());
    }

    @Test
    public void checkCSV() throws Exception {
        ReaderCSVFiles reader = new ReaderCSVFiles();
        reader.readCSVFiles();
    }
}
