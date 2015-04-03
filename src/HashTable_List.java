import java.util.*;

public class HashTable_List{
    List<Integer>[] array;
    int size;

    HashTable_List(int size){
        this.size = size;
        array = new List<Integer>[size];
    }
}