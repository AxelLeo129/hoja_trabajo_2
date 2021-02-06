public interface Pila<E> 
{

   /**
 * @param item ingresa el item a agregar (pushear)
 */
public void push(E item);
   // pre: 
   // post: item is added to stack
   // will be popped next if no intervening push
   
   /**
 * @return devulve el ultimo item del stack (el cual fue eliminado)
 */
public E pop();
   // pre: stack is not empty
   // post: most recently pushed item is removed and returned
   
   /**
 * @return devuelve el valor mas recientemente agregado
 */
public E peek();
   // pre: stack is not empty
   // post: top value (next to be popped) is returned
   
   /**
 * @return devuelve si el stack esta o no vacio con un boolean
 */
public boolean empty();
   // post: returns true if and only if the stack is empty
   
   /**
 * @return devuelve el tamaño del stack
 */
public int size();
   // post: returns the number of elements in the stack

}