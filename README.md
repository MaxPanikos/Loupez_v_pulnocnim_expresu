# Loupež v půlnočním expresu

Loupež v půlnočním expresu je textová detektivní adventura. Hráč se ujímá role průvodčího Karla ve vlaku na trase z Prahy do Vídně, který kvůli vánici uvízl na trati.

## 📖 Příběh
Během nucené zastávky v mrazivé noci nahlásí operní pěvkyně Madam Hrušková krádež vzácného diamantového náhrdelníku. Hlavním úkolem je vypátrat skutečného zloděje – nenápadného studenta Filipa, kterého k činu dohnaly dluhy – dříve, než se vlak ráno (za pár hodin) znovu rozjede.

## 🎯 Cíle hry

Najít ukradený náhrdelník ukrytý v nádržce na toaletě.


Shromáždit důkazy: Najít utržený knoflík v Kupé 1 a dlužní úpis v Kupé 3.


Zadržet zloděje: Konfrontovat a porazit studenta Filipa v závěrečném střetu.

## 🎮 Herní příkazy
Hra využívá konzolové rozhraní a reaguje na následující příkazy (ve formátu příkaz [cíl]):

### Navigace a manipulace

jdi [místnost] – Přesun mezi kupé, chodbou a dalšími lokacemi.


seber [předmět] – Sebere předmět v místnosti a vloží ho do inventáře.


odhod [předmět] – Odloží předmět z inventáře v aktuální místnosti.


odemkni [místnost] – Použije generální klíč k otevření zamčených dveří.

### Vyšetřování

prohledej [věc] – Prozkoumá konkrétní objekt v místnosti za účelem nalezení stop.


prohledni [postava] – Detailně prozkoumá vzhled a oblečení postavy.


zeptej [postava] – Zahájí dialog s daným NPC.


podej [postava] – Otevře menu pro předání předmětu postavě (např. léky nebo cigarety).


obvin [postava] – Konfrontuje podezřelého s nasbíranými důkazy.

### Systémové

pomoc – Vypíše seznam dostupných příkazů.

konec – Ukončí aktuální hru.

## ⚙️ Herní mechaniky
Omezený inventář: Karel může mít u sebe současně pouze dva předměty. Hráč musí taktizovat a nepotřebné věci odkládat.


Časový limit: Hráč má na vyřešení případu omezený počet minut (výchozí stav 180 minut).


Skládání stop: K úspěšnému usvědčení nestačí náhrdelník jen najít; hráč musí mít v ruce důkaz (knoflík) a znát motiv (dluh).

## 📁 Technická struktura
Data: Veškerá herní data (místnosti, NPC, předměty) jsou načítána z externího souboru gamedata.json přes třídu FileManager.

Architektura: Projekt využívá vzor Command (příkazy jsou uloženy v HashMap) pro flexibilní zpracování vstupů v třídě Console.

Herní stav: Třída World spravuje aktuální polohu hráče, inventář a zbývající čas.