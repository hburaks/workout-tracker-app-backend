import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {HeaderComponent} from "./header/header.component";
import {AppComponent} from "./app.component";

const routes: Routes = [
  { path: "header", component: HeaderComponent },
  { path: "heeader", component: HeaderComponent },
];

@NgModule({
  declarations: [],
  imports: [    CommonModule,
    RouterModule.forRoot(routes)]
})
export class AppRoutingModule { }
