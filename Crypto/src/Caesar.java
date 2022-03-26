public class Caesar extends ROT13{

    public Caesar(){
        super('A','D');
        int cryptChange = super.cryptChange;
    }

    public String crypt2(String string){
       return super.crypt(string);
    }


}
