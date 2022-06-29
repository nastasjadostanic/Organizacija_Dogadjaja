# ISA-PROJEKAT
David Egelja IN47-2018

Nastasja Dostanic IN18-2018


Projekat je radjen u razvojnom okruzenju IntelliJ (backend), Visual Studio Code (front) dok je baza podataka radjena u MySql programu.

Pokretanje projekta se zapocinje kreiranjem, pokretanjem i popunjavanjem baze za koju su prilozene skripte (u folderu skripte). Zatim se pokrece (runuje) Backend deo te se pokrece Front. Front se pokrece iz Visual Studio Code-a komandom "npm start" u terminalu.

Kada je program pokrenut, treba se navigirati na LoginPage pritiskom na dugme login ili se registrovati pritiskom na dugme (Ukoliko postoji nesto ucitano u localStorage, samo treba obirsati sve i refreshovati stranicu da bi se pojavili dugmici ili se rucko navigirati na "localhost:3000/login"). Login se veoma cudno ponasa bez nekog konkretnog razloga. Da proradi potrebno je vise puta ukucati odgovarajucu kombinaciju Email-a i Password-a i u nekom pokusaju ce se uspesno prikazati profil te se ponovo vratiti na LoginPage. Potrebno je kliknuti BACK na browseru i dalje sve radi normalno.

Ukoliko login ne radi, otvoriti Inspect Element u browseru i pokusati ponovo (nekoliko puta ukoliko je potrebno).

Dalja upotreba programa je kroz dugmice i polja.

Login podaci su u sledecoj formi : Email, Password, Role

gedgedfor@gmail.com, 123, Cottage Owner

stasa.nastasja@gmail.com, 123, Main Admin

gedgedfor@gmail.com, 456, Ship Owner

stasa.nastasja@gmail.com, 456, Admin

stasa.nastasja@gmail.com, 789, Fishing Instructor

gedgedfor@gmail.com, 999, Client

