import java.io.File;

public class SizeCalculator {


    public static String getHumanReadableSize(long size) {
        StringBuilder sb = new StringBuilder();
        if (size / Math.pow(1024, 4) >= 1) {
            sb.append((Math.round(size / Math.pow(1024, 4)))).append("Tb");
        } else if (size / Math.pow(1024, 3) >= 1) {
            sb.append(Math.round(size / Math.pow(1024, 3))).append("Gb");
        } else if (size / Math.pow(1024, 2) >= 1) {
            sb.append(Math.round(size / Math.pow(1024, 2))).append("Mb");
        } else if (size / 1024 > 1) {
            sb.append(Math.round(size / 1024)).append("Kb");
        } else {
            sb.append(size).append("B");
        }
        return sb.toString();
    }

    public static long getSizeFromHumanReadable(String size) {

        String regex2 = "(\\d+)([B|K|M|G|T]?b?)";
        String digit = size.replaceAll(regex2, "$1").trim();
        String format = size.replaceAll(regex2, "$2").trim();

        return switch (format) {
            case "B" -> Long.parseLong(digit);
            case "Kb" -> 1024 * Long.parseLong(digit);
            case "Mb" -> Math.round((Math.pow(1024, 2) * Long.parseLong(digit)));
            case "Gb" -> Math.round((Math.pow(1024, 3) * Long.parseLong(digit)));
            case "Tb" -> Math.round((Math.pow(1024, 4) * Long.parseLong(digit)));
            default -> 0;
        };
    }
}
