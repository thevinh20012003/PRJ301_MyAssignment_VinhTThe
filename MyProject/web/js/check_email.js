/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function validateEmail() {
    var emailInput = document.getElementById("emailInput").value;
    var emailPattern = /@fpt.edu.vn$/;

    if (!emailPattern.test(emailInput)) {
        document.getElementById("errorText").innerHTML = "Email must contain @fpt.edu.vn";
        return false;
    }

    // Clear the error message if the email is valid
    document.getElementById("errorText").innerHTML = "";
    return true;
}