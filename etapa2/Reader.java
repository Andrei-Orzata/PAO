
import com.sun.jdi.connect.Connector;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {

    public void readBids(List<Bid>bids) throws FileNotFoundException {

        Scanner scan = new Scanner(new File("text\\bid.text"));

        scan.nextLine();
        scan.useDelimiter("\n");


        while (scan.hasNext())
        {
            String line = scan.next();
            String[] elem = line.split(",");

            Utilizator user = new Utilizator(elem[0],elem[1]);
            Bid bid = new Bid(user,Integer.parseInt(elem[2].strip()));
            bids.add(bid);

        }

        scan.close();

    }

    public void readLicitatie(Licitatie auction) throws FileNotFoundException {

        Scanner scan = new Scanner(new File("text\\licitatie.text"));

        scan.nextLine();
        scan.useDelimiter("\n");


        while (scan.hasNext()) {
            String line = scan.next();
            String[] elem = line.split(",");


            Utilizator user = new Utilizator(elem[0], elem[1]);
            int price = Integer.parseInt(elem[2]);
            Produs item = new Produs(Integer.parseInt(elem[3]), elem[4]);
            Bid bid = new Bid(user, price);
            auction.addUtilizatorBid(bid, item);

        }
        scan.close();

    }

    public void readProduse(List<Produs> items) throws FileNotFoundException {

        Scanner scan = new Scanner(new File("text\\produs.text"));

        scan.nextLine();
        scan.useDelimiter("\n");


        while (scan.hasNext())
        {
            String line = scan.next();
            String[] elem = line.split(",");

            Produs item = new Produs(Integer.parseInt(elem[0]),elem[1]);
            items.add(item);

        }
        scan.close();

    }
    public void readUtilizatori(List<Utilizator> users) throws FileNotFoundException {

        Scanner scan = new Scanner(new File("text\\utilizator.text"));

        scan.nextLine();
        scan.useDelimiter("\n");


        while (scan.hasNext())
        {
            String line = scan.next();
            String[] elem = line.split(",");

            Utilizator user = new  Utilizator(elem[0],elem[1]);
            users.add(user);

        }
        scan.close();

    }
}
