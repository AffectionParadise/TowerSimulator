package net.doge.ui.widget.textfield;

import net.doge.data.FontData;

import javax.swing.text.*;

public class NumTextField extends GTextField {

    public NumTextField() {
        this(null);
    }

    public NumTextField(String text) {
        super(text);

        setFont(FontData.UI_FONT);
        ((AbstractDocument) getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (!isValid(getNewText(fb, offset, 0, string))) return;
                super.insertString(fb, offset, string, attr);
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (!isValid(getNewText(fb, offset, length, text))) return;
                super.replace(fb, offset, length, text, attrs);
            }

            private String getNewText(FilterBypass fb, int offset, int length, String text) throws BadLocationException {
                Document doc = fb.getDocument();
                StringBuilder sb = new StringBuilder(doc.getText(0, doc.getLength()));
                sb.replace(offset, offset + length, text);
                return sb.toString();
            }

            private boolean isValid(String text) {
                return text.matches("\\d*");
            }
        });
    }
}
