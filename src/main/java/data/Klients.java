package data;

public class Klients implements TableData {
    private int id;
    private String firm;
    private String country;
    private String adress;
    private int tfnumber;

    public Klients(int id, String firm, String country, String adress, int tfnumber) {
        this.id = id;
        this.firm = firm;
        this.country = country;
        this.adress = adress;
        this.tfnumber = tfnumber;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getTfnumber() {
        return tfnumber;
    }

    public void setTfnumber(int tfnumber) {
        this.tfnumber = tfnumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
