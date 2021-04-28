import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer {

    public void writeBids(List<Bid> bids) throws IOException {

        FileWriter file = new FileWriter("text\\bid.text");

        file.write("Nume,Prenume,Pret\n");

        for (Bid b : bids)
        {
            StringBuilder line = new StringBuilder();
            String[] elem = b.toString().replace("Utilizator: Nume: ","")
                    .replace("|| Bid price: ","")
                    .split(" ");
            line.append(elem[0]);
            line.append(',');
            line.append(elem[1]);
            line.append(',');
            line.append(elem[2]);
            line.append('\n');
            file.write(line.toString());

        }
        file.close();

    }
    public void extendLicitatie(Licitatie auction, Bid bid, Produs item) throws IOException {

        FileWriter file = new FileWriter("text\\licitatie.text",true);
        auction.addUtilizatorBid(bid,item);

        StringBuilder line = new StringBuilder();
        String[] elem = bid.toString().replace("Utilizator: Nume: ","")
                .replace("|| Bid price: ","")
                .split(" ");
        line.append(elem[0]);
        line.append(',');
        line.append(elem[1]);
        line.append(',');
        line.append(elem[2].strip());
        line.append(',');
        String[] prod = item.toString().replace("ID: ","")
                .replace("|| Nume: ","")
                .split(" ");
        line.append(prod[0].strip());
        line.append(',');
        line.append(prod[1].strip());
        line.append('\n');
        file.write(line.toString());
        file.close();

    }
    public void writeProduse(List<Produs> items) throws IOException {

        FileWriter file = new FileWriter("text\\produs.text");

        file.write("ID,Pret\n");

        for (Produs it : items)
        {
            StringBuilder line = new StringBuilder();
            String[] prod = it.toString().replace("ID: ","")
                    .replace("|| Nume: ","")
                    .split(" ");
            line.append(prod[0].strip());
            line.append(',');
            line.append(prod[1].strip());
            line.append('\n');
            file.write(line.toString());

        }
        file.close();

    }

    public void writeUtilizatori(List<Utilizator> users) throws IOException {

        FileWriter file = new FileWriter("text\\utilizatori.text");

        file.write("Nume,Prenume\n");

        for (Utilizator u : users)
        {
            StringBuilder line = new StringBuilder();
            String[] elem = u.toString().replace("Nume: ","")
                    .split(" ");
            line.append(elem[0]);
            line.append(',');
            line.append(elem[1]);
            line.append('\n');
            file.write(line.toString());

        }
        file.close();

    }
}
