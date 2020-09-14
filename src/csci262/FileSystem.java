package csci262;

import javafx.util.Pair;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

//No write down, no read up
//
//0 read 0 append 0,1,2,3 write 0
//1 read 0,1 append 1,2,3 write 1
//2 read 0,1,2 append 2,3 write 2
//3 read 0,1,2,3 append 3 write 3
public class FileSystem {
    static Set<String> usernameSet = new HashSet<>();
//    static Map<String,String> saltMap = new HashMap<String,String>();
//    static Map<String,Pair<String,Integer>> shadowMap = new HashMap<String,Pair<String,Integer>>();

    public static void main(String[] args) {
        String testStr = "This is a test";
        System.out.println("MD5 ("+testStr+") = "+md5(testStr));

        if(args.length==1&&args[0].equals("-i")){
//            System.out.println(args[0]);
            initFileSystem();
//            startFileSystem();
        }else if(args.length==0){
            startFileSystem();
        }else{
            System.out.println("wrong args");
        }
//        for(int i=0; i<100; ++i){
//            System.out.println(createSalt());
//        }
//        try {
//            System.out.println(checkPassword("abc12","abc12"));
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        };
//        try {
//            System.out.println(checkPassword("abcA23","abcX23"));
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        };
//        try {
//            System.out.println(checkPassword("abc123","abc123"));
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        };
//        try {
//            System.out.println(checkPassword("abcABC","abcABC"));
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        };
    }

    public static void startFileSystem() {
        try {
            FileStore.getFileStore().loadFiles();
            Pair<String,Integer> usernameAndClearance = login();
            startMenu(usernameAndClearance.getKey(),usernameAndClearance.getValue());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void startMenu(String un,int cl) {
        boolean ifExit = false;
        String userInput,fn;
        Scanner in = new Scanner(System.in);

        while (!ifExit){
            System.out.println("Options: (C)reate, (A)ppend, (R)ead, (W)rite, (L)ist, (S)ave or (E)xit.");
            userInput = in.next();

            switch (userInput){
                case "C":{
                    System.out.print("Filename: ");
                    fn = in.next();
                    try {
                        FileStore.getFileStore().createFile(fn,un,cl);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case "A":{
                    System.out.print("Filename: ");
                    fn = in.next();
                    try {
                        if(FileStore.getFileStore().appendFile(fn,cl)){
                            System.out.println("success");
                        }else{
                            System.out.println("failure");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case "R":{
                    System.out.print("Filename: ");
                    fn = in.next();
                    try {
                        if(FileStore.getFileStore().readFile(fn,cl)){
                            System.out.println("success");
                        }else{
                            System.out.println("failure");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case "W":{
                    System.out.print("Filename: ");
                    fn = in.next();
                    try {
                        if(FileStore.getFileStore().writeFile(fn,cl)){
                            System.out.println("success");
                        }else{
                            System.out.println("failure");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case "L":{
                    FileStore.getFileStore().listFiles();
                    break;
                }
                case "S":{
                    FileStore.getFileStore().saveFiles();
                    break;
                }
                case "E":{
                    System.out.println("Shut down the FileSystem? (Y)es or (N)o");
                    userInput = in.next();
                    if(userInput.equals("Y")){
                        ifExit=true;
                    }else if(userInput.equals("N")){

                    }else{
                        System.out.println("wrong input");
                    }
                    break;
                }
                default:{
                    System.out.println("wrong input");
                }
            }
        }
    }

    public static Pair<String,Integer> login() throws Exception {
        String un,pw,passSaltHash,cl;
        Scanner in = new Scanner(System.in);

        System.out.print("Username: ");
        un=in.next();

        System.out.print("Password: ");
        pw=in.next();

        String salt = checkSalt(un);

        passSaltHash = hash(pw+salt);

        cl = checkShadow(un,passSaltHash);

        System.out.println("Authentication for user "+un+" complete.");
        System.out.println("The clearance for "+un+" is "+cl+".");

        return new Pair<String,Integer>(un,Integer.parseInt(cl));
    }

    public static String checkSalt(String un) throws Exception {
        try {
            File file = new File("salt.txt");
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line = in.readLine();
            line = in.readLine();
            while(line!=null){
                String[] fields = line.split(":");
                if(fields[0].equals(un)){
                    System.out.println(un+" found in salt.txt");
                    System.out.println("salt retrieved: "+fields[1]);
                    return fields[1];
                }
                line = in.readLine();
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new Exception(un+" not found in salt.txt");
    }

    public static String hash(String passSalt) {
        System.out.println("hashing ..."/*+passSalt*/);
        String passSaltHash = md5(passSalt);
        System.out.println("hash value: "+passSaltHash);
        return passSaltHash;
    }

    public static String checkShadow(String un,String passSaltHash) throws Exception {
        try {
            File file = new File("shadow.txt");
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line = in.readLine();
            line = in.readLine();
            while(line!=null){
                String[] fields = line.split(":");
                if(fields[0].equals(un)){
                    if(fields[1].equals(passSaltHash)){
                        return fields[2];
                    }else{
                        throw new Exception("shadow information doesn\'t match.");
                    }
                }
                line = in.readLine();
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new Exception(un+" shadow information doesn\'t found.");
    }

    public static void initFileSystem() {
        readOrCreateSaltFile();
        readOrCreateShadowFile();
        registerUser();
    }

    public static void registerUser() {
        String un,pw,cpw;
        int cl;
        Scanner in = new Scanner(System.in);

        System.out.print("Username: ");
        un = in.nextLine();

        if(un.contains(" ")){
            System.out.println("The username cannot contain \' \'.");
            return;
        }

        if(un.contains(":")){
            System.out.println("The username cannot contain \':\'.");
            return;
        }

//        if(saltMap.containsKey(un)||shadowMap.containsKey(un)){
        if(usernameSet.contains(un)){
            System.out.println("The username exists already.");
            return;
        }

        System.out.print("Password: ");
        pw = in.nextLine();

        System.out.print("Confirm Password: ");
        cpw = in.nextLine();

        try {
            checkPassword(pw,cpw);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.print("User clearance (0 or 1 or 2 or 3): ");
        cl = in.nextInt();

        if(cl<0||cl>3){
            System.out.println("wrong user clearance");
            return;
        }

        String salt = createSalt();
        appendToFile("salt.txt","\r\n"+un+":"+ salt);

        String passSaltHash = md5(pw+salt);
        appendToFile("shadow.txt","\r\n"+un+":"+passSaltHash+":"+cl);
    }

    public static void readOrCreateSaltFile(){
        File file = new File("salt.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
                BufferedWriter out = new BufferedWriter(new FileWriter(file));
                out.write("Username:Salt");
//                out.newLine();
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
//            System.out.println("salt file not exists");
//            System.out.println("create salt file");
        }
//        System.out.println("salt file exists");
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line = in.readLine();
//            System.out.println(line);
            line = in.readLine();
            while(line!=null){
//                System.out.println(line);
                String[] fields = line.split(":");
                usernameSet.add(fields[0]);
//                saltMap.put(fields[0],fields[1]);
                line = in.readLine();
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readOrCreateShadowFile(){
        File file = new File("shadow.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
                BufferedWriter out = new BufferedWriter(new FileWriter(file));
                out.write("Username:PassSaltHash:SecurityClearance");
//                out.newLine();
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
//            System.out.println("shadow file not exists");
//            System.out.println("create shadow file");
        }
//        System.out.println("shadow file exists");
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line = in.readLine();
//            System.out.println(line);
            line = in.readLine();
            while(line!=null){
//                System.out.println(line);
                String[] fields = line.split(":");
                usernameSet.add(fields[0]);
//                shadowMap.put(fields[0],new Pair<String,Integer>(fields[1],Integer.parseInt(fields[2])));
                line = in.readLine();
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkPassword(String pw,String cpw) throws Exception {
        if(!pw.equals(cpw)){
            throw new Exception("these two password are different.");
        }

        if(pw.length()<6){
            throw new Exception("password must be at least 6 letters or numbers.");
        }

        if(pw.contains(" ")){
            throw new Exception("password cannot contain \':\'.");
        }

        if(!pw.matches("^.*[A-Z].*$")){
            throw new Exception("password must contain one uppercase letter.");
        }

        if(!pw.matches("^.*[0-9].*$")){
            throw new Exception("password must contain one number.");
        }

        return true;
    }

    public static String createSalt() {
        String salt = "";
        for(int i=0; i<8; ++i)
            salt+=(int)Math.floor(Math.random()*10);
        return salt;
    }

    public static void appendToFile(String fileName, String content) {
        try {
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            long fileLength = randomFile.length();
            randomFile.seek(fileLength);
            randomFile.writeBytes(content);
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String hex(byte[] array) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; ++i) {
            sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).toUpperCase().substring(1,3));
        }
        return sb.toString();
    }

    public static String md5 (String message) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return hex (md.digest(message.getBytes("CP1252"))).toLowerCase();
        } catch (NoSuchAlgorithmException e) {
        } catch (UnsupportedEncodingException e) {
        }
        return null;
    }
}

//No write down, no read up
//
//0 read 0 append 0,1,2,3 write 0
//1 read 0,1 append 1,2,3 write 1
//2 read 0,1,2 append 2,3 write 2
//3 read 0,1,2,3 append 3 write 3
class FileStore{
    private static FileStore fs;
    private Map<String,CFile> fileMap;

    private FileStore() {
        this.fileMap = new HashMap<>();
    }

    public static FileStore getFileStore(){
        if(fs==null){
            fs = new FileStore();
        }
        return fs;
    }

    public void createFile(String fn,String un,int cl) throws Exception {
        if(this.fileMap.containsKey(fn)){
            throw new Exception("file exists");
        }

        this.fileMap.put(fn,new CFile(fn,un,cl));
    }

    public boolean appendFile(String fn,int cl) throws Exception{
        if(!this.fileMap.containsKey(fn)){
            throw new Exception("file doesn\'t exist");
        }

        return this.fileMap.get(fn).classification>=cl;
    }

    public boolean readFile(String fn,int cl) throws Exception{
        if(!this.fileMap.containsKey(fn)){
            throw new Exception("file doesn\'t exist");
        }

        return this.fileMap.get(fn).classification<=cl;
    }

    public boolean writeFile(String fn,int cl) throws Exception{
        if(!this.fileMap.containsKey(fn)){
            throw new Exception("file doesn\'t exist");
        }

        return this.fileMap.get(fn).classification==cl;
    }

    public void listFiles(){
        for(CFile cf:this.fileMap.values()){
            System.out.println(cf.name);
        }
    }

    public void loadFiles(){
        File file = new File("Files.store");
        if (!file.exists()) {
            try {
                file.createNewFile();
                BufferedWriter out = new BufferedWriter(new FileWriter(file));
                out.write("name:owner:classification");
                out.newLine();
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
//            System.out.println("salt file not exists");
//            System.out.println("create salt file");
        }

        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line = in.readLine();
            line = in.readLine();
            while(line!=null){
                CFile f = CFile.loadFromString(line,":");
                this.fileMap.put(f.name,f);
                line = in.readLine();
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveFiles(){
        try {
            File file = new File("Files.store");
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            out.write("name:owner:classification");
            for(CFile cf:this.fileMap.values()){
                out.newLine();
                out.write(cf.toStringForSave(":"));
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class CFile {
    String name,owner;
    int classification;

    public CFile(String name, String owner, int classification) {
        this.name = name;
        this.owner = owner;
        this.classification = classification;
    }

    public static CFile loadFromString(String line,String deli){
        String[] fields = line.split(deli);
        return new CFile(fields[0],fields[1],Integer.parseInt(fields[2]));
    }

    public String toStringForSave(String deli) {
        return this.name+deli+this.owner+deli+this.classification;
    }
}
