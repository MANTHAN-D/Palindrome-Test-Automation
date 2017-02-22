import org.apache.commons.lang3.StringUtils;

/**
 * Created by madoshi on 2/20/17.
 */
public class Palindrome {

    public String testMe(String para){
        System.out.println("Inside test"+ para);
        return "I return "+para;
    }

    public boolean isPalindrome(String str) throws NullPointerException{
        //Null value is not Palindrome
        if(str == null)
            throw new NullPointerException("Input is null!");

        //Eliminate white spaces and case sensitivity
        str = str.replaceAll("\\s","").toLowerCase();

        //Empty value or the one with only spaces is palindrome
        if(str.equals(""))
            return true;
        //String with special characters must be non-palindrome
        else if(!StringUtils.isAlphanumeric(str))
            return false;
        //Handle non-empty and non-null case
        else {
            int front=0,rear=str.length()-1;
            while(front < rear){
                if(str.charAt(front) != str.charAt(rear)){
                    //Return on finding first non-matching character
                    return false;
                }
                front++;
                rear--;
            }
            return true;
        }
    }
}