
package Model;

public enum UkuranEnum {
    S,M,L,XL;
    
    public String getString(){
        if(this == S){
            return "S";
        }else if(this == M){
            return "M";
        }else if(this == L){
            return "L";
        }else{
            return "XL";
        }
    }
}
