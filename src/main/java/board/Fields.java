package board;

/**
 * Created by lora on 25.05.17.
 *
 */
public class Fields implements HasLength, Resetable{

    private static final String n = System.getProperty("line.separator");

    private final Field[] fields;

    Fields(Field[] arrayOfFields) {
        this.fields = arrayOfFields;
    }

    @Override
    public boolean equals(Object object) {
        boolean isEqual = false;
        if (object instanceof Fields) {
            isEqual = (hashCode() == object.hashCode());
        }
        return isEqual;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public int length() {
        return fields.length;
    }

    @Override
    public void reset() {
        for (Field field : fields) {
            field.reset();
        }
    }

    @Override
    public String toString() { // TODO
        StringBuilder builder = new StringBuilder("");
        for ( int i = 0; i < fields.length ; i++ ) {
            builder.append(
                    fields[i]
                            .toString()
                            .replace(" ", "")
                            .replace(n, ""));
        }
        return builder.toString();
    }

    Symbol getSymbolAt(int index) {
        int fieldNumber = index/length();
        int residue = index % length();
        return fields[fieldNumber].getSymbolAt(residue);
    }
}