package binPack;
/**
 * Created by srx on 2017/11/28.
 */
public class Bin {
    public float capacity = 1;


    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public void addBoxes(Float box) {
        capacity = capacity - box;

    }
}
