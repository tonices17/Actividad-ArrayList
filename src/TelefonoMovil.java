import java.util.ArrayList;

public class TelefonoMovil {
    private String myNumber;
    private static ArrayList<Contacto> myContacts = new ArrayList<>();
    private static int posicion;
    private static boolean devolver;

    public TelefonoMovil(String myNumber) {
        this.myNumber = myNumber;
        myContacts.add(Contacto.createContact("Mio",myNumber));
    }
    private static int findContact(Contacto contacto){
        posicion = myContacts.indexOf(contacto);

        return posicion;
    }
   private static int findContact(String name){
        posicion = -1;
        for(int i = 0 ; i < myContacts.size() ; i++){
            if(myContacts.get(i).getName().equalsIgnoreCase(name)){
                posicion = i;
            }
        }
        return posicion;
    }
    public static boolean addNewContact(Contacto contacto){
        if (findContact(contacto.getName()) == -1) {
            myContacts.add(contacto);
            devolver = true;
        }
        else{
            devolver = false;
        }
        return devolver;
    }
    public static boolean updateContact(Contacto antiguo,Contacto nuevo){
        if(findContact(antiguo) == -1){
            devolver = false;
        }
        else{
            myContacts.set(findContact(antiguo),nuevo);
            devolver = true;
        }
        return devolver;
    }
    public static boolean removeContact(Contacto contacto){
        if(findContact(contacto) == -1){
            devolver = false;
        }
        else{
            myContacts.remove(contacto);
            devolver = true;
        }
        return devolver;
    }
    public static Contacto queryContact(String nombre){
        for (Contacto myContact : myContacts) {
            if (myContact.getName().equalsIgnoreCase(nombre)) {
                System.out.println("Tenemos un contacto que coincide con el nombre que has introducido.");
                return myContact;
            }
        }
        System.out.println("No hay ningún contacto que coincida con el nombre que has introducido.");
        return null;
    }
    public static void printContacts(){
        System.out.println("Lista de contactos: ");
        for(int i = 0 ; i < myContacts.size() ; i++){
            System.out.println(i+1+". "+ myContacts.get(i).getName()+" --> "+myContacts.get(i).getPhoneNumber());
        }
    }
}
