package br.com.siscom.bean;

import org.jdesktop.beansbinding.Converter;

/**
 * Conversor Booleano para char Fisico e Juridico como 'F' e 'J'
 * @author windows
 */
public class BooleanConverterInvert extends Converter {


    @Override
    public Object convertForward(Object value) {
        Character charPessoa = (Character) value;
  
        if('J' == charPessoa) {
            return Boolean.TRUE;
         } else if ('F' == charPessoa) {
           return Boolean.FALSE;
         } else {
             return null;
         }
    }
    


    @Override
    public Object convertReverse(Object value) {
        Boolean bo = (Boolean)value;
        if (bo == true) {
            return 'J';
        } else {
            return 'F';
        }
    }
}
