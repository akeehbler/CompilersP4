import java.util.List;
import java.util.ArrayList;

/*
* This class represents a symbol in our SymTable 
*/
public class Sym {
    private String type;

    public Sym(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    
    public String toString() {
        return type.toString();
    }
}

/*
* FnSym represents a symbol entry for a funciton node.
*/
class FnSym extends Sym {
    private List<String> formals;
    private String retType;

    public FnSym(String retType) {
        super(retType);
        this.retType = retType;
        this.formals = new ArrayList<String>();
    }
    
    public int getFormalsNum() {
        return formals.size();
    }

    public void addFormals(String type) {
        this.formals.add(type);
    }

    public String getRetType() {
        return retType;
    }

    /*
    * Override the toString() method to make unparsing printout 
    * more simple.
    */
    public String toString(){
        String format = "";
        if(getFormalsNum() != 0){
            for(int i = 0; i < getFormalsNum(); i++){
                format += formals.get(i).toString();
                if(i != getFormalsNum() - 1){
                    format += ", ";
                }
            }
        }
        format += "->" + getRetType(); 
        return format;
    }

}

/*
* This class represents a symbol entry for a struct declaration.
*/
class StructDeclSym extends Sym {

    private StructDefSym body;

    public StructDeclSym(StructDefSym body, String type) {
        super(type);
        this.body = body;
    }
    public StructDefSym getBody(){
        return this.body;
    }
     
}

/*
* This class represents a symbol entry for a struct definition.
*/
class StructDefSym extends Sym {

    private SymTable table;

    public StructDefSym(SymTable table, String type) {
        super(type);
        this.table = table;
    }

    public SymTable getTable() {
        return this.table;
    }
     
}