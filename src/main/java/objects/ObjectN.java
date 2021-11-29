package objects;

public class ObjectN {
    //Флаг для определения возможно владения объектом
    private boolean ableToOwn;

    public ObjectN () {
        this.ableToOwn = true;
    }

    public boolean isAbleToOwn() {
        return ableToOwn;
    }

    public void setAbleToOwn(boolean ableToOwn) {
        this.ableToOwn = ableToOwn;
    }
}
