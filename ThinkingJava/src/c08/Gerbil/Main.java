package c08.Gerbil;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // EX_1,2
        //     List<Gerbil> gerbilList = new ArrayList<>();
        Map<String, Gerbil> gerbils = new LinkedHashMap<>();

        for (int i = 0; i < 5; i++) {
            gerbils.put(String.valueOf(i), new Gerbil(i));
            // EX_1,2
            //       gerbilList.add(new Gerbil(i));
        }

        // EX_1,2
            Iterator<String> iterator = gerbils.keySet().iterator();// gerbilList.iterator();
       while (iterator.hasNext()) {
//            Gerbil gerbil = iterator.next();
            Gerbil gerbil = gerbils.get(iterator.next());
            System.out.println(gerbil.hop());
        }


    }
}
