import java.util.Vector;

/**
 * Created by mohammad on 3/12/17.
 */
public class Vigenere {


    Vector<Vector<Integer>> VigenereTable=new Vector<>();
    int getItem(int  row,int column)
    {

        int i=row - 'A';
        int j=column - 'A';
        Vector<Integer> v = VigenereTable.get(i);


        return v.get(j);
    }
    char[] _message;
    char[] _cipherMessage;
    char[] _key;
    char[] _keylenthofm;
    void set_cipherMessage(String cipherMessage)

    {
        cipherMessage=removeNoAlphabet(cipherMessage);
        _cipherMessage=cipherMessage.toUpperCase().toCharArray();
    }
    void set_message(String Message){
        Message=removeNoAlphabet(Message);
        _message = Message.toUpperCase().toCharArray();


    }
    void set_key(String Key)
    {
        Key=removeNoAlphabet(Key);
        _key=Key.toUpperCase().toCharArray();
    }

    String Decryption()
    {
        int l=_cipherMessage.length;
        String s="";
        for (int i=0;i<=l-1;i++)
        {
            s+=_key[i%(_key.length)];
        }
        _keylenthofm=s.toCharArray();

        String ret="";
        for(int i=0;i<=_cipherMessage.length-1;i++)
        {
            int e = plainText(i);
            ret+=(char)e;
        }
        return ret;
    }
    String Encryption()
    {
        int l=_message.length;
        String s="";
        for (int i=0;i<=l-1;i++)
        {
            s+=_key[i%(_key.length)];
        }
        _keylenthofm=s.toCharArray();
        String ret="";
        for(int i=0;i<=_message.length-1;i++)
         {
            int e = Cipher(i);
            ret+=(char)e;
        }
        return ret;
    }
    private int Cipher(int i)
    {

        return getItem(_message[i],_keylenthofm[i]);
    }
    private int plainText(int i)
    {
        int col=_keylenthofm[i];
        Vector<Integer> r0=VigenereTable.get(0);

        col=r0.indexOf(col);
        for (int k=0;k<=r0.size()-1;k++)
        {
            Vector<Integer> rk=VigenereTable.get(k);
            if (rk.get(col)==_cipherMessage[i])
            {
                return rk.get(0);

            }

        }

        return 0;
    }

    String removeNoAlphabet(String s)
    {
        String ret="";
        char[] sc=s.toUpperCase().toCharArray();
        for (char c:sc

             ) {
            if ((c<='Z') & (c>='A'))
            {
                ret+=(char)c;

            }


        }
        return ret;

    }
    Vector<Vector<Integer>> generateVigenereTable()
    {
        VigenereTable=new Vector<>();
        for (int j=0;j<=25;j++){
        Vector<Integer> v=new Vector<>();

        for(int i='A'; i<='Z';i++)
        {
            v.add(i-'A','A'+((i+j-'A')%('Z'-'A'+1)));


        }
            VigenereTable.add(j,v);

        }
        return VigenereTable;
    }
}
