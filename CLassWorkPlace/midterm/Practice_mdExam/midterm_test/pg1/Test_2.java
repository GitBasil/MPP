package Practice_mdExam.midterm_test.pg1;

class Test_3 {
    public int x = 0;

    class InnerTest_2 {
        int x = 3;

        public void getValue() {
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        Test_3 outer = new Test_3();
        InnerTest_2 z = outer.new InnerTest_2();
        z.getValue();
    }
}
