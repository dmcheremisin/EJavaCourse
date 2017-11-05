package exercises.module2.chancellery.impl;

import exercises.module2.chancellery.Nameable;
import exercises.module2.chancellery.Priceable;

import java.math.BigDecimal;

/**
 * @author dmch0916
 *         Date: 21.08.2017
 *         Time: 16:06
 */
public class Elastic implements Priceable, Nameable {
    private String name;
    private String color;
    private String manufacturer;
    private BigDecimal price;

    public Elastic(String color, String manufacturer, BigDecimal price) {
        this.name = this.getClass().getName();
        this.color = color;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
    public String toString() {
        return "Elastic: color="+ color + ", manufacturer= " + manufacturer + ", price= " + price;
    }
}