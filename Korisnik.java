package ZadatakMobilniOperateri;

abstract class Korisnik {
    MobilniOperater mobilniOperater;
    String ime;
    String prezime;
    String brojTelefona;
    String adresa;
    PostpaidKorisnik postpaidKorisnik;

    public Korisnik(MobilniOperater mobilniOperater, String ime, String prezime, String brojTelefona, String adresa) {
        this.mobilniOperater = mobilniOperater;
        this.ime = ime;
        this.prezime = prezime;
        this.brojTelefona = brojTelefona;
        this.adresa = adresa;
    }


    public MobilniOperater getMobilniOperater() {
        return mobilniOperater;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public String getAdresa() {
        return adresa;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "mobilniOperater=" + mobilniOperater +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", brojTelefona='" + brojTelefona + '\'' +
                ", adresa='" + adresa + '\'' +
                '}';
    }



    public abstract boolean obaviRazgovor(Korisnik korisnik, int brMinuta);
    public abstract boolean posaljiPoruku(Korisnik korisnik, String tekstPoruke);
    public abstract boolean surfujNaInternetu(String url, int brMegabajta);
}
