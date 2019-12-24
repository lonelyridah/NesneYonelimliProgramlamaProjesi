package kitap_yayinciligi;

public abstract class Kitap 
{
    //Properties
    
    private String kitabin_adi ;
    private String yazarin_adi ;
    private String yayin_evi ;
    private int sayfa_sayisi ;
    private int basim_yili ;
    private String ISBN_num ;
    private int fiyat ;

    //Constructor Methods
    
    //Alttaki constructor yeni kitap tanimlanirken kullanilacak
    public Kitap() 
    {
        System.out.println("Yeni kitap eklemek icin izin verildi...\n");
    }
    
    //Alttaki constructor on tanimlama yapilirken kullanilir
    public Kitap( String kitabin_adi , String yazarin_adi , String yayin_evi , 
                  int sayfa_sayisi , int basim_yili , String ISBN_num , int fiyat )
    {
        this.kitabin_adi = kitabin_adi ;
        this.yazarin_adi = yazarin_adi ;
        this.yayin_evi = yayin_evi ;
        this.sayfa_sayisi = sayfa_sayisi ;
        this.basim_yili = basim_yili ;
        this.ISBN_num = ISBN_num ;
        this.fiyat = fiyat ;
    }
    
    //Get-Set Methods
    
    public String getKitabin_adi()
    {
        return kitabin_adi ;
    }
    public void setKitabin_adi( String kitabin_adi )
    {
        this.kitabin_adi = kitabin_adi ;
    }        
    
    public String getYazarin_adi()
    {
        return yazarin_adi ;
    }
    public void setYazarin_adi( String yazarin_adi )
    {
        this.yazarin_adi = yazarin_adi ;
    }        
    
    public String getYayin_evi()
    {
        return yayin_evi ;
    }
    public void setYayin_evi( String yayin_evi )
    {
        this.yayin_evi = yayin_evi ;
    }    
    public int getSayfa_sayisi()
    {
        return sayfa_sayisi ;
    }
    public void setSayfa_sayisi( int sayfa_sayisi )
    {
        this.sayfa_sayisi = sayfa_sayisi ;
    }
     
    public int getBasim_yili()
    {
        return basim_yili ;
    }
    public void setBasim_yili( int basim_yili )
    {
        this.basim_yili = basim_yili ;
    }
    
    public String getISBN_num()
    {
        return ISBN_num ;
    }
    public void setISBN_num( String ISBN_num )
    {
        this.ISBN_num = ISBN_num ;
    }  
    
    public int getFiyat()
    {
        return fiyat ;
    }
    public void setFiyat( int fiyat )
    {
        this.fiyat = fiyat ;
    }
    
    // Print Method 
    public void ozellikleri_yazdir()
    {
        System.out.print("\n\nKitabin Adi  : " + kitabin_adi + "\n" );
        System.out.print("Yazar Adi    : " + yazarin_adi + "\n" );
        System.out.print("Yayinevi     : " + yayin_evi + "\n" );
        System.out.print("Sayfa Sayisi : " + sayfa_sayisi + "\n" );
        System.out.print("Basim Yili   : " + basim_yili + "\n" );
        System.out.print("ISBN         : " + ISBN_num + "\n" );
        System.out.print("Fiyat        : " + fiyat + " TL" + "\n" );
    }
}
