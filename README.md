# MAS_Proj_1 - Modelowanie i analiza systemów informatycznych

# Projekt przedstawiający klasy i atrybuty w Javie.

Poniższy tekst stanowi zbiór zaleceń do realizacji konstrukcji UML wymaganych do mini-projektu 1 
(MP1)

1. Ekstensja klasy
Jest to zbiór wszystkich poprawnie utworzonych obiektów danej klasy.

* Każdy nowoutworzony obiekt (o ile nie wystąpiły błędy podczas inicjalizacji) należy 
automatycznie umieścić w odpowiedniej kolekcji - w tym celu należy zadbać o 
odpowiednią implementację konstruktora (lub konstruktorów) obiektu.
* Kolekcja ta powinna być wspólna dla wszystkich wystąpień tej klasy (statyczna).
* Należy pamiętać o zasadzie hermetyzacji i uniemożliwić modyfikację ekstensji na 
  zewnątrz klasy. W szczególności dotyczy to:
  * Zabezpieczenia pola kolekcji odpowiednim modyfikatorem dostępu
  * Brakiem publicznych metod modyfikujących tę kolekcję. Wyjątkiem może 
  być metoda usuwająca obiekt z ekstensji, nie jest ona jednak wymagana w 
  ramach tego projektu
  * Metoda pobierająca ekstensję (getter) powinna zwracać kopię kolekcji, lub 
  referencję uniemożliwiającą jej modyfikację (np. utworzoną za pomocą 
  funkcji java.util.Collections.unmodifiableList(…)

2. Ekstensja klasy - trwałość
Należy zapewnić możliwość zapisu ekstensji do trwałego składu i jej odczytu z tego składu po 
ponownym uruchomieniu aplikacji. Na potrzeby tego mini-projektu wystarczy trwałość uzyskana za 
pomocą serializacji obiektów i zapisu (odczytu) do (z) pliku.
* Klasy modelu powinny implementować odpowiedni interfejs (java.io.Serializable)
* Wszystkie atrybuty klasy powinny być typu, który implementuje java.io.Serializable
* Należy stworzyć statyczne metody do zapisu i odczytu ekstensji z pliku
* Metody te powinny prawidłowo obsłużyć wyjątki. Zalecane jest wykorzystanie 
konstrukcji try-with-resources
* W przypadku, gdy w programie jest wiele ekstensji, należy stworzyć jedną parę 
metod prowadzącą zapis i odczyt na wszystkich ekstensjach i używającą jednego 
pliku

3. Atrybut złożony.
Zawiera dwa, lub więcej pól stanowiących całość, nierozerwalnie związanych z posiadającym go 
obiektem (nie należy mylić z asocjacją).
* Własna klasa zawierająca składowe atrybutu złożonego
* Należy pamiętać o serializacji tej klasy
* Należy pamiętać o zasadzie hermetyzacji klasy, zarówno w klasie reprezentującej 
atrybut złożony, jak i u właściciela tego atrybutu. W szczególności dotyczy to:
  * prywatności pól
  * właściwych metod get i set
  * konstruktora inicjalizującego wymagane składowe obiektu
 
4. Atrybut opcjonalny
Jego wartość może być nieznana w momencie tworzenia obiektu
* Należy wykorzystać odpowiedni typ umożliwiający przypisanie wartości null. Typy 
proste (np. int czy double) nie spełniają tego wymagania.
*Metoda ustawiająca wartość (setter) dopuszcza wartość null jako parametr. Nadal 
jednak niepusta wartość może mieć określone ograniczenia (np. niepusty ciąg 
znaków, liczba z określonego zakresu itp.). W takim przypadku należy dokonać 
odpowiedniego sprawdzenia podczas podstawienia nowej wartości i ew. wyrzucić 
wyjątek sygnalizujący błąd walidacji
* Podobnie jak dla innych atrybutów stosuje się zasadę hermetyzacji
* Warto utworzyć dodatkowy konstruktor inicjalizujący zarówno atrybuty wymagane, 
jak i opcjonalne

5. Atrybut wymagany
Każdy atrybut nie będący opcjonalnym jest wymagany. Musi posiadać wartość przez cały cykl życia 
obiektu. Dla typu String zwykle nie dopuszcza się również pustego ciągu znaków.
* W celu zabezpieczenia przed ustawieniem wartości null dla typów liczbowych można 
wykorzystać typ prosty (np. int, double)
* Dla typów obiektowych należy dokonać odpowiedniej weryfikacji wartości w 
metodzie ustawiającej (w setterze) i ew. wyrzucić wyjątek w przypadku przekazania 
nieprawidłowej wartości
* Należy stworzyć konstruktor ustawiający wszystkie wymagane atrybuty. W 
przypadku niespełnienia warunków walidacji atrybutów obiekt nie może być 
umieszczony w ekstensji
* Podobnie jak dla innych atrybutów stosuje się zasadę hermetyzacji

6. Atrybut powtarzalny
Może zawierać więcej niż jedną wartość.
* Implementowany za pomocą kolekcji (częściej) lub tablicy (w szczególnych 
przypadkach).
* Wymagany atrybut powtarzalny powinien zawsze posiadać co najmniej jedną 
wartość
* Należy stworzyć metody do dodawania i usuwania wartości atrybutu powtarzalnego 
( addXXX(…) removeXXX(…) )
* Podczas dodawania należy przeprowadzić sprawdzenie poprawności przekazanej 
wartości (np. czy nie jest null, pustym ciągiem znaków, liczbą poza zakresem itp.)
* Jeśli atrybut jest wymagany podczas usuwania należy upewnić się, że nie zostanie 
usunięta ostatnia wartość
* Nie jest wymagana metoda zastępująca kolekcję (setXXX(…)). W przypadku jej 
implementacji należy upewnić się, czy wszystkie elementy przekazanej kolekcji 
spełniają warunki walidacji
* Metoda pobierająca atrybut musi być zabezpieczona przed nieuprawnioną 
modyfikacją kolekcji, podobnie jak w przypadku ekstensji


7. Atrybut klasowy
Zawiera wartości wspólne dla wszystkich obiektów danej klasy. Jego wartość może być 
modyfikowana, o ile nie ma dodatkowych ograniczeń.
* Implementacja za pomocą pola statycznego i pary metod get i set

8. Atrybut pochodny
Jego wartość jest wyliczana na podstawie innych danych (innych atrybutów, asocjacji itp.)
* Implementacja zwykle za pomocą metody getXXX, która oblicza i zwraca wartość 
atrybutu.
* W szczególnych przypadkach (rzadkie operacje zapisu na danych bazowych, częste 
odczyty atrubutu pochodnego) można ‘buforować’ wyliczoną wartość w polu klasy. 
Należy wtedy upewnić się, że będzie ono aktualizowane przy każdej zmianie danych, 
na których bazuje atrybut (zwykle jest to trudne lub nawet niemożliwe do realizacji).
* Wyliczając wartość należy zwrócić uwagę na potencjalne błędy (np. gdy atrybut 
bazowy jest opcjonalny)

9. Metoda klasowa
Jest to metoda, która jest wspólna dla wszystkich obiektów danej klasy (statyczna) i operuje na 
ekstensji klasy.

10. Przesłonięcie metody
Jest to nadpisanie implementacji metody z nadklasy. W przypadku, gdy nie mamy własnej hierarchii 
dziedziczenia klas można przesłonić metodę z klasy bazowej java.lang.Object (np. toString lub equals 
wraz z hashCode).

11. Przeciążenie metody / konstruktora


