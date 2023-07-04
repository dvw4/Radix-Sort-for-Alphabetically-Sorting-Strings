import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;


public class assignment3{
    final static int K = 21;
    public static String paddingSpace(String name){
        return name.format("%-"+K+"s",name);
    }
    public static void writeToFile(char[][] array, String outputFile){
        try{
            File outputFileObj = new File(outputFile);
            outputFileObj.createNewFile();
        }catch (IOException e){
            System.out.print("Error occured while creating a output file.");
        }
        try{
            FileWriter outputToFile = new FileWriter(outputFile);
            for(int i = 0; i < array.length; i++){
                for(int j = 0; j < array[i].length; j++){
                    outputToFile.write(array[i][j]);
                }
                outputToFile.write("\n");
            }
            outputToFile.close();
        }catch (IOException e){
            System.out.print("Error occured while writing to a output file.");
        }
    }
    public static void insertInArray(char[] array, String word){
        for(int i = 0; i < word.length(); i++){
            array[i] = word.charAt(i);
        }
    }
    public static void radixSort(char[][] initialData, int largestWord){
        char[][] temp = new char[initialData.length][K];
        for(int i = largestWord - 1; i >= 0; i--) {
            int[] count = new int[257];
            for(int j = 0; j < initialData.length; j++) {
                count[initialData[j][i] + 1]++;
            }
            for(int k = 1; k < 256; k++) {
                count[k] += count[k - 1];
            }
            for(int j = 0; j < initialData.length; j++) {
                temp[count[initialData[j][i]]++] = initialData[j];
            }
            for(int j = 0; j < initialData.length; j++){
                initialData[j] = temp[j];
            }
        }

    }
    public static void main(String argv[]){
        char[][] lastNames = new char[1000][K];
        int largestName = -1;
        int counter = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("Please specify the input file (default = f.txt): ");
        String fin = scan.nextLine();
        if (fin.length() == 0) {
            fin = "f.txt";
        }
        System.out.print("Please specify the output file (default = g.txt): ");
        String fout = scan.nextLine();
        if (fout.length() == 0) {
            fout = "g.txt";
        }
        try{
            File myObj = new File(fin);
            Scanner fileReader = new Scanner(myObj);
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                data = data.trim();
                if (data.length() > largestName) largestName = data.length();
                data = paddingSpace(data.trim());
                insertInArray(lastNames[counter], data);
                counter++;
            }
            radixSort(lastNames, largestName);
            writeToFile(lastNames,fout);
        }catch (FileNotFoundException e){
            System.out.println("File not found. You need to have correct file name and path.");
        }
    }
}
