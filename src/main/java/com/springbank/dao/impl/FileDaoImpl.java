package com.springbank.dao.impl;

import com.springbank.dao.AccountDao;
import java.io.FileInputStream;
import java.io.IOException;

public class FileDaoImpl implements AccountDao {
    public static Boolean authenticate(String[] idAndPass){
        if(checkId(idAndPass) && checkPass(idAndPass)){
            System.out.println("Correct id and pass!");
            return true;
        }
        else {
            System.out.println("Wrong id and pass!");
            return false;
        }
    }

    public static Boolean checkId(String[] idAndPass){
        try(FileInputStream f= new FileInputStream("loginId.java")){
            int i=0;
            String idSaved = "";
            while((i=f.read())!=-1){    
                idSaved += Character.toString((char)i);}
            if (idSaved.equals(idAndPass[0])){
            return true;}
            else{
                return false;
            }
		}catch(IOException ex) {
            ex.printStackTrace();
            return false;
    }
}

    public static Boolean checkPass(String[] idAndPass){
        try(FileInputStream f= new FileInputStream("loginPass.java")){
            int i=0;
            String passSaved = "";
            while((i=f.read())!=-1){    
                passSaved += Character.toString((char)i);}
            if (passSaved.equals(idAndPass[1])){
                return true;}
                else{
                    return false;
                }
		}catch(IOException ex) {
            ex.printStackTrace();
            return false;
    }
}
}