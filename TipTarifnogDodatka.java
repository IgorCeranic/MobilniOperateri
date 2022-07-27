package ZadatakMobilniOperateri;

public enum TipTarifnogDodatka {
    SMS_DODATAK, INTERNET_DODATAK;

    public String toString(){
        switch (this){
            case SMS_DODATAK: return "SMS DODATAK";
            case INTERNET_DODATAK: return "INTERNET DODATAK";
            default: return "Nepoznati tarifni dodatak...";
        }
    }
}
