package be.ehb.todolist;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Helper {

    public static final  String FIRSTNAME = "listinfo.dat";

    public static void writeDate(ArrayList<String> item, Context context){
        {
            try {
                FileOutputStream fos = context.openFileOutput(FIRSTNAME, Context.MODE_PRIVATE);
                ObjectOutputStream oas = new ObjectOutputStream(fos);
                oas.writeObject(item);
                oas.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<String> readDate(Context context)
    {
        ArrayList<String> itemList = null;

        try {
            FileInputStream fis = context.openFileInput(FIRSTNAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            itemList = (ArrayList<String>) ois.readObject();


        } catch (FileNotFoundException e) {

            itemList = new ArrayList<>();

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return itemList;
    }
}
