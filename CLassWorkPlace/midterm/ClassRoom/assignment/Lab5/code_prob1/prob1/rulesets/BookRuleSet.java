package ClassRoom.assignment.Lab5.code_prob1.prob1.rulesets;

import java.awt.Component;
import javax.swing.JTextField;
import ClassRoom.assignment.Lab5.code_prob1.prob1.gui.BookWindow;

/**
 * Rules:
 * 1. All fields must be nonempty
 * 2. Isbn must be numeric and consist of either 10 or 13 characters
 * 3. If Isbn has length 10, the first digit must be 0 or 1
 * 4. If Isbn has length 13, the first 3 digits must be either 978 or 979
 * 5. Price must be a floating point number with two decimal places
 * 6. Price must be a number greater than 0.49.
 *
 */
public class BookRuleSet implements RuleSet {

	@Override
	public void applyRules(Component ob) throws RuleException {
		BookWindow bookWindow = (BookWindow) ob;

        String isbn = bookWindow.getIsbnValue();
        String price = bookWindow.getPriceValue();
        String title = bookWindow.getTitleValue();
        
        if (isbn.isEmpty() || price.isEmpty() || title.isEmpty()) {
            throw new RuleException("All fields must be nonempty");
        }

        validateIsbn(isbn);
        validatePrice(price);
	}

	private void validateIsbn(String isbn) throws RuleException {
        if (!isbn.matches("\\d+")) {
            throw new RuleException("ISBN must be numeric");
        }

        if (isbn.length() != 10 && isbn.length() != 13) {
            throw new RuleException("ISBN must consist of either 10 or 13 characters");
        }

        if (isbn.length() == 10 && !(isbn.startsWith("0") || isbn.startsWith("1"))) {
            throw new RuleException("If ISBN has length 10, the first digit must be 0 or 1");
        }

        if (isbn.length() == 13 && !(isbn.startsWith("978") || isbn.startsWith("979"))) {
            throw new RuleException("If ISBN has length 13, the first 3 digits must be either 978 or 979");
        }
    }

    private void validatePrice(String price) throws RuleException {
        try {
            double priceValue = Double.parseDouble(price);
            if (priceValue <= 0.49) {
                throw new RuleException("Price must be greater than 0.49");
            }
            if (!price.matches("\\d+\\.\\d{2}")) {
                throw new RuleException("Price must be a floating point number with two decimal places");
            }
        } catch (NumberFormatException e) {
            throw new RuleException("Price must be a valid number");
        }
    }
}
