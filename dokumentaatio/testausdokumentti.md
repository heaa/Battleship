## Testausdokumentti

Automaattiset testit kattavat suurimman osan sovelluksen logiikasta ja pelikontrollereista.

Käyttöliittymää ei testattu automaattisesti. Sen sijaan sitä testattiin tasaisin väliajoin käsin ajamalla ohjelmaa Netbeansissa. Käsin kokeilemalla löytyi pohjalla piileviä bugeja kuten se, että laivan pystyi sijoittamaan ruudukon ulkopuolelle klikkaamalla reunan läheistä sijaintia. Nykyisellään ohjelma antaa asiaan kuuluvan virheilmoituksen, jos laiva ei mahdu kohtaan, johon sitä yrittää sijoittaa. Ampuminen oli myös mahdollista kaksi kertaa samaan ruutuun ennen koodin korjaamista. 

Release-version jar-tiedostoa kokeiltiin macilla ja havaittiin, että käyttöliittymän värit eivät toimineet odotetusti. Tämä on korjattu koodiin. Kaikki löytyneet bugit on korjattu release-versioon.
