package ua.goit.homework62;


public class DishCategory {
    private int catID;
    private String catName;

    public int getCatID() {
        return catID;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    @Override
    public String toString() {
        return "DishCategory{" +
                "catID=" + catID +
                ", catName='" + catName + '\'' +
                '}';
    }
}
