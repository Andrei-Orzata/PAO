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
import java.util.Scanner;


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

                        Scanner scanner = new Scanner(System.in);

                       //while (true) {
                        System.out.println("Afisare Bids '1' ");
                        System.out.println("Afisare Utilizator '2' ");
                        System.out.println("Afisare Produse '3'");
                        System.out.println("Afisare Bid Castigator pe Produs '4' ");
                        System.out.println("Afisare Toate Bid-urile unui Produs '5'");
                        System.out.println("Afisare Toate Produsele unui Utilizator '6'");
                                String option = scanner.next();

                                switch (option) {


                                        case "1":
                                                reader.readBids(bids);
                                                audit.write("readBids", LocalDateTime.now());
                                                for (Bid b : bids)
                                                        System.out.println(b);

                                                writer.writeBids(bids);
                                                audit.write("writeBids", LocalDateTime.now());
                                        case "2":
                                                reader.readUtilizatori(users);
                                                audit.write("readUtilizatori", LocalDateTime.now());
                                                for (Utilizator u : users)
                                                        System.out.println(u);

                                                writer.writeUtilizatori(users);
                                                audit.write("writeUtilizatori", LocalDateTime.now());
                                        case "3":
                                                reader.readProduse(items);
                                                audit.write("readProduse", LocalDateTime.now());
                                                for (Produs it : items)
                                                        System.out.println(it);

                                                writer.writeProduse(items);
                                                audit.write("writeProduse", LocalDateTime.now());
                                        case "4":
                                                //Bid b = auction.getBidFinalProdus("")
                                                //System.out.println(b);
                                        case "5":
                                                // Array<Bids> bids = auction.getAllBidsProdus("")
                                                // for(Bid b : bids)
                                                //System.out.println(b);
                                        case "6":
                                                //List<Produs> items = auction.getAllProdusUtilizator("")
                                                //for(Produs i : items)
                                                //System.out.println(i);

                                        default:
                                                System.out.println("Invalid option");














                                }


                       //}




                }
                catch(IOException e)
                {
                System.out.println(e);
                }
        }



}
