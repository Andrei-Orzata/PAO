public class LicitatieMain {

        public static void main(String[] args) {

            Utilizator user1 = new Utilizator("Popescu", "Ion");
            Utilizator user2 = new Utilizator("Benga", "Ana");
            Utilizator user3 = new Utilizator("Constantinescu", "Radu");

            Produs item1 = new Produs(11, "lampa");
            Produs item2 = new Produs(12, "ceainic");
            Produs item3 = new Produs(13, "opera de arta");

            Licitatie auction = new Licitatie();

            auction.addUtilizatorBid(new Bid(user1,10), item1);
            auction.addUtilizatorBid(new Bid(user2,20), item1);
            auction.addUtilizatorBid(new Bid(user3,30), item1);
            auction.addUtilizatorBid(new Bid(user1,40), item1);
            auction.addUtilizatorBid(new Bid(user3,60), item1);

            auction.addUtilizatorBid(new Bid(user3,10), item2);
            auction.addUtilizatorBid(new Bid(user1,20), item2);
            auction.addUtilizatorBid(new Bid(user2,30), item2);

            auction.addUtilizatorBid(new Bid(user2,10), item3);
            auction.addUtilizatorBid(new Bid(user3,20), item3);
            auction.addUtilizatorBid(new Bid(user1,30), item3);
            auction.addUtilizatorBid(new Bid(user1,40), item3);
            auction.addUtilizatorBid(new Bid(user2,60), item3);

            System.out.








        }

}
