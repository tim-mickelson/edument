package se.edument.recap.chat.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tim on 2015-05-23.
 */
public class Bag<T> {
    private List<T> items = new ArrayList<>();

    public void add(T item){
        items.add(item);
    }

    /**
     * Get occurences of items equal to given item.
     *
     * @param item
     * @return occurrences or 0 if not found
     */
    public int occurenceOf(T item){
        if(item==null)
            return 0;

        int count = 0;

        for(T i:items){
            if (i.equals(item)){
                count++;
            }  // end i equals item
        }  // end loop items

        return count;
    }  // end function occurenceOf

}  // end class Bag