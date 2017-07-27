**Aihe:** Laivanupotus. Toteutetaan kahden pelaajan peli, jossa pelaajan tavoitteena on upottaa vastustajan laivasto. Tässä versiossa ihmispelaajan vastustajana on tietokone (yksinkertainen tekoäly). Pelialueena toimii ruudukko, jonka koko valitaan pelin alussa. Ruudukon koko saa olla väliltä 10\*10 - 40\*40.

Pelissä kummallakin pelaajalla on seuraavat alukset: 1 lentotukialus (5 ruutua pitkä), 1 taistelulaiva (4 ruutua pitkä), 2 risteilijää (3 ruutua pitkiä), 1 hävittäjä (2 ruutua pitkä) ja 1 sukellusvene (1 ruudun pituinen). Pelaajat eivät näe toistensa laivoja. Pelin aluksi kummankin tulee asettaa laivat ruudukkoon. 

Peli etenee vuoropohjaisesti siten, että kumpikin pelaaja ampuu vuorollaan yhteen vastustajan ruutuun kerrallaan. Samaan ruutuun ei voi ampua montaa kertaa. Ohjelma ilmoittaa osuiko ammus. Vastustajan laivaan osunut pelaaja saa lisävuoron. Laiva uppoaa kun jokaiseen sen alueella olevaan ruutuun on osunut ammus. Ohjelma kertoo tällöin laivan uppoamisesta ja samalla kumman pelaajan laiva upposi. Pelin voittaa se pelaaja, joka onnistuu upottamaan kaikki vastustajan laivat ensimmäisenä.

**Käyttäjät:** 1 pelaaja

**Kaikkien käyttäjien toiminnot:** 

- ruudukon koon määritys
	- onnistuu, jos määrätty koko on väliltä 10\*10 - 40\*40
- pelaajan nimen valitseminen
- pelin aloitus
- ampuminen
- pisteiden tallentaminen
- tulosnäkymän esittäminen pelin lopussa
