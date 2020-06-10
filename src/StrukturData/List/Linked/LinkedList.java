package StrukturData.List.Linked;
//by, Arfendo Dhimas Prambudi
import static java.lang.Double.*;
//this class is LinkedList
public class LinkedList<ObjectList> implements InterfaceLinkedList<ObjectList>{
    private Link<ObjectList> head;
    private Link<ObjectList> tail;
    protected Link<ObjectList> curr;
    private Link<ObjectList> tempLink;
    private ObjectList tempObject;
    int count;
    public LinkedList(){
        curr = tail = head = new Link<>(null);
        count = 0;
    }
    @Override
    public void show(){
        tempLink = curr;
        System.out.println("Linked List : ");
        moveToStart();
        while(curr!=tail){
            try{
                System.out.print("  "+curr.getNext().getElement());
                curr = curr.getNext();
            }catch(NullPointerException e){
                break;
            }
        }
        System.out.println("");
        curr = tempLink;
    }
    @Override
    public void clear(){
        head.setNext(null);
        curr = tail = head = new Link<>(null);
        count = 0;
    }
    @Override
    public void insert(ObjectList item){
        curr.setNext(new Link<>(item,curr.getNext()));
        if(tail==curr)
            tail = curr.getNext();
        count++;
    }
    @Override
    public void append(ObjectList item){
        tail.setNext(new Link<>(item,null));
        tail = tail.getNext();
        count++;
    }
    @Override
    public ObjectList getRemoved(){
        return tempObject;
    }
    @Override
    public void moveToStart(){
        curr = head;
    }
    @Override
    public void moveToEnd(){
        curr = tail;
    }
    @Override
    public void moveToPos(int pos){
        if(pos>=0&&pos<=count){
            curr = head;
            for (int i = 0; i < pos; i++) 
                curr = curr.getNext();
        }else
            System.out.println(pos+" out of range!");
    }
    @Override
    public void prev(){
        if(curr!=head){
            tempLink = head;
            while(tempLink.getNext()!=curr)
                tempLink = tempLink.getNext();
            curr = tempLink;
        }
    }
    @Override
    public void next(){
        if(curr!=tail)
            curr = curr.getNext();
    }
    @Override
    public int length(){
        return count;
    }
    @Override
    public int currPos(){
        tempLink = head;
        int i;
        for (i = 0; !tempLink.equals(curr); i++) 
            tempLink = tempLink.getNext();
        return i;
    }
    
    @Override
    public void remove(){
        try{
            tempObject = curr.getNext().getElement();
            if(tail==curr.getNext())
                tail = curr;
            curr.setNext(curr.getNext().getNext());
            count--;
        }catch(NullPointerException e){
            tempObject = null;
        }
    }
    @Override
    public void remove(int index) {
        if(index>=0&&index<=count){
            moveToPos(index);
            remove();
        }else{
            tempObject = null;
        }
    }
    @Override
    public void remove(int start, int end) {
        if(end>start){
            if(end>count)
                end = count;
            if(start>=0&&start<=count && end>=0&&end<=count){
                moveToPos(start);
                for (int i = 0; i < end; i++) {
                    remove();
                }
            }
        }
    }
    @Override
    public ObjectList getValue(){
        if(curr==tail)
            return null;
        return curr.getNext().getElement();
    }
    @Override
    public ObjectList[] getAllValue() {
        if(count!=0){
            ObjectList[] temp = (ObjectList[]) new Object[count];
            tempLink = head;
            for (int i = 0; tempLink!=tail; i++) {
                temp[i] = tempLink.getNext().getElement();
            }
            return temp;
        }else{
            return null;
        }
    }
    public void swap(ObjectList item1, ObjectList item2){
        swapValueAt(getPositionOf(item1),getPositionOf(item2));
    }
    @Override
    public void swapValueAt(int indexItem1, int indexItem2) {
        if((indexItem1>=0&&indexItem1<count)
                &&(indexItem2>=0&&indexItem2<count)){
            if(indexItem1>indexItem2){
                int temp = indexItem1;
                indexItem1 = indexItem2;
                indexItem2 = temp;
            }
            Link<ObjectList> temp1 = null;
            Link<ObjectList> temp2 = null;
            Link<ObjectList> tempA = null;
            Link<ObjectList> tempB = null;
            Link<ObjectList> temp = head;
            Link<ObjectList> tempCurr = temp;
            tempLink = curr;
            curr = head;
            int i = 0;
            while(curr!=tail){
                if(i==indexItem1){
                    temp1 = curr.getNext();
                    tempA = curr.getNext().getNext();
                    break;
                }
                i++;
                curr = curr.getNext();
            }
            curr = head;
            int j = 0;
            while(curr!=tail){
                if(j==indexItem2){
                    temp2 = curr.getNext();
                    tempB = curr.getNext().getNext();
                    break;
                }
                j++;
                curr = curr.getNext();
            }
            i = j = 0;
            
            while(tempCurr!=tail){
                if(i==indexItem1){
                    if(indexItem1==count-1||indexItem2==count-1){
                        Link<ObjectList> temp2A = new Link<>(
                                temp2.getElement(),tempA);
                        tempCurr.setNext(temp2A);
                    }
                    else {
                        tempCurr.setNext(temp2);
                        tempCurr.getNext().setNext(tempA);
                    }
                }
                if(j==indexItem2){
                    if(indexItem1==count-1||indexItem2==count-1){
                        tempCurr.setNext(temp1);
                        tempCurr.getNext().setNext(null);
                    }
                    else{
                        tempCurr.setNext(temp1);
                        tempCurr.getNext().setNext(tempB);
                    }
                    
                }
                i++;
                j++;
                try{
                    tempCurr = tempCurr.getNext();
                }catch(NullPointerException e){
                    
                }
                
                if(i>20) break;
            }
            head = temp;
        }else{
            System.out.println("index out of bounds");
        }
    }
    @Override
    public void replace(ObjectList item) {
        curr.setNext(new Link<>(item,curr.getNext().getNext()));
    }
    @Override
    public boolean isFound(Object item){
        moveToStart();
        while(curr!=tail){
            try{
                if(item==(getValue()))
                    return true;
            }catch(NullPointerException e){}
            curr = curr.getNext();
        }
        
        return false;
    }
    @Override
    public int getPositionOf(ObjectList item){
        int indexFind = currPos();
        if(count>0){
            if(curr==head||curr==tail||curr.getNext()==tail){
                if(curr==tail||curr.getNext()==tail) {
                    curr = head;
                    indexFind = 0;
                }
                while(curr!=tail){
                    curr = curr.getNext();
                    indexFind++;
                    try{
                        if(curr.getNext().getElement().equals(item)){
                            break;
                        }
                    }catch(NullPointerException e){
                    }
                }
                if(curr==tail){
                    curr = head;
                    indexFind = 0;
                }
            }
            else{
                tempLink = curr;
                while(curr.getNext()!=tempLink){
                    if(curr==tail) curr = head;
                    else curr = curr.getNext();
                    if(indexFind==count) indexFind = 0;
                    else indexFind++;
                    try{
                        if(item.equals(curr.getNext().getElement())){
                            break;
                        }
                    }catch(NullPointerException e){
                    }
                }
                if(curr.getNext()==tempLink){
                    curr = tempLink;
                    indexFind = currPos();
                }
            }
        }
        System.out.println(indexFind);
        return indexFind;
    }
    @Override
    public boolean isEmpty() {
        return head==tail;
    }
    public LinkedList biggerNumberThen(ObjectList item){
        LinkedList temp = new LinkedList();
        tempLink = head;
        while(tempLink!=tail){
            try{
                if(compare(parseDouble(
                        tempLink.getNext().getElement().toString()),
                        parseDouble(item.toString()))>0){
                    temp.append(tempLink.getNext().getElement());
                }
            }catch(NumberFormatException e){
            }
            tempLink = tempLink.getNext();
        }
        return temp;
    }
    @Override
    public ObjectList getBiggestNumber() {
        double tempBiggest = -99999999999999999999.0;
        if(count!=0){
            tempLink = head;
            try{
                tempBiggest = parseDouble(
                        tempLink.getNext().getElement().toString());
            }catch(NumberFormatException e){
            }
            int i = 0;
            while(tempLink!=tail){
                try{
                    tempBiggest = max(tempBiggest,parseDouble(
                            tempLink.getNext().getElement().toString()));
                }catch(NumberFormatException e){
                }
                tempLink = tempLink.getNext();
            }
        }
        if(tempBiggest==-99999999999999999999.0)
            tempBiggest = 0;
        if(tempBiggest==(int)tempBiggest)
            return (ObjectList)String.valueOf((int)tempBiggest);
        else
            return (ObjectList)String.valueOf(tempBiggest);
    }
    @Override
    public ObjectList getSmallestNumber() {
        double tempSmallest = 99999999999999999999.0;
        if(count!=0){
            tempLink = head;
            try{
                tempSmallest = parseDouble(tempLink.getNext().getElement().toString());
            }catch(NumberFormatException e){
            }
            int i = 0;
            while(tempLink!=tail){
                try{
                    tempSmallest = min(tempSmallest,parseDouble(tempLink.getNext().getElement().toString()));
                }catch(NumberFormatException e){
                }
                tempLink = tempLink.getNext();
            }
        }
        if(tempSmallest==99999999999999999999.0)
            tempSmallest = 0;
        if(tempSmallest==(int)tempSmallest)
            return (ObjectList)String.valueOf((int)tempSmallest);
        else
            return (ObjectList)String.valueOf(tempSmallest);
    }
    @Override
    public void reverse() {
        if(!isEmpty()){
            ObjectList[] temp = (ObjectList[]) new Object[count];
            tempLink = head;
            for (int i = count-1; tempLink!=tail; --i) {
                temp[i] = tempLink.getNext().getElement();
                tempLink = tempLink.getNext();
            }
            this.clear();
            for (ObjectList temp1 : temp) {
                this.append(temp1);
            }
        }
    }
    @Override
    public ObjectList getValueOf(int index) {
        int i = 0;
        tempLink = head;
        while(tempLink!=tail){
            if(i==index)
                return tempLink.getNext().getElement();
            i++;
            tempLink = tempLink.getNext();
        }
        return null;
    }
    public String getAllValueToString(){
        tempLink = head;
        String temp = "";
        while(tempLink.getNext()!=null){
            temp+=tempLink.getNext().getElement().toString()+",";
            tempLink = tempLink.getNext();
        }
        temp = temp.substring(0,temp.length()-1);
        return temp;
    }
    
    @Override
    public double getMean() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public double getVariant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public double getStandardDeviation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
