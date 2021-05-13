package wireworld.Utils;


import wireworld.structures.*;


import java.io.*;
import java.lang.reflect.InvocationTargetException;

public class Utils {

    public static Structure_list readFile(String path) throws IOException {

            Structure_list s = new Structure_list();
            BufferedReader r = new BufferedReader(new FileReader(path));
            String line;
            Structure tmp;
            while ( (line=r.readLine()) != null ) {
               if ((tmp = readStructure(line)) != null)
                   s.add(tmp);
            }  return s;  }





            private static Structure readStructure(String line) {
                line = line.replaceAll(":|,", "");
                String[] w = line.split(" ");
                w[0] = "wireworld.structures."+w[0];
                try {
                    Class c = Class.forName(w[0]);
                    if (c.getName().equals("wireworld.structures.Diode")) {
                        return (Structure) c.getDeclaredConstructor(int.class,int.class,String.class).newInstance(Integer.parseInt(w[1]),Integer.parseInt(w[2]),w[3]);
                    }
                    if (c.getName().matches("wireworld\\.structures\\.(AND|OR|XOR|NAND|ElectronHead|ElectronTail)")) {
                        return (Structure) c.getDeclaredConstructor(int.class,int.class).newInstance(Integer.parseInt(w[1]),Integer.parseInt(w[2]));
                    }
                } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    System.err.println(w[0] + " Brak takiej lub metody");
                }
                return null;
            }
            public static void writeFile(Structure_list slist, String filepath) throws IOException {
                FileWriter writer = new FileWriter(filepath);
                for (Structure st: slist) {
                    writer.write(st+ "\n");
                }
                writer.close();
            }



}