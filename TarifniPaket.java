package ZadatakMobilniOperateri;

public class TarifniPaket {

   private int minuti,poruke,megabajti;
   private boolean biznis;
   private int cijena;

    public TarifniPaket(int minuti, int poruke, int megabajti, boolean biznis, int cijena) {
        this.minuti = minuti;
        this.poruke = poruke;
        this.megabajti = megabajti;
        this.biznis = biznis;
        this.cijena = cijena;
    }

    public int getMinuti() {
        return minuti;
    }

    public void setMinuti(int minuti) {
        this.minuti = minuti;
    }

    public int getPoruke() {
        return poruke;
    }

    public void setPoruke(int poruke) {
        this.poruke = poruke;
    }

    public int getMegabajti() {
        return megabajti;
    }

    public void setMegabajti(int megabajti) {
        this.megabajti = megabajti;
    }

    public boolean isBiznis() {
        return biznis;
    }

    public void setBiznis(boolean biznis) {
        this.biznis = biznis;
    }

    public int getCijena() {
        return cijena;
    }

    public void setCijena(int cijena) {
        this.cijena = cijena;
    }

    @Override
    public String toString() {
        return "TarifniPaket{" +
                "minuti=" + minuti +
                ", poruke=" + poruke +
                ", megabajti=" + megabajti +
                ", biznis=" + biznis +
                ", cijena=" + cijena +
                '}';
    }
}
