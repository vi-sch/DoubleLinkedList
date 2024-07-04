public interface IDoubleLinkedList {
     void addFirst(Object item); // Am Anfang anfügen
     void addLast(Object item); // Am Ende anfügen
     void addAfter(Object item, Object before);// item nach before einfügen
     Object removeFirst(); // Am Anfang entfernen
     Object removeLast(); // Am Ende entfernen
     void remove(Object item); // Element item entfernen
     int length(); // Anzahl der Listenelemente
     boolean isEmpty(); // true, wenn die Liste leer ist
     IDoubleLinkedList copy(); // Kopie der Liste erzeugen
     IDoubleLinkedList reverse(); // Umgedrehte Kopie der Liste erzeugen
} 