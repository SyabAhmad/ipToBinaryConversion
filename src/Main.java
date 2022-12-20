import java.util.Scanner;

class MainControlPanel{
    char classForIP;
    String subnitMaskValue;
    int temp;
    int[] IPAddress = new int[4];
    int[] defaultValues = {128, 64, 32, 16, 8, 4, 2, 1};
    int[] tempIpAddress;
    int[] binaryConvertedIP = new int[8];
    Scanner reader= new Scanner(System.in);
}

class AllFuncionsAreHere extends MainControlPanel{
    public void getData(){
        System.out.println("To Convert Ip to Binary...");
        System.out.println("Enter You IP Address (one by one): ");
        for(int i = 0;i <4;  i++)
        {
            IPAddress[i] = reader.nextInt();
        }
        /// just to store in case of use
//        for (int j = 0;j<4;j++)
//        {
//            for (int k=0;k<4;k++)
//            {
//                tempIpAddress[j] = IPAddress[j];
//            }
//        }
    }

    public char ClassFinder(){
        if (IPAddress[0] > 1 && IPAddress[0] < 126)
        {
            classForIP = 'A';
        } else if (IPAddress[0] > 128 && IPAddress[0] < 191) {
            classForIP = 'B';
        } else if ((IPAddress[0] > 192 && IPAddress[0] < 223)) {
            classForIP = 'C';
        }else if ((IPAddress[0] > 224 && IPAddress[0] < 239)) {
            classForIP = 'D';
        }else if ((IPAddress[0] > 240 && IPAddress[0] < 254)) {
            classForIP = 'E';
        }
        return classForIP;
    }

    public String SubnitMaskFinder(){
        if (classForIP == 'A')
        {
            subnitMaskValue= "255.0.0.0";
        } else if (classForIP == 'B') {
            subnitMaskValue= "255.255.0.0";
        } else if (classForIP == 'C') {
            subnitMaskValue= "255.255.255.0";
        } else if (classForIP == 'D') {
            subnitMaskValue= "Reserved For Multicasting";
        } else if (classForIP == 'E') {
            subnitMaskValue= "Expiremental";
        }
        return subnitMaskValue;
    }

    public void ConversionTOBinary(){
        System.out.println("Conversion Started...");
        for(int i=0; i<8; i++)
        {
            if (IPAddress[0] > defaultValues[i])
            {
                temp = IPAddress[0]-defaultValues[i];
                binaryConvertedIP[0] = 1;
                if (temp > IPAddress[1])
                {
                    temp = IPAddress[1]-defaultValues[i];
                    binaryConvertedIP[1] = 1;
                    if (temp > IPAddress[2])
                    {
                        temp = IPAddress[2]-defaultValues[i];
                        binaryConvertedIP[2] = 1;
                        if (temp > IPAddress[3])
                        {
                            temp = IPAddress[3]-defaultValues[i];
                            binaryConvertedIP[3] = 1;
                        }
                        else{
                            binaryConvertedIP[1] = 0;
                        }
                    }
                    else{
                        binaryConvertedIP[1] = 0;
                    }
                }
                else {
                    binaryConvertedIP[1] = 0;
                }
            } else{
                binaryConvertedIP[1] = 0;
            }

        }
    }


}


public class Main {
    public static void main(String[] args) {
        System.out.println("Conversion of IP address to binary Form");
        System.out.println("Also with Class and Range of IP");

        AllFuncionsAreHere toCallMethods = new AllFuncionsAreHere();
        toCallMethods.getData();
        toCallMethods.ClassFinder();
        toCallMethods.SubnitMaskFinder();
        System.out.println(toCallMethods.ClassFinder());
        System.out.println(toCallMethods.SubnitMaskFinder());
    }
}