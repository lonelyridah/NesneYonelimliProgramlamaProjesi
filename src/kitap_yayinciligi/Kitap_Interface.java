/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kitap_yayinciligi;

/**
 *
 * @author CASPER
 */
public interface Kitap_Interface {
    
    public void Kitap() ;
    public void Kitap(String kitabin_adi , String yazarin_adi , String yayin_evi , 
                  int sayfa_sayisi , int basim_yili , String ISBN_num , int fiyat) ;
    
    public String getKitabin_adi() ;
    public void setKitabin_adi( String kitabin_adi ) ;
    public String getYazarin_adi();
    public void setYazarin_adi( String yazarin_adi );
    public String getYayin_evi();
    public void setYayin_evi( String yayin_evi );
    public int getSayfa_sayisi();
    public void setSayfa_sayisi( int sayfa_sayisi );
    public int getBasim_yili();
    public void setBasim_yili( int basim_yili );
    public String getISBN_num();
    public void setISBN_num( String ISBN_num );
    public int getFiyat() ;
    public void setFiyat( int fiyat ) ;
    
    public void ozellikleri_yazdir() ;
}
