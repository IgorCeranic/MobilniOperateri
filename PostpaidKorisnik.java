package ZadatakMobilniOperateri;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class PostpaidKorisnik extends Korisnik implements  IzradaRacuna{

    double stanje;
    TarifniPaket tarifniPaket;

    ArrayList<TarifniDodatak> tarifniDodaci = new ArrayList<>();
    //ArrayList<? extends  Korisnik> postpaidFizLica = new ArrayList<>();

    public PostpaidKorisnik(MobilniOperater mobilniOperater, String ime, String prezime, String brojTelefona, String adresa,TarifniPaket tarifniPaket) {
        super(mobilniOperater, ime, prezime, brojTelefona, adresa);
        this.tarifniPaket = tarifniPaket;

    }

    public double getStanje() {
        return stanje;
    }
    public TarifniPaket getTarifniPaket(){
        return tarifniPaket;
    }

    public List <TarifniDodatak> getTarifniDodatak(){
        return tarifniDodaci;
    }

    @Override
    public String toString() {
        return "PostpaidKorisnik{" +
                "mobilniOperater=" + mobilniOperater +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", brojTelefona='" + brojTelefona + '\'' +
                ", adresa='" + adresa + '\'' +
                ", stanje=" + stanje +
                '}';
    }


    @Override
    public String generisiRacun() {
        return "Fiksna cijena paketa za korisnika " + this.toString() +  " je: " + tarifniPaket.getCijena()+ " e"+
                ", a prekoracenje iznosi: " + stanje + "e. " +
                " Ukupni racun iznosi: " + ukupnoZaNaplatu();
    }


    public void dodajTarifniDodatak(TarifniDodatak tarifniDodatak){
        tarifniDodaci.add(tarifniDodatak);
        stanje +=tarifniDodatak.getCijenaDodatka();
        System.out.println("Dodat je tarifni dodatak: " + tarifniDodatak.getTipTarifnogDodatka() +" po cijeni od: "+tarifniDodatak.getCijenaDodatka() +"e");
    }


    public double ukupnoZaNaplatu(){
        double ukupnaCijena = 0;
        if(tarifniDodaci.size()>0) {
            for (int i = 0; i < tarifniDodaci.size(); i++) {
                ukupnaCijena = tarifniPaket.getCijena() + stanje + tarifniDodaci.get(i).getCijenaDodatka();
            }
        }
        else{
            ukupnaCijena = tarifniPaket.getCijena() + stanje;
        }
        return ukupnaCijena;
    }

    public  boolean obaviRazgovor (Korisnik korisnik,int brMinuta){
            int minuti;
            if(this.tarifniPaket.getMinuti()>=brMinuta){
                minuti =  tarifniPaket.getMinuti() - brMinuta;
                this.tarifniPaket.setMinuti(minuti);
                System.out.println("Razgovor obavljen. " + " Preostalo minuta iz pretplate: " + tarifniPaket.getMinuti() );
                return true;
            }
            else if(this.tarifniPaket.getMinuti()<brMinuta){
                minuti =  tarifniPaket.getMinuti() - brMinuta;
                double razlika = (brMinuta * korisnik.getMobilniOperater().getCenaMinuta() - tarifniPaket.getMinuti()) * korisnik.getMobilniOperater().getCenaMinuta();
                this.stanje = stanje +  razlika;
                this.tarifniPaket.setMinuti(minuti);
                System.out.println("Potrosili ste sve minute iz pretplate!" + "\n Stanje se povecalo za potrosenih " + minuti + " minuta!");
            }
        try (BufferedWriter buf = new BufferedWriter(new FileWriter(new File("C:\\Users\\Jukazuma\\Desktop\\Java progrmiranje podsjetnik\\LOG.txt"),true))) {
            buf.write("Broj telefona postpejd korisnika je: " + brojTelefona + ", potrosenih minuta je: " + brMinuta + "\n");
            buf.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

      return true;
    }



    public boolean posaljiPoruku(Korisnik korisnik,String tekstPoruke){
       if(!tarifniDodaci.isEmpty()) {
           for (int i = 0; i < tarifniDodaci.size(); i++) {
               if (tarifniDodaci.get(i).getTipTarifnogDodatka().equals(TipTarifnogDodatka.SMS_DODATAK)) {
                   System.out.println("Imate SMS dodatak, poruka uspjesno poslata...");
               }
               else{
                   if (tarifniPaket.getPoruke() < 1) {
                       this.stanje = stanje + korisnik.getMobilniOperater().getCenaPoruke();
                       System.out.println("Poruka poslata,stanje na racunu je uvecano za cijenu poruke......");
                   }
                   else{
                       int porukaManje = tarifniPaket.getPoruke() - 1;
                       tarifniPaket.setPoruke(porukaManje);
                       System.out.println("Poruka poslataaaaaa.");

                   }
               }
           }
       }

       else if (tarifniPaket.getPoruke() < 1) {
           this.stanje = stanje + korisnik.getMobilniOperater().getCenaPoruke();
           System.out.println("Poruka poslata,stanje na racunu je uvecano za cijenu poruke......");
            }

       else {
           int porukaManje = tarifniPaket.getPoruke() - 1;
           tarifniPaket.setPoruke(porukaManje);
           System.out.println("Poruka poslataaaaaa.");
        }
        try (BufferedWriter buf = new BufferedWriter(new FileWriter(new File("C:\\Users\\Jukazuma\\Desktop\\Java progrmiranje podsjetnik\\LOG.txt"),true))) {
            buf.write("Broj telefona postpejd korisnika je: " + brojTelefona + ", tekst poruke je: " + tekstPoruke + "\n");
            buf.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
       return true;
    }


    public boolean surfujNaInternetu(String url,int brMegabajta){

        if (!tarifniDodaci.isEmpty() ) {
            for (int i = 0; i < tarifniDodaci.size(); i++) {
                if (tarifniDodaci.get(i).getTipTarifnogDodatka().equals(TipTarifnogDodatka.INTERNET_DODATAK)) {
                    System.out.println("Koristite internet sa zadovoljstvom.....");
                }
                else {
                    if(brMegabajta>tarifniPaket.getMegabajti()){
                        double razlikaMB = brMegabajta - tarifniPaket.getMegabajti();
                        stanje = stanje + razlikaMB * mobilniOperater.getCenaMB();
                        tarifniPaket.setMegabajti(0);
                        System.out.println("Koristili ste internet van paketa i to "  + razlikaMB + "MB, stanje na racunu se povecalo...");
                    }
                    else {
                        int mbManje = tarifniPaket.getMegabajti() - brMegabajta;
                        tarifniPaket.setMegabajti(mbManje);
                        System.out.println("Koristili ste internet...");
                    }
                }
            }
        }

        else if(brMegabajta>tarifniPaket.getMegabajti()){
            double razlikaMB = brMegabajta - tarifniPaket.getMegabajti();
            stanje = stanje + razlikaMB * mobilniOperater.getCenaMB();
            tarifniPaket.setMegabajti(0);
            System.out.println("Koristili ste internet van paketa i to "  + razlikaMB + "MB, stanje na racunu se povecalo...");
        }

        else {
            int mbManje = tarifniPaket.getMegabajti() - brMegabajta;
            tarifniPaket.setMegabajti(mbManje);
            System.out.println("Koristili ste internet...");
        }

        try (BufferedWriter buf = new BufferedWriter(new FileWriter(new File("C:\\Users\\Jukazuma\\Desktop\\Java progrmiranje podsjetnik\\LOG.txt"),true))) {
            buf.write("Broj telefona postpejd korisnika je: " + brojTelefona + ", korisceni url je: " + url + "\n");
            buf.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }


    }




