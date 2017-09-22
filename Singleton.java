package interviews;

class Singleton
{
    // static variable single_instance of type Singleton
    private static Singleton single_instance = null;
 
    
    public String Sample;
 
    // private constructor restricting it to Singleton class
    private Singleton()
    {
    	Sample = "This is a Singleton class";
    }
 
    // This creates an instance of Singleton class
    public static Singleton getInstance()
    {
        if (single_instance == null)
            single_instance = new Singleton();
 
        return single_instance;
    }
    
    
    public static void main(String args[])
    {
        // instantiating Singleton class with variable x
        Singleton x = Singleton.getInstance();
 
        // instantiating Singleton class with variable y
        Singleton y = Singleton.getInstance();
 
        // instantiating Singleton class with variable z
        Singleton z = Singleton.getInstance();
 
        // changing variable of instance x
        x.Sample = (x.Sample).toUpperCase();
 
        
        // printing all the instances
        System.out.println("String from x is " + x.Sample);
        System.out.println("String from y is " + y.Sample);
        System.out.println("String from z is " + z.Sample);
        System.out.println("\n");
 
        /* After executing this program, you will see even though 
         * only the instance x was modified, the change is 
         * reflected on both y and z.  In other words 
         * after creation of object x, variables y and z are pointed to object x*/
        
        }
    
}
 

