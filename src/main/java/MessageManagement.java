/**
 * Created by mudasser on 05/07/16.

 You have the following array of strings...

 a  = [  "Dear [name],\n",
         "\n",
         "Thanks for buying the [num] [item].\n",
         "We appreciate your patronage\n",
         "\n",
         "Best, [sales_person]\n" ]

  Replace the items in a[] with the appropriate values from the b dictionary.

     b = { 'name' : 'Anna Bell Smith',
           'num' : 'eight',
           'item' : 'Boxes of Soap',
           'sales_person' : 'Karmine Smithe' }


 Write a class that represents the document (contaiins the a array).
 Write a method that take the dictionary b and applies its values to the the array a.

 */


import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageManagement
{
    private String[] a = {"Dear [name],\n",
            "\n",
            "Thanks for buying the [num] [item].\n",
            "We appreciate your patronage\n",
            "\n",
            "Best, [sales_person]\n" };

    private LinkedHashMap<String, String> b = new LinkedHashMap<String,String>();

    private void setb()
    {
        b.put("name","Anna Bell Smith");
        b.put("num","eight");
        b.put("item","Boxes of Soap");
        b.put("sales_person","Karmine Smithe");
    }

    public void manageMessage(String[] a,LinkedHashMap<String,String> b)
    {
        for(int i =0; i<a.length;i++)
        {
            Pattern pattern = Pattern.compile("\\[\\w+\\]");
            Matcher matcher = pattern.matcher(a[i]);
            while(matcher.find())
            {
                String word = matcher.group();
                word = word.replace("[", "");
                word = word.replace("]", "");
                a[i] = a[i].replaceAll("\\["+word+"\\]", b.get(word));
            }
        }
        for(String s:a)
            System.out.print(s);
    }
    public static void main(String args[])
    {
        MessageManagement mm = new MessageManagement();
        mm.setb();
        mm.manageMessage(mm.a,mm.b);
    }
}
