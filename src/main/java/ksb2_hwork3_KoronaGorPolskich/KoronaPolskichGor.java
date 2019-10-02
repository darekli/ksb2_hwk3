package ksb2_hwork3_KoronaGorPolskich;

public class KoronaPolskichGor {


    private int id;
    private String mountainRange;
    private String mountain;
    private int height;

    public KoronaPolskichGor(int id, String mountainRange, String mountain, int height) {
        this.id = id;
        this.mountainRange = mountainRange;
        this.mountain = mountain;
        this.height = height;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getMountainRange() {
        return mountainRange;
    }

    public void setMountainRange(String mountainRange) {
        this.mountainRange = mountainRange;
    }
    public String getMountain() {
        return mountain;
    }

    public void setMountain(String mountain) {
        this.mountain = mountain;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
