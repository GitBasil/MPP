package Practice_mdExam.prepratice.pt.package1;

import Practice_mdExam.prepratice.pt.package3.ObjectRefClass;

public class CallingClass extends SuperClass {
    void aMethod(ObjectRefClass ref) {
        // Attempting to access protected member proMem
        ref.proMem;  // This will cause a compiler error
        this.proMem = 15;
    }
}
