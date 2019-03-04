
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class EntryTest.
 *
 * @author  Sandro Bellini
 * @version (a version number or a date)
 */
public class EntryTest
{

    @Test
    public void test_newRootFolder_has_size0() {
        FileSystem fs = new FileSystem();
        Folder root = fs.getRootFolder();
        assertEquals(0, root.getSize());
    }

    @Test
    public void test_check_actual_sizeOfFile_is_correct() {
        FileSystem fs = new FileSystem();
        Folder root = fs.getRootFolder();
        Folder a = new Folder(root, "Users");
        File aa = new File(a, "hello", 50);
        assertEquals(50, aa.getSize());
    }

    @Test
    public void test_check_current_sizeOfRootFolder_is_correct() {
        FileSystem fs = new FileSystem();
        Folder root = fs.getRootFolder();
        Folder a = new Folder(root, "Users");
        File aa = new File(a, "hello", 50);
        assertEquals(50, root.getSize());
    }

    @Test
    public void test_check_current_sizeOfRootFolder_is_correct_after_removing_file() {
        FileSystem fs = new FileSystem();
        Folder root = fs.getRootFolder();
        Folder a = new Folder(root, "Users");
        File aa = new File(a, "hello", 50);
        aa.remove();
        assertEquals(0, root.getSize());
    }

    @Test
    public void test_after_createFile_fileIsInTheSystem() {
        FileSystem fs = new FileSystem();
        Folder root = fs.getRootFolder();
        Folder a = new Folder(root, "Users");
        File aa = new File(a, "hello", 50);
        assertEquals(true, aa.isInFileSystem());
    }

    @Test
    public void test_after_createFile_then_removingIt_file_isNotInTheSystem() {
        FileSystem fs = new FileSystem();
        Folder root = fs.getRootFolder();
        Folder a = new Folder(root, "Users");
        File aa = new File(a, "hello", 50);
        aa.remove();
        assertEquals(false, aa.isInFileSystem());
    }

    @Test
    public void test_if_fileName_isCorrect() {
        FileSystem fs = new FileSystem();
        Folder root = fs.getRootFolder();
        Folder a = new Folder(root, "Users");
        File aa = new File(a, "hello", 50);
        assertEquals("hello", aa.getName());
    }

    @Test
    public void test_if_pathToFile_isCorrect() {
        FileSystem fs = new FileSystem();
        Folder root = fs.getRootFolder();
        Folder a = new Folder(root, "Users");
        File aa = new File(a, "hello", 50);
        assertEquals("/hello", Entry.SEPARATOR+aa.getName());
    }

    @Test
    public void  test_if_pathToFolder_isCorrect() {
        FileSystem fs = new FileSystem();
        Folder root = fs.getRootFolder();
        Folder a = new Folder(root, "aFolder");
        //File aa = new File(a, "hello", 50);
        assertEquals("/aFolder/", Entry.SEPARATOR+a.getName()+Entry.SEPARATOR);
    }

    @Test
    public void test_create_folderLink_check_if_targetLink_isEqualTo_originalFolder() {
        FileSystem fs = new FileSystem();
        Folder root = fs.getRootFolder();
        Folder a = new Folder(root, "aFolder"); 
        FolderLink abb = new FolderLink(a, "bFolder", a);
        assertEquals(a.getPath(), abb.getTarget().toString());
    }

    @Test
    public void test_create_fileLink_then_removeIt_checkIf_file_isInTheSystem() {
        FileSystem fs = new FileSystem();
        Folder root = fs.getRootFolder();
        Folder a = new Folder(root, "aFolder"); 
        File aa = new File(a, "a name", 48);
        FileLink ac = new FileLink(a, "b name", aa);
        ac.remove();
        assertEquals(true, aa.isInFileSystem());
    }

    @Test
    public void test_create_fileLink_then_removeIt_checkIf_fileLink_isNotInTheSystem() {
        FileSystem fs = new FileSystem();
        Folder root = fs.getRootFolder();
        Folder a = new Folder(root, "aFolder"); 
        File aa = new File(a, "a name", 48);
        FileLink ac = new FileLink(a, "b name", aa);
        ac.remove();
        assertEquals(false, ac.isInFileSystem());
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_if_rootFolderName_null_throws_llegalArgumentException() {
        FileSystem fs = new FileSystem();
        Folder root = fs.getRootFolder();
        Folder a = new Folder(root, null);      

    }

    @Test
    public void test_create_two_files_sameName_throws_llegalArgumentException() {
        FileSystem fs = new FileSystem();
        Folder root = fs.getRootFolder();
        Folder a = new Folder(root, "aFolder");      
        File aa = new File(a, "f", 20);
        File ab = new File(a, "f", 30);
    }

}
