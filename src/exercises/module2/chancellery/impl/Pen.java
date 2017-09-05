package exercises.module2.chancellery.impl;

import exercises.module2.chancellery.Nameable;
import exercises.module2.chancellery.Priceable;

import java.math.BigDecimal;

/**
 * @author dmch0916
 *         Date: 21.08.2017
 *         Time: 15:52
 */
public class Pen implements Priceable, Nameable {
    private String name;
    private String color;
    private String manufacturer;
    private BigDecimal price;

    public Pen(String color, String manufacturer, BigDecimal price) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pen pen = (Pen) o;

        if (color != null ? !color.equals(pen.color) : pen.color != null) return false;
        return manufacturer != null ? manufacturer.equals(pen.manufacturer) : pen.manufacturer == null;
    }

    @Override
    public int hashCode() {
        int result = color != null ? color.hashCode() : 0;
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Pen: color= " + color + ", manufacturer=" + manufacturer + ", price= " + price;
    }
}