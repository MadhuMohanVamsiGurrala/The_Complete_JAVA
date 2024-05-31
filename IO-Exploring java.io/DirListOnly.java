import java.io.*;

// Filter for .html files only.
class OnlyExt implements FilenameFilter {
    String ext;

    public OnlyExt(String ext) {
        this.ext = "." + ext;
    }

    public boolean accept(File dir, String name) {
        return name.endsWith(ext);
    }
}

class DirListOnly {
    public static void main(String[] args) {
        String dirName = "E:\\Fullstack Accelerator\\The Complete JAVA\\IO-Exploring java.io";
        File f1 = new File(dirName);
        FilenameFilter only = new OnlyExt("html");
        String[] fileList = f1.list(only);

        if (fileList == null) {
            System.out.println("Directory is empty or an error occurred.");
        } else {
            for (String fileName : fileList) {
                System.out.println(fileName);
            }
        }
    }
}