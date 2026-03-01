# Loupež v půlnočním expresu

Loupež v půlnočním expresu je textová detektivní adventura. Hráč se ujímá role průvodčího Karla ve vlaku na trase z Prahy do Vídně, který kvůli vánici uvízl na trati.

## 📖 Příběh
Během nucené zastávky v mrazivé noci nahlásí operní pěvkyně Madam Hrušková krádež vzácného diamantového náhrdelníku. Hlavním úkolem je vypátrat skutečného zloděje, zjistit co ho k tomu vedlo – dříve, než se vlak ráno (za pár hodin) znovu rozjede.

## 🎯 Cíl hry

Najít ukradený náhrdelník, shromáždit důkazy, zadržet zloděje (konfrontovat ho).

## 🎮 Herní příkazy
Hra využívá konzolové rozhraní a reaguje na následující příkazy (ve formátu příkaz [cíl]).
Vždy ovšem pište název osoby, mistnosti, atd... ze závorky (dále ID).
Příklad: Z teto mistnosti muzete do (1): Jídelní vůz (jidelna) tak ID je jidelna nikoliv Jídelní vůz.

### Navigace a manipulace

jdi [místnost] – Přesun mezi kupé, chodbou a dalšími lokacemi.


seber [předmět] – Sebere předmět v místnosti a vloží ho do inventáře.


odhod [předmět] – Odloží předmět z inventáře v aktuální místnosti.


odemkni [místnost] – Použije generální klíč k otevření zamčených dveří.

### Vyšetřování

prohledej [věc] – Prozkoumá konkrétní objekt v místnosti za účelem nalezení stop.


prohledni [postava] – Detailně prozkoumá vzhled a oblečení postavy.


zeptej [postava] – Zahájí dialog s daným NPC.


podej [postava] [věc] – Předá předmět postavě.


obvin [postava] – Konfrontuje podezřelého s nasbíranými důkazy.

### Systémové

pomoc – Vypíše seznam dostupných příkazů.

konec – Ukončí aktuální hru.

## ⚙️ Herní mechaniky
Omezený inventář: Karel může mít u sebe současně pouze dva předměty. Hráč musí taktizovat a nepotřebné věci odkládat.


Časový limit: Hráč má na vyřešení případu omezený počet minut (výchozí stav 180 minut).


Skládání stop: K úspěšnému usvědčení nestačí náhrdelník jen najít; hráč musí mít v ruce důkaz a znát motiv.

## 📁 Technická struktura
Veškerá herní data (místnosti, NPC, předměty) jsou načítána z externího souboru gamedata.json přes třídu FileManager.
JSON soubor načítá externí knihovna GSON.