package prog12_1_soln;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Test {
	public static void main(String[] args) /*throws IllegalClosedCurveException*/ {
		try {
			ClosedCurve[] objects = {new Triangle(4,5,6),
									 new Square(3),
									 new Rectangle(-3,7),
									 new Circle(3)};
			//compute areas
			for(ClosedCurve cc : objects) {
				String nameOfCurve = getClassNameNoPackage(cc.getClass());
				System.out.println("The area of this "+ nameOfCurve +" is "+ cc.computeArea());	
			}			
		} 
		catch(IllegalClosedCurveException e) {
			String msg = e.getMessage();
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, msg , "Error",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
			//throw new IllegalClosedCurveException ("Illegal Dimention is not positive number!");
		}
	}
	
	public static String getClassNameNoPackage(Class aClass){ 
        String fullClassName = aClass.getName();
        int index = fullClassName.lastIndexOf('.');
        String className = null;
        String packageName = null;
        //in this case, there is no package name
        if(index==-1) {
            return fullClassName;
        }
        else {
			//for other apps, may be useful to have this
			packageName = fullClassName.substring(0,index);
            className = fullClassName.substring(index+1);
            return className;
        }
	}
}