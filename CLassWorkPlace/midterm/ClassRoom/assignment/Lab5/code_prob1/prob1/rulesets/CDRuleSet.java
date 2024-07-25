package ClassRoom.assignment.Lab5.code_prob1.prob1.rulesets;

import java.awt.Component;

import ClassRoom.assignment.Lab5.code_prob1.prob1.gui.CDWindow;

/**
 * Rules:
 *  1. All fields must be nonempty 
 *  2. Price must be a floating point number with two decimal places 
 *  3. Price must be a number greater than 0.49. 
 */

public class CDRuleSet implements RuleSet {

	@Override
	public void applyRules(Component ob) throws RuleException {
		CDWindow cdWindow = (CDWindow) ob;

		String title = cdWindow.getTitle();
		String artist = cdWindow.getArtistValue();
		String priceStr = cdWindow.getPriceValue();

		// Check if any field is empty
		if (title == null || title.trim().isEmpty() ||
		    artist == null || artist.trim().isEmpty() ||
		    priceStr == null || priceStr.trim().isEmpty()) {
			throw new RuleException("All fields must be nonempty");
		}

		// Check if price is a valid floating point number with two decimal places
		try {
			double price = Double.parseDouble(priceStr);
			if (!priceStr.matches("\\d+\\.\\d{2}")) {
				throw new RuleException("Price must be a floating point number with two decimal places");
			}
			// Check if price is greater than 0.49
			if (price <= 0.49) {
				throw new RuleException("Price must be greater than 0.49");
			}
		} catch (NumberFormatException e) {
			throw new RuleException("Price must be a valid number");
		}
		
	}
	
}
