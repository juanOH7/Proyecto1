package edpro1;

public class VSArray extends TDALista{
    Object data[] = new Object[cap];

    public VSArray(int cap) {
        super(cap);
    }
    
    public void resize(){
        int newCap = (int)(size + size * 0.5);
	Object temp[] = new Object[newCap];
	for (int i = 0; i < size; ++i){
		temp[i] = data[i];
        }
        cap = newCap;
	data = temp;
    }
    
    @Override
    public  boolean insert(Object target, int pos){
        if (pos < 0 || pos > size) {
            return false;
        }
        if (isFull()) {
            System.out.println("Full");
            resize();
        }
        if (isEmpty()) {
            data[0] = target;
        }else{
            for (int i = size ; i > pos; i--) {
                data[i] = data[i - 1]; 
            }
            data[pos] = target;
        }
        size++;
        return true;
    }
    @Override
    public int indexOf(Object target){
        for (int i = 0; i < size; i++) {
            if (equals(data[i],target)) {
                return i;
            }
        }
        return -1;
    }
    public boolean set(Object neo, int pos){
        if (pos < 0 || pos > size - 1) {
            return false;
        }
        data[pos] = neo;
        return true;
    }

    
    public boolean equals(Object target1, Object target2){
        if (target1.getClass() != target2.getClass()) {
            System.out.println("no same");
            return false;
        }
        return target1.toString().equals(target2.toString());
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
        for (int i = pos; i < size - 1; i++) {
            data[i] = data[i + 1]; 
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
