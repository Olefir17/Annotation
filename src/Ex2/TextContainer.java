package Ex2;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Anastasia on 15.01.2017.
 */
@SaveTo( path = "C:\\Users\\Anastasia\\file.txt")
class TextContainer {
    String s = "Hello!!!!!!!!!!";

    @Save
    public  void save(String path) throws IOException{
        FileWriter fw = new FileWriter(path);
        fw.write(s);
        fw.close();

    }
}
