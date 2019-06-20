// package com.springbank.controller;

// import com.springbank.services.impl.AccountServiceImpl;
// import com.springbank.view.AccountView;
// import com.springbank.beans.Account;

// public class AccountController{
//     public static void main(String id){
//         // String userInfo[] = AccountServiceImpl.populate(id);
//         Account user = new Account("Jassandip","Shina",21413,"jassandips");  
//         user.info();  
//         accountView();
//     } 


//     static void accountView(){
//         String[] idAndPass = AccountView.main();
//         authenticate(idAndPass);

//     }

//     static void authenticate(String args[]) {
//         String idAndPass[] = args;
//         if (AccountServiceImpl.authenticate(idAndPass)){
            
//         }
//         else {
//             System.out.println("Try again");
//         }
//     }
// }