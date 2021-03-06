package c10.SortedWordCount;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class SortWordCount {
    static class Counter {
        private int i = 1;

        int read() {
            return i;
        }

        void increment() {
            i++;
        }
    }

    public static class SortedWordCount {
        private FileReader file;
        private StreamTokenizer st;
        private HashMap counts = new HashMap();

        SortedWordCount(String filename) throws FileNotFoundException {
            try {
                file = new FileReader(filename);
                st = new StreamTokenizer(new BufferedReader(file));
                st.ordinaryChar('.');
                st.ordinaryChar('-');
            } catch (FileNotFoundException e) {
                System.out.println("Could not open " + filename);
                throw e;
            }
        }

        void cleanup() {
            try {
                file.close();
            } catch (IOException e) {
                System.out.println(
                        "file.close() unsuccessful");
            }
        }

        void countWords() {
            try {
                while (st.nextToken() != StreamTokenizer.TT_EOF) {
                    String s;
                    switch (st.ttype) {
                        case StreamTokenizer.TT_EOL:
                            s = new String("EOL");
                            break;
                        case StreamTokenizer.TT_NUMBER:
                            s = Double.toString(st.nval);
                            break;
                        case StreamTokenizer.TT_WORD:
                            s = st.sval; // Already a String
                            break;
                        default: // single character in ttype
                            s = String.valueOf((char) st.ttype);
                    }
                    if (counts.containsKey(s))
                        ((Counter) counts.get(s)).increment();
                    else
                        counts.put(s, new Counter());
                }
            } catch (IOException e) {
                System.out.println(
                        "st.nextToken() unsuccessful");
            }
        }

        Collection values() {
            return counts.values();
        }

        Set keySet() {
            return counts.keySet();
        }

        Counter getCounter(String s) {
            return (Counter) counts.get(s);
        }

        Iterator sortedKeys() {
            Iterator e = counts.keySet().iterator();
            List<String> sv = new ArrayList<>();
            while (e.hasNext())
                sv.add((String) e.next());
// This call forces a sort:
            return sv.iterator();
        }

        public static void main(String[] args) {
            try {
                SortedWordCount wc = new SortedWordCount(args[0]);
                wc.countWords();
                Iterator keys = wc.sortedKeys();
                while (keys.hasNext()) {
                    String key = (String) keys.next();
                    System.out.println(key + ": " + wc.getCounter(key).read());
                }
                wc.cleanup();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
