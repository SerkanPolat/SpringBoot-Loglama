package com.sp.logging.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
https://docs.spring.io/spring-boot/docs/2.1.1.RELEASE/reference/html/boot-features-logging.html

logback-spring.xml dosyasinda bulunan aktif profiller application.properties dosyasi ile belirlenir.
Loglar Ana Dizinin logs klasorunde olusmaktadir.

Spring Boot Varsayilan olarak info level ile calismaktadir.
Degisiklik application.properties dosyasinda gerceklesir.


Uygulama cevap performansinin gecikme yasamamasi icin
Loglama Asenkron olarak gerceklestirilmelidir.

printStackTrace ve System.out.println()
Loglama formatlarina aykiri oldugu icin kullanilmamalidir.

Sensitive(Kullanici Id,Adi,Soyadi vb.) data Olmamalidir.

Tum Loglar Merkezi belli format ve bir yerde toplanmalidir.

 */
/*
lombok ile
@Slf4j
Kullanilirsa Class icinde
    Logger log = LoggerFactory.getLogger(LogEndPoint.class);
    Metoduna gerek kalmaz.Bunu lombok olusturur.

 */

@RestController
@RequestMapping("/log")
public class LogEndPoint {
    Logger log = LoggerFactory.getLogger(LogEndPoint.class);

    @GetMapping
    public String getDetails(){
        log.debug("DETAILS API CAGIRILDI.");

        return  internalLogDetail();
    }

    public String internalLogDetail(){
        try{
            Thread.sleep(1500);
            log.debug("internalLogDetail Metod Basladi");
            return "Merhaba API";
        }catch (InterruptedException e){
            log.error("Hata : {}",e);
        }
        return null;
    }


}
