import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  header: string = "";
  isForgotPasswordOpen: boolean = false;

  ngOnInit(): void {
    this.header = "Sign In to Your Account";
    this.isForgotPasswordOpen = false;
    throw new Error('Method not implemented.');
  }

  forgotPassword() {
    this.header = "Save Your Password";
    this.isForgotPasswordOpen = true;
  }

  closeForgotPassword() {
    this.header = "Sign In to Your Account";
    this.isForgotPasswordOpen = false;
  }

  //TODO: on init error also do as neetcode


}
