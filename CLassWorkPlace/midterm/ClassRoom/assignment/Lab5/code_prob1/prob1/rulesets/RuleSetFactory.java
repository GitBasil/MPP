package ClassRoom.assignment.Lab5.code_prob1.prob1.rulesets;

import java.awt.Component;
import java.util.HashMap;

import ClassRoom.assignment.Lab5.code_prob1.prob1.gui.BookWindow;
import ClassRoom.assignment.Lab5.code_prob1.prob1.gui.CDWindow;


final public class RuleSetFactory {
	private RuleSetFactory(){}
	static HashMap<Class<? extends Component>, RuleSet> map = new HashMap<>();
	
}
