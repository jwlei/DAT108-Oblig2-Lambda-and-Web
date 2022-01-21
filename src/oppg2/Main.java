package oppg2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;



public class Main{

    private static final int FAST_TILLEGG = 10000;
    private static final int PROSENT = 7;
    private static final int OEK_LAV_LONN = 25000;
    private static final int LAV_LONN = 400000;
    private static final int ER_MANN = 30;

    public static void main(String[] args) {


        List<oppg2.Ansatt> ansatte = Arrays.asList(
                new oppg2.Ansatt("Aharles", "Dickens", oppg2.Kjonn.MANN, "Sjef", 900000),
                new oppg2.Ansatt("Lewis", "Carroll", oppg2.Kjonn.MANN, "Kokk", 400000),
                new oppg2.Ansatt("Thomas", "Carlyle", oppg2.Kjonn.MANN, "Servitoer", 350000),
                new oppg2.Ansatt("Charlotte", "Bronte", oppg2.Kjonn.KVINNE, "Kokk", 420000),
                new oppg2.Ansatt("Matthew", "Arnold", oppg2.Kjonn.MANN, "Servitoer", 370000));

        //1) Fast tillegg
        Function<oppg2.Ansatt, Integer> fastTillegg = ansatt -> ansatt.getAarslonn() + FAST_TILLEGG;

        //2) Prosenttillegg
        Function<oppg2.Ansatt, Integer> prosentTillegg = ansatt -> (int) ansatt.getAarslonn() + ((ansatt.getAarslonn()/100) * PROSENT);

        //3) Tillegg for ansatt med lav lønn
        Function<oppg2.Ansatt, Integer> lavLonn = ansatt -> ansatt.getAarslonn() <= LAV_LONN ? ansatt.getAarslonn() + OEK_LAV_LONN : ansatt.getAarslonn();

        //4) Prosent tillegg for mann
        Function<oppg2.Ansatt, Integer> manneLonn = ansatt -> ansatt.erMann() ? (int)(ansatt.getAarslonn() + (ansatt.getAarslonn()/100) * ER_MANN) : ansatt.getAarslonn();



        System.out.println("Før endringer: " + "\n" + ansatte + "\n");
        lonnsoppgjor(ansatte, fastTillegg);
        System.out.println("Etter fast tillegg: " + "\n" + ansatte + "\n");
        lonnsoppgjor(ansatte, prosentTillegg);
        System.out.println("Etter prosenttillegg: " + "\n" + ansatte + "\n");
        lonnsoppgjor(ansatte, lavLonn);
        System.out.println("Etter økning for de med lav lønn: " + "\n" + ansatte + "\n");
        lonnsoppgjor(ansatte, manneLonn);
        System.out.println("Etter tillegg for menn: " + "\n" + ansatte + "\n");



    }
    private static void lonnsoppgjor(List<oppg2.Ansatt> ansatte, Function<oppg2.Ansatt, Integer> lonn) {

        ansatte.forEach(ansatt -> ansatt.setAarslonn(lonn.apply(ansatt)));
    }
}




