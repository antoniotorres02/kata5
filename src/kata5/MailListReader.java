package kata5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

class MailListReader {
    File textFile;
    private static final Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");

    
    
    public static MailListReader of(String path) {
        File file = new File(path);
        return new MailListReader(file);
    }
    
    private MailListReader(File textFile) {
        this.textFile = textFile;
    }
    
    public List<String> read() {
        List<String> result = new ArrayList<>();
        Iterator<String> iterator = createIterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (isMail(next)) result.add(next);
        }
        return result;
    }
    
    private Iterator<String> createIterator() {
        return new Iterator<String>() {
            BufferedReader reader = createReader();
            String nextLine = nextLine();

            
            @Override
            public boolean hasNext() {
                return nextLine != null;
            }

            @Override
            public String next() {
                String line = nextLine;
                nextLine = nextLine();
                return line;
            }

            private String nextLine() {
                try {
                    return reader.readLine();
                } catch (IOException ex) {
                    return null;
                }
            }
            
        };
    }
    
    private BufferedReader createReader() {
        try {
            return new BufferedReader(new FileReader(textFile));
        } catch (FileNotFoundException ex) {
            return null;
        }
    }
    
    private boolean isMail(String line) {
        return pattern.matcher(line).matches();
    } 
}
