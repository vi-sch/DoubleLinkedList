public class DoubleLinkedList implements IDoubleLinkedList {
    
    Node ankerAnf;
    Node ankerEnd;
    
    public DoubleLinkedList(){
        this.ankerAnf=null;
        this.ankerEnd=null;
    }
    
    
    // Am Anfang anfügen
    public void addFirst(Object item){
        Node neu= new Node(item);
        if(isEmpty()){
            this.ankerAnf=neu;
            this.ankerEnd=neu;
        }
        else{
            neu.setNext(ankerAnf);
            ankerAnf.setPrev(neu);
            ankerAnf=neu;
        }
        System.out.println(item+" added first ");
    } 
    
    
    // Am Ende anfügen
    public void addLast(Object item){
        Node neu= new Node(item);
        if(isEmpty()){
            this.ankerAnf=neu;
            this.ankerEnd=neu;
        }
        else{
            neu.setPrev(ankerEnd);
            ankerEnd.setNext(neu);
            ankerEnd=neu;
        }
        System.out.println(item+" added last");
    }
    
    
   
    // item nach before einfügen
    public void addAfter(Object item, Object before){
        Node neu= new Node(item);
        if(isEmpty()){
            System.out.println("List is Empty! Addition not possible.");
        }
        //falls an Ende gesetzt werden soll, einfach addLast nehmen
        else if(before==ankerEnd.getContent()){
            this.addLast(neu);
        }
        else{
            //Suche nach before
            Node search= new Node(0);
            search=this.ankerAnf;
            while(search.getContent()!=before){
                if(search.getNext()==null){
                    break;
                }
                search=search.getNext();
            }
            //Ist das Ende erreicht und trotzdem nicht der gesuchte Node
            if(search.getNext()==null && search.getContent()!=before){
                System.out.println("The searched Node "+before+" is not in the List!");
            }
            else{
                neu.setNext(search.getNext());
                neu.setPrev(search);
                search.getPrev().setNext(search);
                search.setNext(neu);
                System.out.println("added "+item+" after "+before);
            }
        }
    }
    
    
    
    // Am Anfang entfernen
    public Node removeFirst(){
        if(isEmpty()){
            System.out.println("The first Node cant be removed, because the list is empty!");
        }
        //falls nur ein Element in Liste
        else if(this.ankerAnf==this.ankerEnd){
            this.ankerAnf=null;
            this.ankerEnd=null;
            System.out.println("The list is now Empty!");
        }
        else{
            //neuer Anfang setzen
            this.ankerAnf.getNext().setPrev(null);
            this.ankerAnf=this.ankerAnf.getNext();
            System.out.println("first removed");
        }
        return this.ankerAnf;
    }
    
    
    // Am Ende entfernen
    public Node removeLast(){
        if(isEmpty()){
            System.out.println("The first Node cant be removed, because the list is empty!");
        }
        //falls nur ein Element in Liste
        else if(this.ankerAnf==this.ankerEnd){
            this.ankerAnf=null;
            this.ankerEnd=null;
            System.out.println("The list is now Empty!");
        }
        else{
            //neues Ende setzen
            this.ankerEnd.getPrev().setNext(null);
            this.ankerEnd=this.ankerEnd.getPrev();
            System.out.println("last removed");
        }
        return this.ankerEnd;
    }
    
   // Element item entfernen 
    public void remove(Object item){
        if(isEmpty()){
            System.out.println("Node cant be removed because List is empty!");
        }
        //Falls erstes, rufe removeFirst() auf
        else if(item==this.ankerAnf.getContent()){
            this.removeFirst();
        }
        //Falls letztes, rufe removeLast() auf
        else if(item==this.ankerEnd.getContent()){
            this.removeLast();
        }
        else{
            //Item suchen und entfernen
            Node search= ankerAnf;
            while(search.getContent()!=item){
                if(search.getNext()==null){
                    break;
                }
                search=search.getNext();
            }
            //Ist das Ende erreicht und trotzdem nicht der gesuchte Node
            if(search.getNext()==ankerEnd && search.getContent()!=item){
                System.out.println("The searched Node "+item+" is not in the List!");
            }
            else{
                //item aus Liste entfernen
                search.getPrev().setNext(search.getNext());
                search.getNext().setPrev(search.getPrev());
                System.out.println(item+" removed");
            }
        }
        
    }
   
    // Kopie der Liste erzeugen
    public DoubleLinkedList copy(){
        //falls groeße gleich 0 oder 1, kann gleich zurück gegeben werden
        if(isEmpty()||(this.ankerAnf==this.ankerEnd)){
            System.out.println("List copyed");
            return this;
        }
        else{
            //neue Liste, rueckwaerts
            DoubleLinkedList revdll= new DoubleLinkedList();
            Node temp= ankerAnf;
            while(temp.getNext()!=null){
                revdll.addLast(temp.getContent());
                temp=temp.getNext();
            }
            revdll.addFirst(temp.getContent());
            System.out.println("List copyed");
            return revdll;
        }
    }
    
    
    
   
    // Umgedrehte Kopie der Liste erzeugen
    public DoubleLinkedList reverse(){
        //falls groeße gleich 0 oder 1, kann gleich zurück gegeben werden
        if(isEmpty()||(this.ankerAnf==this.ankerEnd))   {
             System.out.println("List reversed");
            return this;
        }
        else{
            //neue Liste, rueckwaerts
            DoubleLinkedList revdll= new DoubleLinkedList();
            Node temp= ankerAnf;
            while(temp.getNext()!=null){
                revdll.addFirst(temp.getContent()); 
                temp=temp.getNext();
            }
            revdll.addFirst(temp.getContent());
            System.out.println("List reversed");
            return revdll;
        }
        
    }
    
    
    
    
    
    // Anzahl der Listenelemente
    public int length(){
        if(isEmpty()){
            return 0;
        }
        else{
            Node count= new Node(0);
            count=this.ankerAnf;
            int z=0;
            while(count!=ankerEnd){
                count=count.getNext();
                z++;
            }
            z++;
            return z;
        }
    }
    
    
    // true, wenn die Liste leer ist
    public boolean isEmpty(){
        if(ankerAnf==null){
            return true;
        }
        else{
            return false;
        }
    }
    
    
    public void prntDll(){
        if(isEmpty()){
            System.out.println("The List is empty!");
        }
        else{
            System.out.println("\nThe List contains "+this.length()+" Elements:");
            Node tst= ankerAnf;
            while(tst.getNext()!=null){
                System.out.print(tst.getContent()+" ");
                tst=tst.getNext();
            }
            System.out.print(tst.getContent()+" \n\n");
        }
    }
}