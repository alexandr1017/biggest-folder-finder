import java.io.File;
import java.util.ArrayList;

public class Node {
    private File folder;
    private ArrayList<Node> children;
    private long size;
    private int level;


    private long limit;

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Node(File folder, long limit) {
        this.folder = folder;
        this.limit = limit;
        children = new ArrayList<>();
    }


    public ArrayList<Node> getChildren() {
        return children;
    }

    public File getFolder() {
        return folder;
    }

    public void addChild(Node node) {
        node.setLevel(level + 1);
        children.add(node);
    }

    public int getLevel() {
        return level;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    public long getLimit() {
        return limit;
    }


    @Override
    public String toString() {


        StringBuilder sb = new StringBuilder();
        String size = SizeCalculator.getHumanReadableSize(getSize());
        sb.append(folder.getName() + " - " + size + "\n");
        for (Node child : children) {
            if (child.getSize() < limit) continue;
            sb.append("    ".repeat(this.level + 1) + child);
        }
        return sb.toString();
    }
}
