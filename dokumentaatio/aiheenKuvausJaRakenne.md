**Aihe:** Laivanupotus. Toteutetaan kahden pelaajan peli, jossa pelaajan tavoitteena on upottaa vastustajan laivasto. Tässä versiossa ihmispelaajan vastustajana on tietokone (yksinkertainen tekoäly). Pelialueena toimii ruudukko, jonka koko valitaan radionapeista pelin alussa. Ruudukon koko voi olla 10\*10, 20\*20, 30\*30 tai 40\*40.

Pelissä kummallakin pelaajalla on seuraavat alukset: 1 lentotukialus (5 ruutua pitkä), 1 taistelulaiva (4 ruutua pitkä), 2 risteilijää (3 ruutua pitkiä), 1 hävittäjä (2 ruutua pitkä) ja 1 sukellusvene (1 ruudun pituinen). Pelaajat eivät näe toistensa laivoja. Pelin aloitusvalikossa ihmispelaaja asettaa laivat klikkailemalla omaan ruudukkoonsa. Tietokonepelaajan laivat asetetaan automaattisesti satunnaisille paikoille. 

Peli etenee vuoropohjaisesti siten, että kumpikin pelaaja ampuu vuorollaan yhteen vastustajan ruutuun kerrallaan. Samaan ruutuun ei voi ampua montaa kertaa. Jos ammus osui, ruutu muuttuu punaiseksi. Huti näkyy valkoisena. Laiva uppoaa kun jokaiseen sen alueella olevaan ruutuun on osunut ammus. Pelin voittaa se pelaaja, joka onnistuu upottamaan kaikki vastustajan laivat ensimmäisenä. Pelin lopussa käyttäjälle esitetään lopetusnäkymä, jossa kerrotaan, kumpi voitti ja montako pistettä voittaja sai.

**Käyttäjät:** 1 pelaaja

**Kaikkien käyttäjien toiminnot:** 

- ruudukon koon määritys
	- käyttäjä voi valita radionapeista ruudukon kooksi 10\*10, 20\*20, 30\*30 tai 40\*40, oletusvalintana 10\*10
- laivojen asettaminen ruudukkoon
- pelin aloitus
- ampuminen
- pelin päättyminen
- tulosnäkymän esittäminen pelin lopussa

**Luokkakaavio:**

![Luokkakaavio](/dokumentaatio/luokkakaavio.png)

**Sekvenssikaaviot:**

![Sekvenssikaavio laivaston ampumistoiminnosta](/dokumentaatio/shootingNavy.png)

![Sekvenssikaavio ruudukon ampumistoiminnosta](/dokumentaatio/shootingGrid.png)

**Rakennekuvaus:**

Sovellus on rakennettu kerroksittain MVC-mallia jäljitellen. Ylimpänä on näkymäluokat, joiden toiminta perustuu view-kontrollereihin ja varsinaisiin view-näkymäluokkiin. View-kontrollerit kutsuvat alempia pelikontrollereita. Pelikontrollerit hallinnoivat pelin toimintaa ja kutsuvat model-luokista tietoa erityisesti pelaaja-luokan kautta.

Näkymästä vastaavat luokat on jaoteltu näkymittäin siten, että jokaista pelinäkymää kohden on yksi view-malliluokka ja yksi sitä hallinnoiva view-kontrolleriluokka. Näkymä-malliluokat ovat riippuvaisia niitä hallinnoivista kontrolleriluokista: kontrolleriluokka luo näkymän ja antaa sille näytettävät oliot (esimerkiksi JLabelit ja JFramet). Jotta ohjelman rakenne pysyisi yksinkertaisena, näkymän malliluokilla on pääasiassa vain set- ja get-metodeja, joita kontrollerit kutsuvat.

Pelikontrolleriluokat sisältävät rajapinnan pelin tapahtumien kulkuun, sovelluksen tilan hakemiseen ja tilanteen päivittämiseen. GameInitializerController vastaa pelin alustamisesta ja lähtötilan asetuksista. GameController hallinnoi pelin kulkua ja tilanteen päivittämistä pelin aikana.

Pelikontrollerit käyttävät hyväkseen malliluokkien olioita. Pelaajaa mallintaa abstrakti pelaajaluokka, jonka perii erillinen ihmispelaaja sekä tekoälypelaaja. Tekoälypelaajalle on toteutettu erilainen ampumistoiminto kuin ihmispelaajalle, minkä takia luokkajako on perusteltu. Kummankin pelaajan ruudukkoa mallinnetaan ruudukkoluokalla, joka sisältää viitteen pelaajan omaan laivastoon. Laivasto sisältää laivaoliot, joilla on viitteet sijaintitietoon. Kutakin ruudukon ruutua ja siten laivan sijaintia mallinnetaan sijaintiolioluokan avulla. Sijainti koostuu vaaka- ja pystysuuntaisista indeksiarvoista.

