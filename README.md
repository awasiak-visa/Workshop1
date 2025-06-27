# TaskManager

## Opis

Program konsolowy TaskManager stworzony w ramach warsztatów na kursie CodersLab pełni rolę prostego menadżera zadań, umożliwiającego zarządzanie nimi.

## Funkcje

Program posiada następujące funkcje:
* wczytywanie danych z pliku przy starcie aplikacji,
* wyświetlanie wszystkich dostępnych zadań,
* dodanie zadania,
* usuwanie zadania,
* sprawdzanie poprawność wartości liczbowej podczas usuwania zadania,
* wyjście z aplikacji,
* zapis danych do pliku.

## Działanie programu

Na początku do programu wczytywany jest plik z listą zadań w formacie csv.
Jeśli plik nie istnieje, użytkownik zostanie o tym poinformowany i program zakończy działanie.
Po wczytaniu pliku, wyświetli się lista poleceń, które może wywołać użytkownik.
Dostępne polecenia to: ``add``,`` remove``, ``list``, ``exit``. Użytkownik komunikuje się z programem poprzez wpisywanie danych informacji w konsoli.
Należy wpisać wybrane polecenie, w przypadku wpisania błędnego polecenia wyświetli się komunikat z prośbą o wybór poprawnej opcji.

Po wpisaniu polecenia ``add`` użytkownik zostanie zapytany o dodatkowe informacje.
Na początku będzie musiał podać opis nowego zadania. Następnie zostanie poproszony o wpisanie daty na wykonanie zadania. 
Na koniec powinien podać informację o tym, czy nowe zadanie jest ważne. Po tym kroku nowe zadanie zostanie dopisane do listy.

Po wpisaniu polecenia ``remove`` użytkownik będzie poproszony o podanie numeru zadania, które chce usunąć.
Jeśli podana zostanie poprawna wartość, zadanie zostanie usunięte i program poinformuje o tym użytkownika.
W przypadku wpisania liczby naturalnej wykraczającej poza numery zadań, program ponownie wypisze dostępne polecenia i poprosi użytkownika o wybór jednego z nich.
Natomiast w przypadku podania innej wartości, użytkownik będzie ponownie proszony o podanie poprawnej wartości, aż do skutku.

Po wpisaniu polecenia ``list`` program wyświetli aktualną listę zadań. 
Natomiast po wpisaniu polecenia ``exit``, plik z listą zadań zostanie zaktualizowany i użytkownik zostanie poinformowany o zakończeniu programu.
