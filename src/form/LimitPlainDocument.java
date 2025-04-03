package form;

import javax.swing.text.*;

public class LimitPlainDocument extends PlainDocument {
    private int max;

    public LimitPlainDocument(int max) {
        this.max = max;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str != null && (getLength() + str.length() <= max)) {
            super.insertString(offset, str, attr);
        }
    }
}
