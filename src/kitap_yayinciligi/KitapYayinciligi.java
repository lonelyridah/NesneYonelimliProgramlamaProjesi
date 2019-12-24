package kitap_yayinciligi;
import java.util.* ;
import java.sql.* ;

public class KitapYayinciligi 
{   
    //Kategorileri ekrana yazdiran fonksiyon
    public static void kategoriler_listele()
    {
        System.out.println("\n----- K A T E G O R I L E R -----\n\n");
        System.out.println("1.Klasikler    2.Bilgisayar   \t\t 3.Felsefe\n\n4.Dini\t       5.Tarihi Kitaplar\t 6.Egitim\n\n");
        System.out.println("Erismek istediginiz klasorun numarasini giriniz...Cikis yapmak icin 0'a basiniz...");
    }
    
    public static ArrayList<Kitap> listelenecekler( Kitap kitap_1 , Kitap kitap_2 , Kitap kitap_3 , Kitap kitap_4 , Kitap kitap_5 )
    {
        ArrayList<Kitap> books_in_method = new ArrayList<>() ;
        
        books_in_method.add(kitap_1) ;
        books_in_method.add(kitap_2) ;
        books_in_method.add(kitap_3) ;
        books_in_method.add(kitap_4) ;
        books_in_method.add(kitap_5) ;
        
        return books_in_method ;
    }
    
    public static void listele( ArrayList<Kitap> kitap , int sorgu ) 
    {
        switch (sorgu) {
            case 1:
                System.out.println("\n\nKLASIKLER");
                break;
            case 2:
                System.out.println("\n\nBILGISAYAR KITAPLARI");
                break;
            case 3:
                System.out.println("\n\nFELSEFI KITAPLAR");
                break;
            case 4:
                System.out.println("\n\nDINI KITAPLAR");
                break;
            case 5:
                System.out.println("\n\nTARIHI KITAPLAR");
                break;
            case 6:
                System.out.println("\n\nEGITIM KITAPLARI");
                break;
            default:
                break;
        }
        
        for (int i = 0; i < kitap.size() ; i++)
        {
            Kitap gecici_nesne = kitap.get(i );
            gecici_nesne.ozellikleri_yazdir();
        }
    }
    
    public static ArrayList<Kitap> kitap_ekle( ArrayList<Kitap> kitap , Scanner klavye , int sorgu )
    {
        Kitap yeni_kitap = null ;
        
        switch (sorgu) {
            case 1:
                yeni_kitap = new Klasik() ;
                break;
            case 2:
                yeni_kitap = new Bilgisayar() ;
                break;
            case 3:
                yeni_kitap = new Felsefe() ;
                break;
            case 4:
                yeni_kitap = new Dini() ;
                break;
            case 5:
                yeni_kitap = new Tarih() ;
                break;
            case 6:
                yeni_kitap = new Egitim() ;
                break;
            default:
                break;
        }
        
        System.out.println("Kitabin adini giriniz : ");
        String kitabin_adi = klavye.next() ;
        yeni_kitap.setKitabin_adi( kitabin_adi );
        
        System.out.println("Kitabin yazarini giriniz : ");
        String yazarin_adi = klavye.next() ;
        yeni_kitap.setYazarin_adi( yazarin_adi );
        
        System.out.println("Kitabin yayinevini giriniz : ");
        String yayin_evi = klavye.next() ;
        yeni_kitap.setYayin_evi( yayin_evi );

        System.out.println("Kitabin sayfa sayisini giriniz : ");
        int sayfa_sayisi = klavye.nextInt() ;
        yeni_kitap.setSayfa_sayisi( sayfa_sayisi );
        
        System.out.println("Kitabin basim yilini giriniz : ");
        int basim_yili = klavye.nextInt() ;
        yeni_kitap.setBasim_yili( basim_yili );
        
        System.out.println("Kitabin ISBN numarasini giriniz : ");
        String ISBN_num = klavye.next() ;
        yeni_kitap.setISBN_num( ISBN_num );
        
        System.out.println("Kitabin fiyatini giriniz : ");
        int kitabin_fiyati = klavye.nextInt() ;
        yeni_kitap.setFiyat( kitabin_fiyati );
        
        kitap.add( yeni_kitap ) ;
        
        System.out.println("Yeni kitap basariyla eklendi..");
        
        return kitap ;
    }
    
    public static ArrayList<Kitap> kategoriler( ArrayList<Kitap> kitap , Scanner klavye , int sorgu ) 
    {
        listele( kitap , sorgu );
        
        while( true )
        {
            System.out.println("\n\nYeni kitap eklemek icin 1'e , cikis yapmak icin 0'a basiniz");
            
            int sorgulama = klavye.nextInt() ;
            
            if( sorgulama == 1 )
            {
                kitap = kitap_ekle(kitap, klavye , sorgu);
            }
            else if( sorgulama == 0 )
            {
                break ;
            }
            else
            {
                System.out.println("Hatali Giris...\n");
            }
        }
        
        return kitap ;
    }

    //Main Method
    public static void main(String[] args) 
    {  
        Scanner klavye = new Scanner( System.in ) ;
        
        final String db_adres = "jdbc:mysql://localhost:3306/klasik";
        final String db_user_name = "root" ;
        final String db_password = "1234" ;
        
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) 
        {
            System.err.println("MySQL Driver bulunamadi");
            System.err.println("Hata : " + e );
            return;
        }
        
        Connection my_con = null ;
        PreparedStatement my_prep_stat = null ;
        Statement my_stat  = null ;
        
        try
        {
            my_con = ( Connection ) DriverManager.getConnection(db_adres , db_user_name , db_password );
            my_stat = my_con.createStatement() ;
            ResultSet my_result_set = my_stat.executeQuery("SELECT * FROM klasik.kitap_adi;") ;
            
            System.out.println("Basarili bir sekilde MySQL'e baglanti saglandi");
            
            while (my_result_set.next()) 
            {
                System.out.print(my_result_set.getString("kitabin_numarasi") + "\n" + my_result_set.getString("kitabin_adi") + "\n" + my_result_set.getString("yazarin_adi"));
                
            }
        }
        catch (SQLException e)
        {
            System.err.println("MySQL baglanamadi");
            System.err.println("Hata : " + e);
        }
        
        /*
        //Klasik kitaplarin tanimlanmasi
        Kitap sefiller = new Klasik( "Sefiller" , "Victor Hugo" , "Is Bankasi Kultur Yayinlari" , 1724 , 2016 , "6053324744" , 95 ) ;
        Kitap babalar_ve_ogullar = new Klasik( "Babalar ve Ogullar" , "Ivan Sergeyevic Turgenyev" , "Is Bankasi Kultur Yayinlari" , 264 , 2019 , "9944885454" , 45 ) ;
        Kitap fareler_ve_insanlar = new Klasik( "Fareler ve Insanlar" , "John Steinbeck" , "Sel Yayincilik" , 128 , 2012 , "9755705859" , 67 ) ;
        Kitap kelile_ve_dimne = new Klasik( "Kelile ve Dimne" , "Beydeba" , "Ilgi Kultur Sanat Yayinlari" , 256 , 2018 , "6052022542" , 36 ) ; 
        Kitap cakircali_efe = new Klasik( "Cakircali Efe" , "Yasar Kemal" , "Yapi Kredi Yayinlari" , 182 , 2019 , "9750807244" , 25 ) ;
       
        ArrayList<Kitap> klasikler = new ArrayList<>() ;
        klasikler = listelenecekler( sefiller , babalar_ve_ogullar , fareler_ve_insanlar , kelile_ve_dimne , cakircali_efe ) ;
        
        //Bilgisayar kitaplarinin tanimlanmasi
        Kitap python = new Bilgisayar( "Python" , "Mustafa Baser" , "Dikeyeksen Yayincilik" , 544 , 2019 , "6058758872" , 35 );
        Kitap ag_teknolojileri = new Bilgisayar( "Ag Teknolojileri ve Telekomunikasyon" , "Cebrail Taskin" , "Pusula Yayincilik" , 408 , 2018 , "6052359358" , 47 ) ;
        Kitap internet_for_dummies = new Bilgisayar( "Internet for Dummies" , "Kollektif" , "Nobel Yasam" , 394 , 2017 , "6059746427" , 27 );
        Kitap oracle_veritabani = new Bilgisayar( "Oracle Veritabani Guvenligi" , "Yusuf Anil Akduygu" , "Abakus" , 632 , 2016 , "6059129565" , 37 ) ;
        Kitap c_programlama = new Bilgisayar( "C Programlamanin Temelleri" , "Timur Karacay" , "Abakus" , 484 , 2019 , "6059129183" , 35 ) ;
        
        ArrayList<Kitap> bilgisayar = new ArrayList<>() ;
        bilgisayar = listelenecekler( python , ag_teknolojileri , internet_for_dummies , oracle_veritabani , c_programlama ) ;
        
        //Dini kitaplarin tanimlanmasi
        Kitap mukaddime = new Dini( "Mukaddime" , "Ibni Haldun" , "Ilgi Kultur Sanat Yayinlari" , 1358 , 2018 , "6054977574" , 35 ) ;
        Kitap musned = new Dini( "Musned" , "Imam Ahmed bin Hanbel" , "Ocak Yayincilik" , 14700 , 2014 , "6055996925" , 370 ) ;
        Kitap tehafutul_felasife = new Dini( "Tehafutul Felasife" , "Imam Gazali" , "Turkiye Yazma Eserler Kurumu Baskanlıgı Yayinlari" , 462 , 2014 , "9751737328" , 40 ) ;
        Kitap mesnevi_bahcesi = new Dini( "Mesnevi Bahcesi" , "Mevlana" , "Ahir Zaman" , 334 , 2014 ,"6055095062" , 15 ) ;
        Kitap mistik_kabala = new Dini( "Mistik Kabala" , "Dion Fortune" , "Hermes Yayinlari" , 380 , 2015 , "9756130322" , 30 ) ;
        
        ArrayList<Kitap> dini = new ArrayList<>() ;
        dini = listelenecekler( mukaddime , musned , tehafutul_felasife , mesnevi_bahcesi , mistik_kabala ) ;
        
        //Felsefi kitaplarin tanimlanmasi
        Kitap devlet = new Felsefe( "Devlet" , "Platon" , "Is Bankasi Kultur Yayinlari" , 372 , 2019 , "9754587173" , 15 ) ;
        Kitap das_kapital = new Felsefe( "Das Kapital" , "Karl Marx" , "Karbon Kitaplar" , 738 , 2019 , "6057803870" , 70 ) ;
        Kitap savas_sanati = new Felsefe( "Savas Sanati" , "Sun Tzu" , "Mavicati Yayinlari" , 164 , 2018 , "6059372107" , 5 ) ;
        Kitap oryantalizm = new Felsefe( "Oryantalizm Islam ve Turkler" , "Omer Bahadiroglu" , "Toker Yayinlari" , 215 , 2006 , "9754451532" , 29 ) ;
        Kitap toz = new Felsefe( "Toz" , "Michael Marder" , "Ithaki Yayinlari" , 120 , 2019 , "6053759478" , 14 ) ;
        
        ArrayList<Kitap> felsefe = new ArrayList<>() ;
        felsefe = listelenecekler( devlet , das_kapital , savas_sanati , oryantalizm , toz ) ;
        
        //Tarih kitaplarinin tanimlanmasi
        Kitap cecen = new Tarih( "Cecenistan Dosyasi" , "Anil Cecen" , "Astana Yayinlari" , 434 , 2019 , "6055010225" , 27 ) ;
        Kitap hititler = new Tarih( "Hititler Bilinmeyen Bir Dunya Imparatorlugu" , "Birgit Brandau" , "Arkadas Yayinlari" , 344 , 2018 , "9755093406" , 32 ) ;
        Kitap guzel_tarih = new Tarih( "Turkiyenin Guzel Tarihi" , "Guven Erkin Erkal" , "Esen Kitap" , 408 , 2014 , "6054609376" , 44 ) ;
        Kitap hayatim = new Tarih( "Hayatim" , "Kazim Karabekir" , "Kronik Kitap" , 368 , 2018 , "9752430891" , 30 ) ;
        Kitap turklerin_tarihi = new Tarih( "Turklerin Tarihi" , "Ilber Ortayli" , "Timas Yayinlari" , 320 , 2019 , "6050819267" , 21 ) ;
        
        ArrayList<Kitap> tarih = new ArrayList<>() ;
        tarih = listelenecekler(cecen, hititler, guzel_tarih, hayatim, turklerin_tarihi) ;
        
        //Egitim kitaplarinin tanimlanmasi
        Kitap collins = new Egitim( "Collins Primary French Dictionary" , "Kollektif" , "Nuans Publishing" , 588 , 2019 , "0008312701" , 37 ) ;
        Kitap gokdelenler = new Egitim( "National Geographic Kids / Gokdelenler" , "Libby Romero" , "National Geographic" , 48 , 2019 , "6052423745" , 48 ) ;
        Kitap anne_baba = new Egitim( "Anne Baba ve Cocuk" , "Yunus Simsek" , "Hasrem Yayinlari" , 213 , 2019 , "6058076334" , 56 ) ;
        Kitap yuksek_ogretim = new Egitim( "Yuksek Ogretim Sistemimiz" , "Rifat Okcabol" , "Utopya Yayinevi" , 379 , 2007 , "9756361610" , 91 ) ;
        Kitap ingilizce = new Egitim( "Ingilizce Bulmacalarla Kahve Molasi" , "Alev Yildirim" , "Karbon Kitaplar" , 160 , 2016 , "6059681278" , 15 ) ;
        
        ArrayList<Kitap> egitim = new ArrayList<>() ;
        egitim = listelenecekler(collins, gokdelenler, anne_baba, yuksek_ogretim, ingilizce) ;
        
        
        OUTER:
        while (true) {
            kategoriler_listele();
            int sorgu = klavye.nextInt() ;
            
            switch (sorgu) {
                case 0:
                    break OUTER;
                case 1:
                    klasikler = kategoriler(klasikler, klavye , sorgu );
                    listele(klasikler , sorgu );
                    break;
                case 2:
                    bilgisayar = kategoriler(bilgisayar, klavye , sorgu );
                    listele(bilgisayar , sorgu );
                    break;
                case 3:
                    felsefe = kategoriler(felsefe, klavye , sorgu ) ;
                    listele(felsefe , sorgu );
                    break;
                case 4:
                    dini = kategoriler(dini, klavye , sorgu ) ;
                    listele(dini , sorgu );
                    break;
                case 5:
                    tarih = kategoriler(tarih, klavye , sorgu);
                    listele(tarih , sorgu );
                    break;
                case 6:
                    egitim = kategoriler(egitim, klavye, sorgu) ;
                    listele(egitim , sorgu );
                    break;
                default:
                    System.out.println("\nHatali Giris...\n");
                    break;
            }
        }
        */
    }
}