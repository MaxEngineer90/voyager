import {ChangeDetectionStrategy, Component, ViewEncapsulation} from '@angular/core';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatTab, MatTabContent, MatTabGroup, MatTabLink, MatTabNav, MatTabNavPanel} from "@angular/material/tabs";
import {ThemePalette} from "@angular/material/core";
import {RouterLink, RouterLinkActive, RouterOutlet} from "@angular/router";
import {NgForOf} from "@angular/common";
import {MatFormField, MatFormFieldModule} from "@angular/material/form-field";
import {MatInput, MatInputModule} from "@angular/material/input";
import {FormControl} from "@angular/forms";
import {PathComponent} from "./path/path.component";
import {ActionMenuBarComponent} from "./action-menu-bar/action-menu-bar.component";
import {MatSidenav, MatSidenavContainer, MatSidenavContent} from "@angular/material/sidenav";
import {MatListItem, MatNavList} from "@angular/material/list";


@Component({
  selector: 'app-navigation',
  standalone: true,
  imports: [MatToolbarModule, MatButtonModule, MatIconModule, MatTabGroup, MatTab, MatTabNav, MatFormFieldModule, MatInputModule, MatTabLink, PathComponent, ActionMenuBarComponent, MatSidenav, MatSidenavContent, RouterOutlet, MatNavList, MatListItem, MatSidenavContainer],
  templateUrl: './navigation.component.html',
  styleUrl: './navigation.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class NavigationComponent {
  links = ['First'];
  activeLink = this.links[0];

  addLink() {
    this.links.push(`Link ${this.links.length + 1}`);
  }

  removeTab(index: number) {
     this.links.splice(index,1);
  }
}

