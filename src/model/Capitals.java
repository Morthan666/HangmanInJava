package model;

import java.util.Random;

public class Capitals {

    public static String getCapital() {
        String[] capitals = {"ANDORRA LA VELLA", "AMSTERDAM", "ANKARA", "ASTANA", "ATHENS", "BAKU", "BELGRADE", "BERLIN", "BERN", "BRATISLAVA",
                "BRUSSELS", "BUCHAREST", "BUDAPEST", "CHISINAU", "COPENHAGEN", "DUBLIN", "HELSINKI", "KYIV", "LISBON", "LJUBLJANA",
                "LONDON", "LUXEMBOURG", "MADRID", "MINSK", "MONACO", "MOSCOW", "NICOSIA", "OSLO", "PARIS", "PODGORICA", "PRAGUE",
                "PRISTINA", "REYKJAVIK", "RIGA", "ROME", "SAN MARINO", "SARAJEVO", "SKOPJE", "SOFIA", "STOCKHOLM", "TALLINN",
                "TBILISI", "VADUZ", "VALLETTA", "VATICAN", "VIENNA", "VILNIUS", "WARSAW", "YEREVAN", "ZAGREB"};
        Integer randomIndex = new Random().nextInt(capitals.length);
        String capital = capitals[randomIndex];
        return capital;
    }

    public static String dashCapital(String capital) {
        String dashed = new String(new char[capital.length()]).replace("\0", "_");
        return dashed;
    }


}
