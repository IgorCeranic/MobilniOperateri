package ZadatakMobilniOperateri;

import java.util.ArrayList;
import java.util.Collections;


public class MobilniOperater {
    String imeOperatera;
    double cenaMinuta,cenaPoruke,cenaMB;
    ArrayList<PravnoLice> pravnaLica ; //= new ArrayList<>();
    ArrayList<Korisnik> fizickaLica; //= new ArrayList<>();
    //Korisnik korisnik;

    public MobilniOperater(String imeOperatera, double cenaMinuta, double cenaPoruke, double cenaMB) {
        this.imeOperatera = imeOperatera;
        this.cenaMinuta = cenaMinuta;
        this.cenaPoruke = cenaPoruke;
        this.cenaMB = cenaMB;
        this.pravnaLica = new ArrayList<>();
        this.fizickaLica = new ArrayList<>();
    }

    public String getImeOperatera() {
        return imeOperatera;
    }

    public double getCenaMinuta() {
        return cenaMinuta;
    }

    public double getCenaPoruke() {
        return cenaPoruke;
    }

    public double getCenaMB() {
        return cenaMB;
    }

    @Override
    public String toString() {
        return "MobilniOperater{" +
                "imeOperatera='" + imeOperatera + '\'' +
                ", cenaMinuta=" + cenaMinuta +
                ", cenaPoruke=" + cenaPoruke +
                ", cenaMB=" + cenaMB +
                '}';
    }




    public void generisiRacune(){
        System.out.println("Racuni pravnih lica su: \n");
        for(PravnoLice korisnik:pravnaLica){
            korisnik.generisiRacun();
        }
        System.out.println("Racuni fizickih postpaid lica su: \n");
        for(Korisnik korisnik:fizickaLica){                             // gr
            if(korisnik instanceof PostpaidKorisnik){
                ((PostpaidKorisnik) korisnik).generisiRacun();
            }
        }
    }

    public void dodajFizickoLice(Korisnik noviKorisnik){

            if(!fizickaLica.contains(noviKorisnik)) {
                if (noviKorisnik instanceof PostpaidKorisnik) {
                    if (((PostpaidKorisnik) noviKorisnik).getTarifniPaket().isBiznis() == false) {
                        fizickaLica.add(noviKorisnik);
                        System.out.println("Dodat novi postpejd korisnik kao fizicko lice.");

                    } else {
                        System.out.println("Korisnik nije dodat jer ima biznis paket...");
                    }

                } else {
                    fizickaLica.add(noviKorisnik);
                    System.out.println("Fizicko lice je dodato u listu");
                }
            }
            else{
                System.out.println("Neuspjesno dodavanje, korisnik je vec dodat ili ima biznis paket...");
            }

    }

    public void prikazPravnihLica(){
        Collections.sort(pravnaLica);
        for(PravnoLice pr:pravnaLica){
            System.out.println("Pravno lice " + pr.getImePravnogLica() +" sa ID borjem - " + pr.getId()+ " se nalazi na listi pravnih lica.");
        }
    }

}
