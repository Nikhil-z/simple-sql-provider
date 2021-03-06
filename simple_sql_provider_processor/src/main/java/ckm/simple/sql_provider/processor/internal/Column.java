package ckm.simple.sql_provider.processor.internal;


import javax.lang.model.element.Element;

import ckm.simple.sql_provider.processor.Helper;

/**
 * Created by kurt on 03 09 2015 .
 */
public final class Column {
    public String name;
    public Element element;
    public boolean primary;
    public boolean autoincrement;

    public Column(boolean primary,boolean autoincrement,String name, Element element) {
        this.name = name;
        this.primary = primary;
        this.element = element;
        this.autoincrement = autoincrement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Column)) return false;
        Column column = (Column) o;
        return name.equalsIgnoreCase(column.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Column {" +
                "name='" + name + '\'' +
                ", element=" + element.asType() +
                ", field=" + element.getSimpleName() +
                ", primary=" + primary +
                ", autoincrement=" + autoincrement +
                '}';
    }

    public boolean isPrivate(){
            return !Helper.isPublic(element);
    }
}
