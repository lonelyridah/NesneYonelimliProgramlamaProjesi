package kitap_yayinciligi;

public class Klasik extends Kitap implements Kitap_Interface
{
    private String kitabin_turu ;
    
    //Constructor Methods
    Klasik()
    {
        this.kitabin_turu = "Klasikler" ;
    }
    Klasik( String kitabin_adi , String yazarin_adi , String yayin_evi , 
           int sayfa_sayisi , int basim_yili , String ISBN_num , int fiyat )
    {
        super( kitabin_adi , yazarin_adi , yayin_evi , sayfa_sayisi , basim_yili , ISBN_num , fiyat ) ;
        this.kitabin_turu = "Klasikler" ;
    }
    
    public void ozellikleri_yazdir()
    {
        super.ozellikleri_yazdir();
        System.out.print("Kitabin Turu : " + kitabin_turu + "\n\n" );
    }    

    @Override
    public void Kitap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Kitap(String kitabin_adi, String yazarin_adi, String yayin_evi, int sayfa_sayisi, int basim_yili, String ISBN_num, int fiyat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}