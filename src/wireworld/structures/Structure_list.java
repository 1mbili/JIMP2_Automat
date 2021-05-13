package wireworld.structures;

import java.util.ArrayList;
import java.util.Iterator;

public class Structure_list  implements Iterable<Structure> {

    private ArrayList<Structure> struktury;

    public Structure_list(){ struktury = new ArrayList<Structure>(); }

    public void add(Structure s) {struktury.add(s);}


    @Override
    public Iterator<Structure> iterator() {
        return struktury.iterator();
    }
}
