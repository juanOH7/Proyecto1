package edpro1;

public class VSArray extends TDALista{
    Object data[] = new Object[size];

    public VSArray(int size) {
        super(size);
    }
    
    public void resize(){
        int newSize = (int)(size + size * 0.2);
	Object temp[] = new Object[newSize];
	for (int i = 0; i < size; ++i){
		temp[i] = data[i];
        }
        cap = newSize;
	data = temp;
    }
    
    @Override
    public  boolean insert(Object target, int pos){
        if (pos < 0 || pos > size) {
            return false;
        }
        if (isFull()) {
            resize();
        }
        if (isEmpty()) {
            data[0] = target;
        }else{
            for (int i = size; i >= pos; i--) {
                data[i] = data[i - 1]; 
            }
            data[pos] = target;
            size++;
        }
        return true;
    }
    @Override
    public int indexOf(Object target){
        for (int i = 0; i < size; i++) {
            if (target.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public Object get(int pos){
        return data[pos];
    }

    @Override
    public Object erase(int pos){
        if (pos < 0 || pos > size) {
            return false;
        }
        Object temp = data[pos];
        for (int i = pos; i <= size; i++) {
            data[i + 1] = data[i]; 
        }
        size--;
        return temp;
    }
    @Override
    public void reset(){}
    
    @Override
    public Object first(){
        return data[0];
    }
    @Override
    public Object last(){
        return data[size - 1];
    }
    
    @Override
    public boolean isEmpty(){
        return size == 0;
        
    }
    
    @Override
    public boolean isFull(){
        return size == cap;
    }
    
    @Override
    public int getSize(){
        return size;
    }
    
    @Override
    public int getCap(){
        return cap;
    }
}
