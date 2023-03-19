import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {

        ParametrsBag parametrsBag= new ParametrsBag(args);

        String folderPath = parametrsBag.getPath();
        long sizeLimit = parametrsBag.getLimit();
        File file = new File(folderPath);
        Node root = new Node(file, sizeLimit);

        long start = System.currentTimeMillis();
        FolderSizeCalculator calculator = new FolderSizeCalculator(root);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(calculator);
        System.out.println(root);
        long finish = System.currentTimeMillis() - start;
        System.out.println(finish + " ms");
    }

}

