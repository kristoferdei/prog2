//javac liskov.java
//java liskov

class Emlos {
    public void fut() {
        System.out.println("fut");
    }
}

class Tigris extends Emlos {  
}

class Balna extends Emlos {    
}

public class liskov {
    
    public void fut() {};
    
    public static void main(String[] args) {
        Emlos emlos = new Emlos();
        emlos.fut();
        
        Tigris tigris = new Tigris();
        tigris.fut();
        
        Balna balna = new Balna();
        balna.fut();    //liskov elv megsértése: mert a bálna hiába emlős, de nem tud futni
        
    }
}
