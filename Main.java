
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Main {
public static void main(String[] args) {
FileSystem fs = FileSystems.getDefault();
System.out.println("===========================================");
System.out.println("Read-only file system: " + fs.isReadOnly());
System.out.println("File name separator: " + fs.getSeparator());
System.out.println("\n");
System.out.println("=============File Stores===================");
for (FileStore store : fs.getFileStores()) {
printDetails(store);
}
System.out.println("\n");
System.out.println("=============Root Directories===============");
for (Path root : fs.getRootDirectories()) {
System.out.println(root);
}
}
public static void printDetails(FileStore store) {
try {
String desc = store.toString();
long totalSpace = store.getTotalSpace();
long unallocatedSpace = store.getUnallocatedSpace();
long availableSpace = store.getUsableSpace();
System.out.println("\n");
System.out.println( "Descr: " + desc +
"\nTotal: " + totalSpace +
"\nUnallocated: " + unallocatedSpace +
"\nAvailable: " + availableSpace);
} catch (IOException e) {
e.printStackTrace();
}
}
}