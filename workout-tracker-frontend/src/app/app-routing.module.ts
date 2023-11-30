import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {HeaderComponent} from "./header/header.component";
import {LoginComponent} from "./login/login.component";
import {CreateAccountComponent} from "./create-account/create-account.component";
import {AppComponent} from "./app.component";
import {MainComponent} from "./main/main.component";
import {UserDashboardComponent} from "./user-dashboard/user-dashboard.component";

const routes: Routes = [
  { path: "header", component: HeaderComponent },
  { path: "login", component: LoginComponent},
  { path: "create-account", component: CreateAccountComponent},
  { path: "main-page", component: AppComponent},
  { path: "", component: MainComponent},
  { path: "dashboard", component: UserDashboardComponent}
];

@NgModule({
  declarations: [],
  imports: [    CommonModule,
    RouterModule.forRoot(routes)]
})
export class AppRoutingModule { }
