package be.vdab.winkel;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Mandje {
    private Map<Product, Integer> mandje = new LinkedHashMap<>();

    public Map<Product, Integer> getMandje() {
        return mandje;
    }

    public void add (Product product, int aantal) {
        Objects.requireNonNull(product);
        controleerAantal(aantal);
        if (mandje.containsKey(product)) {
            mandje.put(product, mandje.get(product) + aantal);
        } else {
            mandje.put(product, aantal);
        }
    }

    private void controleerAantal (int aantal) {
        if (aantal <= 0) {
            throw new IllegalArgumentException("aantal moet positief zijn");
        }
    }

    public void remove(Product product) {
        Objects.requireNonNull(product);
        mandje.remove(product);
    }

    public void clear() {
        mandje.clear();
    }
    public BigDecimal getTotalePrijs() {
        BigDecimal totaal = BigDecimal.ZERO;
        for (var entry : mandje.entrySet()) {
            totaal = totaal.add(entry.getKey().getPrijs().multiply(BigDecimal.valueOf(entry.getValue())));
        }

        return totaal;
    }

    @Override
    public String toString() {
        return mandje.toString();
    }
}
