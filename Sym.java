import java.util.List;
import java.util.ArrayList;

public class Sym {
    private String type;
    private String name;

    public Sym(String type, String name) {
        this.type = type;
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
    
    public String toString() {
        return type + " | " + name;
    }
}

class FnSym extends Sym {
    private List<String> paramTypes;
    private String retType;

    public FnSym(String retType, String name) {
        super("Function", name);
        this.retType = retType;
        this.paramTypes = new ArrayList<String>();
    }
    
    public int getParamNum() {
        return paramTypes.size();
    }

    public void addParam(String type) {
        this.paramTypes.add(type);
    }

    public String getRetType() {
        return retType;
    }

    public String toString(){
        String format = "Type: " + getType() + " | " + "Name: " + getName() + " | " + "Return Type: " + getRetType();
        if(getParamNum() != 0){
            format += "Parameter Types: ";
            for(int i = 0; i < getParamNum(); i++){
                format += paramTypes.get(i);
                if(i != getParamNum() - 1){
                    format += " | ";
                }
            }
        } 
        return format;
    }

}

// TODO Implement this class
class StructDefSym extends Sym {

    private SymTable table;

    public StructDefSym(SymTable table, String type, String name) {
        super(type, name);
        this.table = table;
    }
     
}

// TODO Implement this class
class StructDeclSym extends Sym {

    private StructDefSym body;

    public StructDeclSym(StructDefSym body, String type, String name) {
        super(type, name);
        this.body = body;
    }
    public StructDefSym getBody(){
        return this.body;
    }
    
     
}