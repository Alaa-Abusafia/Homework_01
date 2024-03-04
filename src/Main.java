import java.util.ArrayList;
import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> parsedArgs = parseArgs(args);
        System.out.println("Parsed Arguments:");
        for (String key : parsedArgs.keySet()) {
            ArrayList<String> values = parsedArgs.get(key);

            if (values != null && !values.isEmpty()) {
                System.out.println(key + " -> " + values.get(0));
            } else {
                System.out.println(key + " -> No values");
            }
        }

    }

    /**
     * Parses the command line arguments into a HashMap of arguments
     * @param args The command line arguments
     * @return A HashMap of arguments
     */
    private static HashMap<String, ArrayList<String>> parseArgs(String[] args) {
        HashMap<String, ArrayList<String>> parsedArgs = new HashMap<>();
        ArrayList<String> argValues = null;
        for (String arg : args) {
            // Check if the argument is a key (starts with "-")
            if (arg.startsWith("-")) {
                // Create a new ArrayList for values
                argValues = new ArrayList<>();
                // Remove the leading dash and store the key in the HashMap
                parsedArgs.put(arg.substring(1), argValues);
                continue;
            }

            // If the current argument is a value, add it to the current ArrayList
            if (argValues != null) {
                argValues.add(arg);
            }
        }
        return parsedArgs;
    }
}