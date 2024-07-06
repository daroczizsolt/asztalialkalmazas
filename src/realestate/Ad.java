
package realestate;

import java.awt.geom.Area;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.print.attribute.standard.DateTimeAtCompleted;


public class Ad{
    
    private int Area;
    private Chategory Chategory;
    private LocalDate CreateAt;
    private String Descraption;
    private int Floors;
    private boolean  FreeOfCharge;
    private int Id;
    private String ImageUrl;
    private String Latlong;
    private int Rooms;
    private Seller Seller;

    public Ad(int Area, Chategory Chategory, LocalDate CreateAt, String Descraption, int Floors, boolean FreeOfCharge, int Id, String ImageUrl, String Latlong, int Rooms, Seller Seller) {
        this.Area = Area;
        this.Chategory = Chategory;
        this.CreateAt = CreateAt;
        this.Descraption = Descraption;
        this.Floors = Floors;
        this.FreeOfCharge = FreeOfCharge;
        this.Id = Id;
        this.ImageUrl = ImageUrl;
        this.Latlong = Latlong;
        this.Rooms = Rooms;
        this.Seller = Seller;
    }

    public int getArea() {
        return Area;
    }

    public Chategory getChategory() {
        return Chategory;
    }

    public LocalDate getCreateAt() {
        return CreateAt;
    }

    public String getDescraption() {
        return Descraption;
    }

    public int getFloors() {
        return Floors;
    }

    public boolean isFreeOfCharge() {
        return FreeOfCharge;
    }

    public int getId() {
        return Id;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public String getLatlong() {
        return Latlong;
    }

    public int getRooms() {
        return Rooms;
    }

    public Seller getSeller() {
        return Seller;
    }
    
    
    
      static List<Ad> LoadFromCsv(String filePath) throws FileNotFoundException, IOException{
         List<Ad> adatok = new ArrayList<>();
        try (RandomAccessFile r = new RandomAccessFile(filePath, "r")){
            String sor;
            r.readLine();


            while ((sor = r.readLine()) != null) {

                String [] data = sor.split(";");
                int id = Integer.parseInt(data[0]);
                 int rooms = Integer.parseInt(data[1]);
                 String latLong = data[2];
                 int floors = Integer.parseInt(data[3]);
                int area = Integer.parseInt(data[4]);
                 String description = data[5];
                 boolean freeOfCharge = Boolean.parseBoolean(data[6]);
                String imageUrl = data[7];
                LocalDate createdAt = LocalDate.parse(data[8]);
                Seller seller = new Seller(Integer.parseInt(data[9]),data[10],data[11]);
                Chategory chategory = new Chategory(Integer.parseInt(data[12]),data[13]); 

                Ad ad = new Ad(area, chategory, createdAt, description, floors, freeOfCharge, id, imageUrl, latLong, rooms, seller);
                adatok.add(ad);
            }
            
        }catch (IOException e) {
        System.out.println("Hiba a fájl olvasása során!");
}
        return adatok;
    }

     double DistanceTo(double x, double y){

        String [] xy = this.Latlong.split(",");
        double dx = Double.parseDouble(xy[0]) - x;
        double dy = Double.parseDouble(xy[1]) - y;

       return Math.sqrt((dx*dx)+(dy*dy));

    }

    
    
    
    
}
