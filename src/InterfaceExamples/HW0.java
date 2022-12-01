package InterfaceExamples;

public class HW0 implements HW0_Specification{

    public static void main(String[] args) {
        // used to reference in an instance context
        HW0 hw0 = new HW0(); // calls the default constructor
        System.out.println(hw0.sod(4539) == 21);
    }
    @Override
    public int sod(int n) {
        if(n == 0)
            return 0;
        else
            return sod(n/10) + n % 10;
    }
}
