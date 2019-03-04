import java.util.List;

/**
 * A symbolic link to a folder in a file system.
 * 
 * @author Sandro Bellini
 */
public class FolderLink extends Link<Folder> {

    /**
     * Constructs a new link to a folder.
     *
     * @param parent the parent folder of this link; must not be null 
     * @param name the name of this link; must not be null
     * @param target the folder to which this links points; must not be null 
     */
    public FolderLink(Folder parent, String name, Folder target) {
        super(parent, name, target);
    }

    /* (non-Javadoc)
     * @see Entry#isInFileSystem()
     */
    public boolean isInFileSystem(){
        List<Entry> a = getParentFolder().getList();
        if(a.toString().contains(this.toString())){
            return true;
        }
        return false;
    }

    /* (non-Javadoc)
     * @see Entry#getPath()
     */
    @Override
    public String getPath() {
        return getParentFolder() + getName() + SEPARATOR;
    }

    /* (non-Javadoc)
     * @see Entry#getSize()
     */
    @Override
    public int getSize() {
        return 0;
    } 
    //// comment 
    public FolderLink getFolderLink(){
        return this;

    }

    /* (non-Javadoc)
     * @see Entry#remove()
     */   
    @Override
    public void remove() {
        List<Entry> a = getParentFolder().getList();
        a.remove(this);
    }


    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        return obj instanceof FolderLink;
    }
}
