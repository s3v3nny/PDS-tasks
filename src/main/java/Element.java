import java.util.Objects;

public class Element {
    Integer x;
    Integer y;

    public Element(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return x.equals(element.x) && y.equals(element.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
