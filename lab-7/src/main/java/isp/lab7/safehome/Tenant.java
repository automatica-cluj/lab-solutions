package isp.lab7.safehome;

import java.util.Objects;

public class Tenant {
    private String name;

    public Tenant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tenant)) return false;
        Tenant tenant = (Tenant) o;
        return Objects.equals(getName(), tenant.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
