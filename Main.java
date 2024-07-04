public class Main{
    
    
    public static void main (String[] args) {
        DoubleLinkedList dll= new DoubleLinkedList();
    
        
        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);
        
        dll.prntDll();
        
        dll.addLast(4);
        dll.addLast(6);
        dll.addAfter(5,2);
        
        dll.removeFirst();
        dll.removeLast();
        dll.remove(2);
        
        
        dll.addLast(9);
        
        dll.prntDll();
        
        DoubleLinkedList dll2= new DoubleLinkedList();
        dll2=dll.reverse();
        
        dll2.prntDll();
        
        
        
    }
}