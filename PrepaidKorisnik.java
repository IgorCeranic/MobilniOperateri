package ZadatakMobilniOperateri;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PrepaidKorisnik extends Korisnik{

    double kredit;


    public PrepaidKorisnik(MobilniOperater mobilniOperater, String ime, String prezime, String brojTelefona, String adresa) {
        super(mobilniOperater, ime, prezime, brojTelefona, adresa);
    }

    public double getKredit() {
        return kredit;
    }

    public void setKredit(double kredit){
        this.kredit = kredit;
    }

    @Override
    public String toString() {
        return "PrepaidKorisnik{" +
                "mobilniOperater=" + mobilniOperater.getImeOperatera() +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", brojTelefona='" + brojTelefona + '\'' +
                ", adresa='" + adresa + '\'' +
                ", kredit=" + kredit +
                '}';
    }


    public boolean obaviRazgovor(Korisnik korisnik,int brMinuta){
        double cijenaRazgovora = brMinuta * korisnik.getMobilniOperater().getCenaMinuta();

        if(this.kredit>=cijenaRazgovora){
            kredit = kredit - cijenaRazgovora;
            PrepaidKorisnik.this.setKredit(this.kredit);
            System.out.println("Poziv je obavljen... ostalo vam je jos " + kredit + " kredita");

                try (BufferedWriter buf = new BufferedWriter(new FileWriter(new File("C:\\Users\\Jukazuma\\Desktop\\Java progrmiranje podsjetnik\\LOG.txt"),true))) {
                    buf.write("Broj telefona pripejd korisnika je: " + korisnik.getBrojTelefona() + ", broj minuta razgovora je: " + brMinuta + "\n");
                    buf.newLine();

                } catch (IOException e) {
                    e.printStackTrace();
                }

//            try(FileWriter fw = new FileWriter("C:\\Users\\Jukazuma\\Desktop\\Java progrmiranje podsjetnik\\LOG.txt")){
//                fw.write("Brojevi telefona su: " + korisnik.getBrojTelefona() + " broj mminuta razgovora je: " + brMinuta + "\n");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

            return true;
        }
        else {
            System.out.println("Korisnik " + korisnik.getIme() + " " +  korisnik.getPrezime() + " nema dovoljno kredita za poziv...");
        }

        return true;
    }

    @Override
    public boolean posaljiPoruku(Korisnik korisnik,String tekstPoruke){
        if(this.kredit> korisnik.getMobilniOperater().getCenaPoruke()){
            kredit = kredit - korisnik.getMobilniOperater().getCenaPoruke();
            System.out.println("Poruka : " + tekstPoruke + " je uspjesno poslata, ostalo vam je jos kredita: "+kredit);
            try (BufferedWriter buf = new BufferedWriter(new FileWriter(new File("C:\\Users\\Jukazuma\\Desktop\\Java progrmiranje podsjetnik\\LOG.txt"),true))) {
                buf.write("Broj telefona prpejd korisnika je: " + korisnik.getBrojTelefona() + ", tekst poruke je: " + tekstPoruke + "\n");
                buf.newLine();

            } catch (IOException e) {
                e.printStackTrace();
            }

            return true;
        }
        else {
            System.out.println("Poruka nije poslata,nemate dovoljno kredita.");
            return false;
        }
    }

    @Override
    public boolean surfujNaInternetu(String url,int brMegabajta){
        double cijenaSesije = brMegabajta * mobilniOperater.getCenaMB();
        if(this.kredit>=cijenaSesije){
            kredit = kredit - cijenaSesije;
            System.out.println("Surfovanje na internetu.... ostalo je jos kredita: "+kredit);
            try (BufferedWriter buf = new BufferedWriter(new FileWriter(new File("C:\\Users\\Jukazuma\\Desktop\\Java progrmiranje podsjetnik\\LOG.txt"),true))) {
                buf.write("Broj telefona pripejd korisnika je: " + brojTelefona + ", korisceni url  je: " + url + "\n");
                buf.newLine();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Nemate dovoljno kredita za surfovanje.....");
        }
        return true;
    }

}
