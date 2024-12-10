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
     //Check if user has an active network connection
     public static boolean isNetworkConnected(){
		ConnectivityManager connectivityManager 
			= (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
		return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}
	
	//check if a string contains only numbers
	public static boolean isNumeric(String str) { 
		try {  
			Double.parseDouble(str);  
			return true;
		} catch(NumberFormatException e){  
			return false;  
		}  
	}
    //Write an exception to local storage. It can be used for debugging, but only if you catch an exception
	//requires access to external storage
	public static void writeLogToLocal(Exception e){
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		String text = sw.toString();
		FileUtil.writeFile(FileUtil.getExternalStorageDir() + "/log.txt", text);
	}