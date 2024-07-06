
package realestate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;


public class Seller {
    private int Id;
    private String Name;
    private String Phone;

    public Seller(int Id, String Name, String Phone) {
        this.Id = Id;
        this.Name = Name;
        this.Phone = Phone;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getPhone() {
        return Phone;
    }
    
  
    
}
