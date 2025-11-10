import com.access.two.Derived;
import com.access.one.Base;
public class PackageAccessModifierControl {
    public static void main(String[] args){
        Derived d = new Derived();
        d.testAccess();
        Base b = new Base();
        b.publicMethod();
        System.out.println("Direct call to Base.callAll() to show internal access:");
        b.callAll();
    }
}
