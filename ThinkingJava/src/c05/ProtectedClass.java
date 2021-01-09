package c05;

public class ProtectedClass {
    protected String name;
    protected String adsress;

    protected ProtectedClass (){
        System.out.println("ProtectedClass created");
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setAdsress(String adsress) {
        this.adsress = adsress;
    }
}
