public class Node{
    Object content;
    Node prev;
    Node next;
    
    public Node(Object cont){
        this.content=cont;
        this.prev=null;
        this.next=null;
    }
    
    public Object getContent(){
        return this.content;
    }
    
    public Node setPrev(Node p){
        this.prev=p;
        return p;
    }
    
    public Node setNext(Node n){
        this.next=n;
        return n;
    }
    
    public Node getPrev(){
        return prev;
    }
    
    public Node getNext(){
        return next;
    }
}