/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author dbarriof
 */
public class FormatoFecha {
    public static String formatFecha(Date d){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(d);
    }
}
