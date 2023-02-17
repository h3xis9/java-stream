package org.playground.model;

public class PersonBuilder {
    private Person object = new Person();

    public Person build() {
        return object;
    }

    public PersonBuilder setName(String value) {
        object.setName(value);
        return this;
    }

    public PersonBuilder setEmail(String value) {
        object.setEmail(value);
        return this;
    }

}
