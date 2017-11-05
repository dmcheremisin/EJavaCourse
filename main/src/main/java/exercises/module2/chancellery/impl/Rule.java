package exercises.module2.chancellery.impl;

import exercises.module2.chancellery.Nameable;
import exercises.module2.chancellery.Priceable;

import java.math.BigDecimal;

/**
 * @author dmch0916
 *         Date: 21.08.2017
 *         Time: 16:02
 */
public class Rule implements Priceable, Nameable {
    private String name;
    private int size;
    private String manufacturer;
    private BigDecimal price;

    public Rule(int size, String manufacturer, BigDecimal price) {
        this.name = this.getClass().getName();
        this.size = size;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Rule: size=" + size + ", manufacturer= " + manufacturer + ", price= " + price;
    }
}