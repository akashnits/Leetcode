/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

// Approach - keep track of iteartor by adding it on the stack -> Stack<ListIterator<NestedInteger>>
public class NestedIterator implements Iterator<Integer> {

    private Stack<ListIterator<NestedInteger>> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack();
        stack.push(nestedList.listIterator());
    }

    @Override
    public Integer next() {
        // use interface - NestedInteger to return Integer 
        hasNext();
        return stack.peek().next().getInteger();
    }

    @Override
    public boolean hasNext() {
        //  Returns true if there are still some integers in the nested list and false otherwise.

        while(!stack.empty()){
            if(!stack.peek().hasNext()){
                stack.pop(); // we don't want to keep iterator which has no elements
            }else{
                NestedInteger ni = stack.peek().next();
                if(ni.isInteger()){
                    stack.peek().previous(); // move pointer backward as we're done checking
                    return true;
                }else{
                    stack.push(ni.getList().listIterator()); // add iterator to stack 
                }
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
