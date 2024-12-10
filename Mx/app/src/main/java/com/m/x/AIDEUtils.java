public class AIDEUtils {
    
    private static Context c;
    
    public AIDEUtils(Context c){
        this.c = c;
    }
    
    // these functions can be used by creating an instance of this class
    //you can get a detailed example in your app's MainActivity
    
    //Toast a short message
    public static void toast(String msg){
        Toast.makeText(c, msg, Toast.LENGTH_SHORT).show();
    }
    
    //Toast a long message
    public static void toastLong(String msg){
        Toast.makeText(c, msg, Toast.LENGTH_LONG).show();
    }