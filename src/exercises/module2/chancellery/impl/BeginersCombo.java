package exercises.module2.chancellery.impl;

import exercises.module2.chancellery.Priceable;
import exercises.module2.staff.Person;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dmch0916
 *         Date: 21.08.2017
 *         Time: 16:38
 */
public class BeginersCombo {

    List<Priceable> items = new ArrayList<Priceable>(){{
        add(new Pen("black", "Pilot", new BigDecimal(10.0)));
        add(new Rule(30, "Carioca", new BigDecimal(15.0)));
        add(new Elastic("orange", "Orion", new BigDecimal(5.5)));
    }};

    public BeginersCombo(Person person) {
        for (Priceable priceable : items) {
            person.addChancellaryItem(priceable);
        }
    }

    public List<Priceable> getItems() {
        return items;
    }

    public void setItems(List<Priceable> items) {
        this.items = items;
    }
}