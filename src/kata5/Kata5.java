package kata5;

import java.util.List;


public class Kata5 {

    public static void main(String[] args) {
        String path = "email.txt" ;
        MailListReader mlr = MailListReader.of(path);
        List<String> lista = mlr.read();
        MailTableApp mailTableApp = new MailTableApp();
        for (String mail : lista) {
            mailTableApp.insert(mail);
        }
    }
}
