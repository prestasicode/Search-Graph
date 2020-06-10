package StrukturData.List.Linked;
public class Link<ObjectList> {
     private ObjectList element;
     private Link<ObjectList> next;
     public Link(ObjectList element, Link<ObjectList> next){
         this.element = element;
         this.next = next;
     }
     public Link(Link<ObjectList> next){
         this.next = next;
     }
     public void setElement(ObjectList Element){
         this.element = Element;
     }
     public ObjectList getElement(){
         return element;
     }
     public Link<ObjectList> getNext(){
         return next;
     } 
     public void setNext(Link<ObjectList> next){
         this.next = next;
     }
}
