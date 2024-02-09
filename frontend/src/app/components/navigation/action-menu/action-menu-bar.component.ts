import { Component } from '@angular/core';
import {MatIcon} from "@angular/material/icon";
import {MatMenu, MatMenuItem, MatMenuTrigger} from "@angular/material/menu";
import {MatIconButton} from "@angular/material/button";
import {MatDivider} from "@angular/material/divider";

@Component({
  selector: 'app-action-menu-bar',
  standalone: true,
  imports: [
    MatIcon,
    MatMenuTrigger,
    MatMenu,
    MatIconButton,
    MatMenuItem,
    MatDivider
  ],
  templateUrl: './action-menu-bar.component.html',
  styleUrl: './action-menu-bar.component.scss'
})
export class ActionMenuBarComponent {

}
