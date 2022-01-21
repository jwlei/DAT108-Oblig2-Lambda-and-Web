package oppg3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.lang.Integer;



public class Main{
    public static void main(String[] args) {


        List<oppg3.Ansatt> ansatte = Arrays.asList(
                    new oppg3.Ansatt("Charles", "Dickens", oppg3.Kjonn.MANN, "Sjef", 900000),
                    new oppg3.Ansatt("Lewis", "Carroll", oppg3.Kjonn.MANN, "Kokk", 400000),
                    new oppg3.Ansatt("Thomas", "Carlyle", oppg3.Kjonn.MANN, "Servitoer", 350000),
                    new oppg3.Ansatt("Charlotte", "Bronte", oppg3.Kjonn.KVINNE, "Kokk", 420000),
                    new oppg3.Ansatt("Matthew", "Arnold", oppg3.Kjonn.MANN, "Servitoer", 370000));


//Oppg 3a
        List <String> listeAvEtternavn = ansatte.stream()
                    .map(p -> p.getEtterNavn())
                    .collect(Collectors.toList());

                    System.out.println(listeAvEtternavn);

//Oppg 3b
        long count = ansatte.stream()
                    .filter(p -> p.getKjonn().equals(oppg3.Kjonn.KVINNE))
                    .count();
                    System.out.println("Det er " + count + " antall kvinn(er) som jobber på resturanten");

//Oppg 3c
        ansatte.stream()
                    .filter(p -> p.getKjonn().equals(oppg3.Kjonn.KVINNE))
                    .mapToInt(i -> i.getAarslonn())
                    .average()
                    .ifPresent(avg -> System.out.println("Gjennomsnittslønnen for kvinner er \n" + avg));

//Oppg 3d
        System.out.println("Før: \n" + ansatte);
                    ansatte.stream()
                    .filter(a -> a.getStilling().toLowerCase().contains("sjef"))
                    .forEach(a -> a.setAarslonn((int)(a.getAarslonn() * (1.07))));
                    System.out.println("Etter lønnsøkning på 7% for sjefer: \n" + ansatte);

//Oppg 3e
        boolean lonnover = ansatte.stream()
                    .mapToInt(i -> i.getAarslonn())
                    .anyMatch(i -> i > 800000);
                    System.out.println("Det er [" + lonnover + "] at noen har lønn over 800.000,-\n");


//Oppg 3f
        System.out.println("Skriver ut uten løkke:\n");
                    ansatte.stream()
                    .forEach(System.out::println);
        System.out.println("\n");



//Oppg 3g
        oppg3.Ansatt min = ansatte.stream()
                    .collect(Collectors.minBy(
                            Comparator.comparingInt(oppg3.Ansatt::getAarslonn)))
                    .get();
                    System.out.println("Den ansatte med minstelønn er:\n" + min);


//Oppg 3h
        int[] tallrekke = IntStream.range(1, 1001).toArray();
        int sumdeleligpaabegge = Arrays.stream(tallrekke)
                    .filter(i -> i % 3 == 0)
                    .filter(i -> i % 5 == 0)
                    .sum();


        int sum3 = Arrays.stream(tallrekke)
                    .filter(i -> i % 3 == 0)
                    .sum();
        int sum5 = Arrays.stream(tallrekke)
                .filter(i -> i % 5 == 0)
                .sum();


        System.out.println(sum3 + sum5 - sumdeleligpaabegge);

        }

    }


