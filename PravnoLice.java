package ZadatakMobilniOperateri;

import java.util.ArrayList;

public class PravnoLice implements Comparable<PravnoLice>,IzradaRacuna {

    int id;
    String imePravnogLica;
    ArrayList<PostpaidKorisnik> postpaidKorisnici = new ArrayList<>();

    public PravnoLice(int id, String imePravnogLica) {
        this.id = id;
        this.imePravnogLica = imePravnogLica;
    }

    public int getId(){
        return id;
    }

    public String getImePravnogLica(){
        return imePravnogLica;
    }

    @Override
    public String toString() {
        return "PravnoLice{" +
                "id='" + id + '\'' +
                ", imePravnogLica='" + imePravnogLica + '\'' +
                '}';
    }

    @Override
    public int compareTo(PravnoLice o) {
        if(this.id > o.id){
            return 1;
        }
        else if(this.id < o.id){
            return -1;
        }
        return 0;

    }

    @Override
    public String generisiRacun() {
        double zbirniRacun = 0;
        for(PostpaidKorisnik pp:postpaidKorisnici){
            if(pp.tarifniPaket.isBiznis()){
                zbirniRacun = zbirniRacun +  pp.tarifniPaket.getCijena() + pp.stanje;
            }
        }
        System.out.println("Ukupni racun pravnog lica " + getImePravnogLica() + " je " + zbirniRacun + " eura");
        return  "Racun generisan";
    }



    public void dodajKorisnika(PostpaidKorisnik postpaidKorisnik){
        if(!postpaidKorisnici.contains(postpaidKorisnik)) {
            if (postpaidKorisnik.getTarifniPaket().isBiznis() == true) {
                postpaidKorisnici.add(postpaidKorisnik);
            }
            else{
                System.out.println("Korisnikov postpaid racun nije biznis, ne mozete ga dodati u pravna lica...");
            }
        }
        else{
            System.out.println("Postpaid korisnik " + postpaidKorisnik.getIme() +  " je vec dodat kao korisnik u ovoj firmi!");
        }

    }

}
