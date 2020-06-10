/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StrukturData.List.Linked;

/**
 *
 * @author Ferisa
 * @param <E>
 */
interface InterfaceLinkedList<E> {
    
    /**
     *Clear all element of LinkedList
     */
    public void clear();
    
    /**
     * Insert element before current position
     * @param item
     */
    public void insert(E item);
    
    /**
     *Add or append element to LinkedList
     * @param item
     */
    public void append(E item);
    
    /**
     *Move current position to new position
     * @param position
     */
    public void moveToPos(int position);
    
    /**
     *Move current position to start
     */
    public void moveToStart();
    
    /**
     *Move current position to end
     */
    public void moveToEnd();
    
    /**
     *Move current position to preview element
     */
    public void prev();
    
    /**
     *Move current position to next element
     */
    public void next();
    
    /**
     *Replace element on current position to new element
     * @param item
     */
    public void replace(E item);
    
    /**
     * Get position of item on LinkedList
     * @param item
     * @return 
     */
    public int getPositionOf(E item);
    
    /**
     * Checking item on LinkedList if found return true
     * @param item
     * @return 
     */
    public boolean isFound(E item);
            
    /**
     *Get element of current position
     * @return 
     */
    public E getValue();
    
    /**
     *Get element of requested position
     * @param position
     * @return 
     */
    public E getValueOf(int position);
    
    /**
     *Get all element of LinkedList to array object E
     * @return 
     */
    public E [] getAllValue();
    
    /**
     * Get length of LinkedList
     * @return 
     */
    public int length();
    
    /**
     * Get position of current position
     * @return 
     */
    public int currPos();
    
    /**
     * Checking the LinkedList is empty, if empty return true
     * @return 
     */
    public boolean isEmpty();
    
    /**
     *Remove element on current position
     */
    public void remove();
    
    /**
     *Remove element of requested position
     * @param position
     */
    public void remove(int position);
    
    /**
     *Remove element of requested interval
     * @param start
     * @param end
     */
    public void remove(int start, int end);
    
    /**
     *Get removed element
     * @return 
     */
    public E getRemoved();
        
    /**
     *Swap element on request positions
     * @param posItem1
     * @param posItem2
     */
    public void swapValueAt(int posItem1, int posItem2);
    
    /**
     *Get the biggest number of LinkedList
     * @return 
     */
    public E getBiggestNumber();
    
    /**
     * Get the smallest number of LinkedList
     * @return 
     */
    public E getSmallestNumber();
    
    /**
     * Reverse order of all element
     */
    public void reverse();
    
    /**
     * Get mean of all number element
     * @return 
     */
    public double getMean();
    
    /**
     * Get variant of all number element
     * @return 
     */
    public double getVariant();
    
    /**
     *Get standard deviation of all number element
     * @return 
     */
    public double getStandardDeviation();
    
    /**
     *show all element of LinkedList to console
     */
    public void show();
    
}