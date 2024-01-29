package be.vdab.winkel;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private String omschrijving;
    private BigDecimal prijs;

    public Product(String omschrijving, BigDecimal prijs) {
        setOmschrijving(omschrijving);
        setPrijs(prijs);
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public final void setOmschrijving(String omschrijving) {
        if (omschrijving.isBlank()) {
            throw new IllegalArgumentException("omschrijving moet ingevuld worden");
        }
        this.omschrijving = omschrijving;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public final void setPrijs(BigDecimal prijs) {
        if (prijs.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("prijs moet >= 0");
        }
        this.prijs = prijs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product p)) {
            return false;
        } else {
            return omschrijving.equals(p.omschrijving);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(omschrijving);
    }

    @Override
    public String toString() {
        return omschrijving + " : " + prijs;
    }
}
