import java.lang.reflect.WildcardType;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class LicitatieMain {

        public static void main(String[] args) {
                try {
                        Audit audit = new Audit();
                        Reader reader = new Reader();
                        Writer writer = new Writer();

                        List <Produs>  items = new ArrayList<Produs>();
                        List <Utilizator> users = new ArrayList<Utilizator>();
                        List <Bid>  bids = new ArrayList<Bid>();
                        Licitatie auction = new Licitatie();

                        reader.readLicitatie(auction);
                        audit.write("readLicitatie", LocalDateTime.now());
                        Utilizator U = new Utilizator("Mugur","Nemes");
                        Produs I = new Produs(15,"portret");

                        writer.extendLicitatie(auction, new Bid(U,100),I);
                        audit.write("ExtendLicitatie", LocalDateTime.now());

                        reader.readProduse(items);
                        audit.write("readProduse", LocalDateTime.now());
                        for (Produs it : items)
                                System.out.println(it);

                        writer.writeProduse(items);
                        audit.write("writeProduse", LocalDateTime.now());

                        reader.readUtilizatori(users);
                        audit.write("readUtilizatori", LocalDateTime.now());
                        for (Utilizator u : users)
                                System.out.println(u);

                        writer.writeUtilizatori(users);
                        audit.write("writeUtilizatori", LocalDateTime.now());

                        reader.readBids(bids);
                        audit.write("readBids", LocalDateTime.now());
                        for (Bid b : bids)
                                System.out.println(b);

                        writer.writeBids(bids);
                        audit.write("writeBids", LocalDateTime.now());



                }
                catch(IOException e)
                {
                System.out.println(e);
                }
        }



}
