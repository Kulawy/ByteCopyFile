import java.io.*;
import java.net.URL;

public class FileManager {

    private String path;
    private File baseFile;
    private File newFile;

    public FileManager(){

    }

    public boolean loadFile(String name){

        //String workingDirectory = System.getProperty("user.dir");
        //this.path = name;
        //FileReader fileReader;
        //URL resources = getClass().getResource("name");
        //File source = new File(resources.getFile());

        try{
            //fileReader = new FileReader(path);
            //DataInputStream dataInputStream = new DataInputStream(new FileInputStream(path));
            ClassLoader classLoader = getClass().getClassLoader();
            baseFile = new File (classLoader.getResource(name).getFile());
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public boolean createNewFile(){

        try{
            String newPathName = baseFile.getName();
            int index = newPathName.lastIndexOf(".");
            String suffix = newPathName.substring( index+1);
            newPathName = newPathName.substring(0, index) + "_copy." + suffix;

            try {
                newFile = new File(newPathName);

                if ( newFile.createNewFile() ) {
                    return true;
                }else{
                    System.out.println(" erron on CREATE_NEW_FILE");
                    return false;
                }


            } catch (IOException e){
                e.printStackTrace();
                return false;
            }
        }catch(NullPointerException e){
            System.out.println("error on CREATE_NEW_FILE baseFile is missing");
            return false;
        }
    }



    public boolean copyFile(File src, File dst) {

        try {
            InputStream inputStream = new FileInputStream(src);
            OutputStream outputStream = new FileOutputStream(dst);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }

            inputStream.close();
            outputStream.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public File getNewFile() {
        return newFile;
    }

    public File getBaseFile() {
        return baseFile;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
