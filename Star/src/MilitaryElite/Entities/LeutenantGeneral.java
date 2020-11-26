package MilitaryElite.Entities;

import MilitaryElite.Interfaces.ILeutenantGeneral;

import java.util.*;

public class LeutenantGeneral extends Private implements ILeutenantGeneral {
    private Set<Private> privates;

    public LeutenantGeneral(String[] s) {
        super(s);
        this.privates = new TreeSet<>((f,d)-> d.getId()-f.getId());
    }

    @Override
    public void addPrivate(Private soldier) {
        this.privates.add(soldier);
    }


    @Override
    public String toString() {
        StringBuilder print = new StringBuilder(super.toString() + System.lineSeparator() + "Privates:" + System.lineSeparator());
        this.privates
                .forEach(e -> print.append("  ").append(e.toString()).append(System.lineSeparator()));
        return print.toString().trim();
    }
}
