package televizyon;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class television {

    private String marka; //Dışarıdan erişilememesi için private yaptım.
    private String boyut;
    private ArrayList<Kanal> kanallar; //Kanallar hepsi tek bir yerde dursun diye polimorfik yapı oluşturdum.
    //Polimorfizm sayesinde bütün hepsini kanal adı altında toplayabildik.
    private boolean acik;
    private int ses;
    private int aktifKanal;


    public television(String marka, String boyut){ //constructor oluşturdum.
        this.marka = marka;
        this.boyut = boyut;
        kanallar = new ArrayList<>();
        ses = 10;
        aktifKanal = 1;
        kanallariOlustur();
        this.acik = false;
    }

    public void sesArttir(){
        if(ses < 20 && acik == true){
            ses++;
            System.out.println("Ses seviyesi : "+ses);
        }else {
            System.out.println("Ses maksimumda daha fazla arttıramazsın veya tv kapalı");
        }
    }

    public void sesAzalt(){
        if(ses > 0 && acik){
            ses--;
            System.out.println("Ses seviyesi :"+ses);
        }else {
            System.out.println("Ses minimumda daha fazla azaltamazsın veya tv kapalı");
        }
    }

    public void tvAc(){
        if (acik == false){
            acik = true;
            System.out.printf("TV açıldı");
        }else {
            System.out.println("TV zaten açık");
        }
    }

    public void tvKapat(){
        if (acik == true){
            acik = false;
            System.out.printf("TV kapandı");
        }else {
            System.out.println("TV zaten kapalı");
        }
    }

    private void kanallariOlustur() {
        HaberKanali cnn = new HaberKanali("CNN",1,"Genel Haber");
        kanallar.add(cnn);
        HaberKanali bein = new HaberKanali("BeinSport",2,"Spor Haber");
        kanallar.add(bein);
        MuzikKanali powerturk = new MuzikKanali("Power Türk",3,"Yerli");
        kanallar.add(powerturk);
        MuzikKanali numberOne = new MuzikKanali("Number One",4,"Yabancı");
        kanallar.add(numberOne);
    }

    public void aktifKanaliGoster(){
        if(acik)
        System.out.println("Aktif kanal: "+kanallar.get(aktifKanal-1).kanalBilgisiniGoster());
        else System.out.println("Önce televizyonu açınız");
    }

    public void kanalDegistir(int acilmasiIstenenKanal){
        if(acik){
            if(acilmasiIstenenKanal != aktifKanal){

                if(acilmasiIstenenKanal <= kanallar.size() && acilmasiIstenenKanal >= 0){
                    aktifKanal = acilmasiIstenenKanal;
                    System.out.println("Kanal : "+acilmasiIstenenKanal+" Bilgi:"+kanallar.get(aktifKanal-1).kanalBilgisiniGoster());
                }else {
                    System.out.println("Geçerli bir kanal numarası giriniz");
                }

            }else {
                System.out.println("Zaten "+aktifKanal+". kanaldasınız. Değiştirme yapılamadı");
            }
        }else {
            System.out.println("Önce televizyonu açınız");
        }
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getBoyut() {
        return boyut;
    }

    public void setBoyut(String boyut) {
        this.boyut = boyut;
    }

    @Override
    public String toString() {
        return "Marka : " + marka + " Boyut : " + boyut + " olan tv oluşturuldu";
    }
}
