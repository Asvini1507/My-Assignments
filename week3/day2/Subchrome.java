package week3.day2;

public class Subchrome extends browser
{
	public void openIncognito() {
        System.out.println("Chrome opened in incognito mode.");
    }
    public void clearCache() {
        System.out.println("Chrome cache cleared.");
    }
	public static void main(String[] args) {
		Subchrome chromeobj= new Subchrome();
		chromeobj.clearCache();
		chromeobj.openIncognito();
		chromeobj.closebrowser();
		chromeobj.navigateBack();
		chromeobj.openURL();
	}
}
