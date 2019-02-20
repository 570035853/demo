package interview.javaBasic;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class BigEndian {

    public static void main(String[] args) {
        byte arr[] = new byte[4];
        arr[0] = 0x78;
        arr[1] = 0x56;
        arr[2] = 0x34;
        arr[3] = 0x12;

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arr);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        try {
            System.out.println(Integer.toHexString(dataInputStream.readInt()));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
