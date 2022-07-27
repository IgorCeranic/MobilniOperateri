package ZadatakMobilniOperateri;

public class TarifniDodatak {

    double cijenaDodatka;
    TipTarifnogDodatka tipTarifnogDodatka;

    public TarifniDodatak(double cijenaDodatka, TipTarifnogDodatka tipTarifnogDodatka) {
        this.cijenaDodatka = cijenaDodatka;
        this.tipTarifnogDodatka = tipTarifnogDodatka;
    }

    public double getCijenaDodatka() {
        return cijenaDodatka;
    }

    public TipTarifnogDodatka getTipTarifnogDodatka() {
        return tipTarifnogDodatka;
    }

    @Override
    public String toString() {
        return "TarifniDodatak{" +
                "cijenaDodatka=" + cijenaDodatka +
                ", tipTarifnogDodatka=" + tipTarifnogDodatka +
                '}';
    }
}
