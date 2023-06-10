import java.util.ArrayList;

public class Orden {
    private ArrayList<MenuItem> items;

    //region CONST
    public Orden() {
        this.items= new ArrayList<MenuItem>();
    }
    //endregion

    //region GYS
    public ArrayList<MenuItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<MenuItem> items) {
        this.items = items;
    }
    //endregion


    @Override
    public String toString() {
        return "Orden{" +
                "items=" + items +
                '}';
    }
}
