package ZadatakMobilniOperateri;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args){



        MobilniOperater mob1 = new MobilniOperater("Telekom",1.00,0.20,0.20);
        MobilniOperater mob2 = new MobilniOperater("Orion",1.41,0.11,0.3);
        MobilniOperater mob3 = new MobilniOperater("SBB",1.10,0.17,0.3);

        TarifniPaket tp1 = new TarifniPaket(500,1000,3000,true,29);
        TarifniPaket tp2 = new TarifniPaket(500,1500,4000,false,38);
        TarifniPaket tp3 = new TarifniPaket(1000,500,8000,true,50);
        TarifniPaket tp4 = new TarifniPaket(100,300,6000,false,18);
        TarifniPaket tp5 = new TarifniPaket(2000,2000,10000,true,44);
        TarifniPaket tp6 = new TarifniPaket(400,1000,10000,false,31);
        TarifniPaket tp7 = new TarifniPaket(300,100,2000,true,10);
        TarifniPaket tp8 = new TarifniPaket(500,300,6000,true,16);
        TarifniPaket tp9 = new TarifniPaket(300,100,2000,false,10);
        TarifniPaket tp10 = new TarifniPaket(600,400,5000,false,15);

        TarifniDodatak tarifniDodatak1 = new TarifniDodatak(15,TipTarifnogDodatka.INTERNET_DODATAK);
        TarifniDodatak tarifniDodatak2 = new TarifniDodatak(10,TipTarifnogDodatka.SMS_DODATAK);

        PostpaidKorisnik ppk1 = new PostpaidKorisnik(mob1,"Janko","Jankovic","123123","dfsfrsrfa",tp1);
        PostpaidKorisnik ppk2 = new PostpaidKorisnik(mob1,"Mirko","Mirkovic","345345","ewwewe",tp2);
        PostpaidKorisnik ppk3 = new PostpaidKorisnik(mob1,"Kiki","Micanovic","123123","jhytgs",tp3);
        PostpaidKorisnik ppk4 = new PostpaidKorisnik(mob1,"Zeljko","Bebek","456456","dyujthrs",tp4);
        PostpaidKorisnik ppk5 = new PostpaidKorisnik(mob1,"Toni","Colic","213124","djteyhs",tp5);
        PostpaidKorisnik ppk6 = new PostpaidKorisnik(mob1,"Dzej","Luis","8878978","fghdrgad",tp6);
        PostpaidKorisnik ppk7 = new PostpaidKorisnik(mob1,"Zeljko","Ristic","542123","kjljkl",tp7);
        PostpaidKorisnik ppk8 = new PostpaidKorisnik(mob1,"Balsa","Zugic","5541213","dqwertyu",tp8);
        PostpaidKorisnik ppk10 = new PostpaidKorisnik(mob1,"Milica","Drincic","55443","dafgdfggdf",tp7);
        PostpaidKorisnik ppk11 = new PostpaidKorisnik(mob1,"Jelena","Kosovic","35632","ghfdsw",tp3);
        PostpaidKorisnik ppk12 = new PostpaidKorisnik(mob1,"Milica","Drincic","6546456","ewrerw",tp10);
        PostpaidKorisnik ppk13 = new PostpaidKorisnik(mob1,"Jaksa","Djurovic","123323","dfsfrsrfa",tp3);
        PostpaidKorisnik ppk14= new PostpaidKorisnik(mob1,"Pero","Jankovic","123123","dfsfrsrfa",tp7);
        PostpaidKorisnik ppk15 = new PostpaidKorisnik(mob1,"Djordje","Kalabiv","123123","dfsfrsrfa",tp7);
        PostpaidKorisnik ppk16 = new PostpaidKorisnik(mob1,"Nikola","Ruzic","1224533","dfsfrsrfa",tp8);
        PostpaidKorisnik ppk17 = new PostpaidKorisnik(mob1,"Rade","Miljkovic","1267623","dfsfrsrfa",tp8);



        PrepaidKorisnik pripK2 = new PrepaidKorisnik(mob1,"Risto","Gagic","45345","dafgadg");
        PrepaidKorisnik pripK4 = new PrepaidKorisnik(mob1,"Balsa","Milutinov","67853","dtyybd");
        PrepaidKorisnik pripK5 = new PrepaidKorisnik(mob1,"Momir","Cikic","78678","fvtsgf");
        PrepaidKorisnik pripK6 = new PrepaidKorisnik(mob1,"Jaksa","Vucic","46575","fuyyvsa");
        PrepaidKorisnik pripK3 = new PrepaidKorisnik(mob1,"Boris","Nikolic","758467","asdfgeee");
        PrepaidKorisnik pripK7 = new PrepaidKorisnik(mob1,"Masa","Micovic","23456","dsdags");
        PrepaidKorisnik pripK8 = new PrepaidKorisnik(mob1,"Nina","Rosic","45432","gdvfgadc");


        PravnoLice pr1 = new PravnoLice(123,"Agromont");
        PravnoLice pr2 = new PravnoLice(342,"Luna");
        PravnoLice pr3= new PravnoLice(213,"MMS");
        PravnoLice pr4 = new PravnoLice(97,"Coinis");
        PravnoLice pr5 = new PravnoLice(321,"BuildStudio");
        PravnoLice pr6 = new PravnoLice(422,"Castelana");
        PravnoLice pr7 = new PravnoLice(432,"Rubin");
        PravnoLice pr8 = new PravnoLice(567,"Plantaze");
        PravnoLice pr9 = new PravnoLice(312,"Aroma");
        PravnoLice pr10 = new PravnoLice(786,"Megamarket");
        PravnoLice pr11 = new PravnoLice(221,"Kips");
        PravnoLice pr12 = new PravnoLice(554,"Beneton");
        PravnoLice pr13 = new PravnoLice(444,"ICT Cortex");


        pr1.dodajKorisnika(ppk1);
        pr1.dodajKorisnika(ppk2);
        pr1.dodajKorisnika(ppk3);                           //imenovanje postpaid korisnika medju pravna lica
        pr1.dodajKorisnika(ppk6);
        pr1.dodajKorisnika(ppk8);                       //dodaje samo lica koja imaju biznis tarifne pakete
        pr1.dodajKorisnika(ppk17);
        pr1.dodajKorisnika(ppk15);

        pr2.dodajKorisnika(ppk8);
        pr2.dodajKorisnika(ppk4);
        pr2.dodajKorisnika(ppk1);
        pr2.dodajKorisnika(ppk10);
        pr2.dodajKorisnika(ppk6);
        pr2.dodajKorisnika(ppk12);
        pr2.dodajKorisnika(ppk17);
        pr2.dodajKorisnika(ppk15);

        //pr2.dodajKorisnika(ppk10);                    //vec dodat

        pr3.dodajKorisnika(ppk3);
        pr3.dodajKorisnika(ppk8);
        pr3.dodajKorisnika(ppk1);
        pr3.dodajKorisnika(ppk2);
        pr3.dodajKorisnika(ppk16);
        pr3.dodajKorisnika(ppk14);

        pr4.dodajKorisnika(ppk1);
        pr4.dodajKorisnika(ppk11);
        pr4.dodajKorisnika(ppk4);
        pr4.dodajKorisnika(ppk10);
        pr4.dodajKorisnika(ppk7);
        pr4.dodajKorisnika(ppk3);
        pr4.dodajKorisnika(ppk16);
        pr4.dodajKorisnika(ppk14);

        pr6.dodajKorisnika(ppk12);
        pr6.dodajKorisnika(ppk5);
        pr6.dodajKorisnika(ppk7);
        pr6.dodajKorisnika(ppk10);
        pr6.dodajKorisnika(ppk2);
        pr6.dodajKorisnika(ppk6);
        pr6.dodajKorisnika(ppk13);
        pr6.dodajKorisnika(ppk17);


        mob1.pravnaLica.add(pr1);
        mob1.pravnaLica.add(pr2);
        mob1.pravnaLica.add(pr3);
        mob1.pravnaLica.add(pr4);
        mob1.pravnaLica.add(pr5);
        mob1.pravnaLica.add(pr7);
        mob1.pravnaLica.add(pr6);              //dodavanje pravnih lica u listu pravna lica(mobilni oper.)
        mob1.pravnaLica.add(pr8);
        mob1.pravnaLica.add(pr9);
        mob1.pravnaLica.add(pr10);
        mob1.pravnaLica.add(pr11);
        mob1.pravnaLica.add(pr12);
        mob1.pravnaLica.add(pr13);



//        pripK2.setKredit(120);
//        pripK3.setKredit(111);
//        pripK5.setKredit(40);
//        pripK8.setKredit(79);
//        pripK2.surfujNaInternetu("google.com",20);
//        pripK2.obaviRazgovor(pripK2,10);
//        pripK3.obaviRazgovor(pripK3,19);
//        pripK5.obaviRazgovor(pripK5,32);
//        pripK8.obaviRazgovor(pripK8,7);
//        pripK2.posaljiPoruku(pripK2," cao, sta radis?");
//        System.out.println(pripK2);





//********************************************************************************************************

//        System.out.println(ppk1.getTarifniPaket());
//        ppk1.dodajTarifniDodatak(tarifniDodatak1);
//        ppk1.obaviRazgovor(ppk1,136);
//        System.out.println(ppk1.getTarifniPaket().getMinuti());
//        ppk1.obaviRazgovor(ppk1,54);
//        ppk1.dodajTarifniDodatak(tarifniDodatak2);
//        System.out.println(ppk1.getTarifniPaket().getMinuti());
//        ppk1.obaviRazgovor(ppk1,320);
//        System.out.println(ppk1.getTarifniPaket().getMinuti());
//        System.out.println(ppk1.generisiRacun());
//        System.out.println(ppk1.ukupnoZaNaplatu());

        //ppk1.dodajTarifniDodatak(tarifniDodatak2);
//        ppk1.posaljiPoruku(ppk1,"asdas");
//        System.out.println(ppk1.getTarifniPaket());
//        ppk1.posaljiPoruku(ppk1,"dasd");
//        ppk1.posaljiPoruku(ppk1,"sdsfdg");
//        System.out.println(ppk1.getTarifniPaket());
//        ppk1.dodajTarifniDodatak(tarifniDodatak2);
//
//        for(int i = 0;i<1010;i++){
//            ppk1.posaljiPoruku(ppk1,"asdwfrw");
//        }
//        ppk1.dodajTarifniDodatak(tarifniDodatak1);
//        System.out.println(ppk1.generisiRacun());

//
        ppk1.dodajTarifniDodatak(tarifniDodatak1);
        ppk1.surfujNaInternetu("google.com",213);
        System.out.println(ppk1.getTarifniPaket());
        ppk1.surfujNaInternetu("yahoo.com",3100);
        System.out.println(ppk1.getTarifniDodatak());
        System.out.println(ppk1.getTarifniPaket());
        System.out.println(ppk1.generisiRacun());

        ppk2.posaljiPoruku(ppk2,"Dje si komso,Ocemo li rakije?");
        ppk2.surfujNaInternetu(" kako komsiju natjerati da pije.com",394);
        ppk4.obaviRazgovor(ppk4,32);
        ppk5.posaljiPoruku(ppk5,"hej ho lets go...");
        ppk6.posaljiPoruku(ppk6,"vidji vraga su sedam binjisah");
        ppk5.obaviRazgovor(ppk5,12);



//          mob1.prikazPravnihLica();
//          mob1.dodajFizickoLice(ppk2);
//          mob1.dodajFizickoLice(ppk4);
//          mob1.dodajFizickoLice(pripK2);
//          mob1.dodajFizickoLice(ppk1);
//          mob1.dodajFizickoLice(ppk13);
//          mob1.dodajFizickoLice(ppk15);
//          mob1.dodajFizickoLice(pripK7);


         //mob1.generisiRacune();           //djelimicno radi


//        pr4.dodajKorisnika(ppk4);
//        pr4.dodajKorisnika(ppk1);
//        pr4.generisiRacun();
//        pr6.generisiRacun();
//        mob1.generisiRacune();

    }
}
