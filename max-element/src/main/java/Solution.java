import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getMax' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY operations as parameter.
     */

    public static List<Integer> getMax(List<String> operations) {
        List<Integer> res = new ArrayList();
        Stack<Long> stack = new Stack<Long>();
        Stack<Long> maxStack = new Stack<Long>();
        for(String operation : operations){
            String[] opr = operation.split(" ");
            int type = Integer.valueOf(opr[0]);
            Long x = 0L;
            if(opr.length > 1){
                x = Long.valueOf(opr[1]);
            }
            
            switch(type){
                case 1:
                    stack.push(x);
                    if(maxStack.isEmpty() || x >= maxStack.peek()) {
                        maxStack.push(x);
                    }
                break;
                case 2:
                    Long pop = stack.pop();
                    if(pop == maxStack.peek()) {
                        maxStack.pop();
                    }
                break;
                case 3:
                    res.add(maxStack.peek().intValue());
                    //System.out.println(maxStack.peek());
                break;
                default:
                break;
            }
        }
        return res;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> res = Result.getMax(ops);

        bufferedWriter.write(
            res.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
