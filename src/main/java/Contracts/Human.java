package Contracts;

import Helpers.Gender;

import java.time.LocalDate;
import java.time.Year;

/**
 * Contracts.Human model
 */
public class Human {
    /**
     * Method of getting human id
     * @return ifOfHuman
     */
    public int getIdOfHuman() {
        return idOfHuman;
    }

    /**
     * Method of setting human id
     * @param idOfHuman
     */
    public void setIdOfHuman(int idOfHuman) {
        this.idOfHuman = idOfHuman;
    }

    /**
     * ID of human
     */
    protected int idOfHuman;

    /**
     * Method of getting human name
     * @return name
     */
    public String getNameHuman() {
        return name;
    }

    /**
     * Method of setting human name
     * @param name
     */
    public void setNameHuman(String name) {
        this.name = name;
    }

    /**
     * human name
     */
    protected String name;

    /**
     * Method of getting date of birthday
     * @return dateOfBirthday
     */
    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    /**
     * Method of setting date of birthday
     * @param dateOfBirthday
     */
    public void setDateOfBirthday(LocalDate dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    /**
     * date of birthday
     */
    protected LocalDate dateOfBirthday;

    /**
     * Method of getting human gender
     * @return gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Method of setting human gender
     * @param gender
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * human gender
     */
    protected Gender gender;

    /**
     * Method of getting series and number of passport
     * @return snPassport
     */
    public String getSnPassport() {
        return snPassport;
    }

    /**
     * Method of setting series and number of passport
     * @param snPassport
     */
    public void setSnPassport(String snPassport) {
        this.snPassport = snPassport;
    }

    /**
     * series and number of passport
     */
    protected String snPassport;

    /**
     * Method of getting human age
     * @return
     */
    public int getAge(){
        return Year.now().getValue() - getDateOfBirthday().getYear();
    }

    /**
     * Constructor human
     * @param idOfHuman
     * @param name
     * @param dateOfBirthday
     * @param gender
     * @param snPassport
     */
    public Human(int idOfHuman, String name, LocalDate dateOfBirthday, Gender gender, String snPassport) {
        setIdOfHuman(idOfHuman);
        setNameHuman(name);
        setDateOfBirthday(dateOfBirthday);
        setGender(gender);
        setSnPassport(snPassport);
    }
}
