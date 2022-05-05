import java.util.Objects;

public class Vector {
    Character symbol;
    Character value;

    public Vector(Character symbol, Character value) {
        this.symbol = symbol;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return symbol.equals(vector.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }
}
