package exercises.module7.waitNotifyTask;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitrii on 19.11.2017.
 */

public class SharedResource {
    private List<Integer> list;

    public SharedResource() {
        list = new ArrayList<Integer>();
    }

    public void setElement(Integer element) {
        list.add(element);
    }

    public Integer getELement() {
        if (list.size() > 0) {
            return list.remove(0);
        }
        return null;
    }

}