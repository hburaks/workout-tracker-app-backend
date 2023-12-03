import {Component} from '@angular/core';

@Component({
  selector: 'app-dash-side-bar',
  templateUrl: './dash-side-bar.component.html',
  styleUrls: ['./dash-side-bar.component.css']
})
export class DashSideBarComponent {

  sideBarItems: { header: string, icon: string }[] = [
    {header: "Profile", icon: "bx bxs-user-account"},
    {header: "History", icon: "bx bx-history"},
    {header: "Start Workout", icon: "bx bxs-caret-right-circle"},
    {header: "Exercises", icon: "bx bx-bar-chart"},
    {header: "Measure", icon: "bx bxs-ruler"},
    {header: "Settings", icon: "bx bx-cog"}
  ]

}
