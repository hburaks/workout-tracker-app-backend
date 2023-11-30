import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {RouterLink, RouterOutlet} from "@angular/router";
import { HeaderComponent } from './main/header/header.component';
import {LoginService} from "./service/login.service";
import { AppRoutingModule } from './app-routing.module';
import { NavbarComponent } from './main/header/navbar/navbar.component';
import { BodyComponent } from './main/body/body.component';
import { CreateAccountComponent } from './main/body/create-account/create-account.component';
import { LoginComponent } from './main/header/login/login.component';
import {FormsModule} from "@angular/forms";
import { MainComponent } from './main/main.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { ProfileComponent } from './user-dashboard/profile/profile.component';
import {NgOptimizedImage} from "@angular/common";
import { FooterComponent } from './main/footer/footer.component';
import { IconComponent } from './main/header/icon/icon.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    NavbarComponent,
    BodyComponent,
    CreateAccountComponent,
    LoginComponent,
    MainComponent,
    UserDashboardComponent,
    ProfileComponent,
    FooterComponent,
    IconComponent
  ],
    imports: [
        BrowserModule,
        RouterOutlet,
        RouterLink,
        AppRoutingModule,
        FormsModule,
        NgOptimizedImage,
    ],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
