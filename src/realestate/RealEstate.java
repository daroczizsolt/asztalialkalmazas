
package realestate;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RealEstate {
    public static void main(String[] args) throws IOException {
      List<Double> tavok = new ArrayList<>();
      int fszAlapterulet = 0;
      int fszdb = 0;
      for (Ad ad : Ad.LoadFromCsv("realestates.csv")) {
                if (ad.getFloors() == 0){
                    fszAlapterulet += ad.getArea();
                    fszdb += 1;
                }
                Double tav = ad.DistanceTo(47.4164220114023,19.066342425796986);
                tavok.add(tav);
          //System.out.println(ad.getSeller().getName());
            }
       double atlag = (double)fszAlapterulet/fszdb;
       DecimalFormat f = new DecimalFormat("#.##");
       System.out.println("A földszinti ingatlanok átlagos alapterülete: "+f.format(atlag) +" cm2.");
       int index = 0;
       double min = tavok.get(0);
        for (int i = 0; i < tavok.size(); i++) {
            if (tavok.get(i) < min){
                min = tavok.get(i);
                index = i;
            }
        }
        System.out.println("Mesvár óvodához légvonalban legközelebbi tehermentes ingatlan adatai:");
        System.out.println("Eladó neve:"+Ad.LoadFromCsv("realestates.csv").get(index).getSeller().getName());
        System.out.println("Eladó telefonja:"+Ad.LoadFromCsv("realestates.csv").get(index).getSeller().getPhone());
        System.out.println("Alapterület:"+Ad.LoadFromCsv("realestates.csv").get(index).getArea());
        System.out.println("Szobák száma:"+Ad.LoadFromCsv("realestates.csv").get(index).getRooms());

    }
    

    
}
