import java.io.File;

public class ParametrsBag {
    public long limit;
    public String path;

    public ParametrsBag(String args[]) {
        if (args.length != 4) {
            throw new IllegalArgumentException("Укажите два параметра: -l (лимит по размеру) и -d (путь к папке)");
        }

        for (int i = 0; i < 4; i = i + 2) {
            if (args[i].equals("-l")) {
                this.limit = SizeCalculator.getSizeFromHumanReadable(args[i + 1]);
            }
            if (args[i].equals("-d")) {
                this.path = args[i + 1];
            }
        }

        if (limit<=0) {
            throw new IllegalArgumentException("Лимит не указан или указан неверно!");
        }

        File folder = new File(path);
        if (!folder.exists() || !folder.isDirectory()) {
            throw new IllegalArgumentException("Путь к папке не указан или указан неверно!");
        }

        for (int i = 0; i < args.length; i++) {
            System.out.println(i + " => " + args[i]);
        }

    }

    public long getLimit() {
        return limit;
    }

    public String getPath() {
        return path;
    }

}
