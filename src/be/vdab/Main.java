package be.vdab;

import be.vdab.winkel.Catalogus;
import be.vdab.winkel.Mandje;
import be.vdab.winkel.Product;

import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Catalogus catalogus = new Catalogus();
        Mandje mandje = new Mandje();

        int teller = 1;
        for (Product product : catalogus.getProducten()) {
            if (teller % 2 == 0) {
                mandje.add(product, teller);
            }
            teller++;
        }
        System.out.println("U kocht:");
        for (var entry : mandje.getMandje().entrySet()) {
            System.out.println(entry.getKey() + "; aantal stuks: " + entry.getValue());
        }
        System.out.println();
        System.out.println("Totale bedrag te betalen: " + mandje.getTotalePrijs());

    }
}
