// package com.springbank.controller;

// import com.springbank.services.impl.AccountServiceImpl;
// import com.springbank.view.LogginView;
// import com.springbank.controller.AccountController;

// public class LogginController{
//     public static void main(){
//         logginView();
//     } 

//     static void logginView(){
//         String[] idAndPass = LogginView.main();
//         if (authenticate(idAndPass)){
//             System.out.println("Logged in");
//         }
//         else {
//             System.out.println("Wrong Id and Pass");
//         }

//     }

//     static boolean authenticate(String args[]) {
//         String idAndPass[] = args;
//         if (AccountServiceImpl.authenticate(idAndPass)){
//             return true;
//         }
//         else {
//             return false;
//         }
//     }
// }