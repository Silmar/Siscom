package br.com.siscom.bean;

import org.jdesktop.beansbinding.Converter;

/**
 * Conversor Booleano para char Fisico e Juridico como 'F' e 'J'
 * @author windows
 */
public class BooleanConverter extends Converter {


    @Override
    public Object convertForward(Object value) {
        Character charPessoa = (Character) value;
  
        if('F' == charPessoa) {
            return Boolean.TRUE;
         } else if ('J' == charPessoa) {
           return Boolean.FALSE;
         } else {
             return null;
         }
    }
    


    @Override
    public Object convertReverse(Object value) {
        Boolean bo = (Boolean)value;
        if (bo == true) {
            return 'F';
        } else {
            return 'J';
        }
    }
}

//    public boolean convertForward(char value){
//        
//        if ('F' == value){
//            return Boolean.TRUE;
//        } else {
//            return Boolean.FALSE;
//        }
//    }
//    public char convertReverse(boolean value){
//        
//        if(value){
//            return 'F';
//        } else {
//            return 'J';
//        }
//        
//    }