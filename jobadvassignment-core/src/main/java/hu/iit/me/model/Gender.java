package hu.iit.me.model;

public enum Gender {
    MAN,WOMAN;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
