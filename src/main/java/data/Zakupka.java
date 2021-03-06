package data;

public class Zakupka implements TableData {
    private int id;
    private String name;
    private float price;
    private String unit;

    public Zakupka(int id, String name, float price, String unit) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
