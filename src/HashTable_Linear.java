import java.util.*;

public class HashTable_Linear{

    HashEntry[] table;
    private final static int size = 128;
    //private final static int hash = 13;

    public class HashEntry {
        private int key;
        private int value;

        HashEntry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }

    HashTable_Linear(){
        table = new HashEntry[this.size];
        for(int i = 0; i < this.size; i++){
            table[i] = null;
        }
        System.out.println("Construction OK...");
    }

    public void put(int key, int value){
        int hashcode = key % size;
        while(hashcode < size && table[hashcode] != null && table[hashcode].getKey() != key) hashcode++;
        if(hashcode == size) {
            System.out.println("HashTable already full");
            return;
        }
        table[hashcode] = new HashEntry(key,value);
        System.out.println("PUT SUCCESS..");
        return;
    }

    public boolean containsKey(int key){
        int hashcode = key % size;
        while(hashcode < size && table[hashcode] != null && table[hashcode].getKey() != key) hashcode++;
        return hashcode < size && table[hashcode] != null;
    }

    public int get(int key){
        int hashcode = key % size;
        while(hashcode < size && table[hashcode] != null && table[hashcode].getKey() != key) hashcode++;
        if(hashcode < size && table[hashcode] != null) return table[hashcode].getValue();
        else{
            System.out.println("ERROR: NO SUCH ELEMENT");
            return 0;
        }
    }

    public static void main (String[] args) {
        HashTable_Linear table = new HashTable_Linear();
        table.put(312,5);
        table.put(528,10);
        System.out.println(table.containsKey(312));
        System.out.println(table.containsKey(3));
        System.out.println(table.get(528));
    }

}