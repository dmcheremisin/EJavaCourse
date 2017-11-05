package exercises.module2.staff;

import exercises.module2.chancellery.Priceable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dmch0916
 *         Date: 21.08.2017
 *         Time: 16:07
 */
public class Person {

    private String firstName;
    private String lastName;
    private List<Priceable> chancellaryItems;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        chancellaryItems = new ArrayList<>();
    }

    public void getTotalChancellaryPrice(){
        BigDecimal total = BigDecimal.ZERO;
        for (Priceable priceable : chancellaryItems){
            if(priceable != null){
                total = total.add(priceable.getPrice());
            }
        }
        System.out.println(this + " has items total: " + total);
    }

    public void addChancellaryItem(Priceable priceable){
        chancellaryItems.add(priceable);
    }

    public void printItems(){
        for(Priceable priceable : chancellaryItems){
            System.out.println(priceable);
        }
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Priceable> getChancellaryItems() {
        return chancellaryItems;
    }

    public void setChancellaryItems(List<Priceable> chancellaryItems) {
        this.chancellaryItems = chancellaryItems;
    }

    @Override
    public String toString() {
        return "Person: firstName=" + firstName + ", lastName=" + lastName;
    }
}