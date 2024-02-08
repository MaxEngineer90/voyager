import { Component } from '@angular/core';
import {MatToolbar} from "@angular/material/toolbar";
import {ThemePalette} from "@angular/material/core";
import {MatButton} from "@angular/material/button";
import {MatTab, MatTabContent, MatTabGroup, MatTabLink, MatTabNav, MatTabNavPanel} from "@angular/material/tabs";
import {NgForOf} from "@angular/common";

@Component({
  selector: 'app-navigation',
  standalone: true,
  imports: [
    MatToolbar,
    MatButton,
    MatTabLink,
    MatTabNavPanel,
    MatTabNav,
    MatTabGroup,
    MatTab,
    MatTabContent,
    NgForOf
  ],
  templateUrl: './navigation.component.html',
  styleUrl: './navigation.component.scss'
})
export class NavigationComponent {
  title = 'voyager';
  links = ['First'];
  tabs = [
    { label: 'Tab 1', content: 'Inhalt für Tab 1' },
    { label: 'Tab 2', content: 'Inhalt für Tab 2' },
    // Fügen Sie weitere Tabs wie gewünscht hinzu
  ];
  activeLink = this.links[0];
  background: ThemePalette = "primary";


  addLink() {
    this.links.push(`Link ${this.links.length + 1}`);
  }
}
