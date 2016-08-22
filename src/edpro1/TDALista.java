package edpro1;

public abstract class TDALista {
    protected int size;
    protected int cap;

    public TDALista(int cap) {
        this.cap = cap;
        this.size = 0;
    }
    
    public abstract boolean insert(Object target, int pos);
    public abstract int indexOf(Object target);
    public abstract Object get(int pos);
    public abstract Object erase(int pos);
    public abstract void reset();
    public abstract boolean set(Object neo,int pos);
    public abstract Object first();
    public abstract Object last();
    public abstract boolean isEmpty();
    public abstract boolean isFull();
    public abstract int getSize();
    public abstract int getCap();
}
