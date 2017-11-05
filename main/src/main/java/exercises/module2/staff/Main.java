package exercises.module2.staff;

import exercises.module2.chancellery.impl.BeginersCombo;
import exercises.module2.chancellery.impl.Comparators;
import exercises.module2.chancellery.impl.Elastic;
import exercises.module2.chancellery.impl.Pen;
import exercises.module2.chancellery.impl.Rule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author dmch0916
 *         Date: 21.08.2017
 *         Time: 16:11
 */
public class Main {

    static List<Person> persons = new ArrayList<Person>(){{
        add(new Person("Dmitrii", "Cheremisin"));
        add(new Person("Anna", "Cheremisina"));
        add(new Person("Mark", "Cheremisin"));
        add(new Person("Irina", "Cheremisina"));
        add(new Person("Yurii", "Cheremisin"));
    }};

    public static void main(String[] args) {
        addChancellaryItems();
        Person person1 = persons.get(0);
        person1.getTotalChancellaryPrice();
        Person person2 = persons.get(1);
        person2.getTotalChancellaryPrice();
        addBeginersCombo(person1);
        System.out.println(" ========= ");
        applyComparator(person1, Comparators.getNameComparator());
        person1.printItems();
        System.out.println(" ========= ");
        applyComparator(person1, Comparators.getPriceComparator());
        person1.printItems();
        person1.getTotalChancellaryPrice();
    }

    private static void applyComparator(Person person, Comparator comparator) {
        Collections.sort(person.getChancellaryItems(), comparator);
    }

    private static void addBeginersCombo(Person person) {
        new BeginersCombo(person);
    }

    private static void addChancellaryItems() {
        for (Person person : persons) {
            if(person.getLastName().equals("Cheremisin")){
                person.addChancellaryItem(new Pen("black", "Pilot", new BigDecimal(100.0)));
                person.addChancellaryItem(new Rule(30, "Carioca", new BigDecimal(15.0)));
            } else {
                person.addChancellaryItem(new Pen("pink", "Couture", new BigDecimal(2.0)));
                person.addChancellaryItem(new Elastic("orange", "Orion", new BigDecimal(5.5)));
            }
        }
    }
}