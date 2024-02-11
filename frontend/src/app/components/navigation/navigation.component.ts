import {ChangeDetectionStrategy, Component} from '@angular/core';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatTab, MatTabGroup, MatTabLink, MatTabNav} from "@angular/material/tabs";
import {RouterOutlet} from "@angular/router";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {FormsModule} from "@angular/forms";
import {PathBarComponent} from "./path-bar/path-bar.component";
import {ActionMenuBarComponent} from "./action-menu-bar/action-menu-bar.component";
import {MatSidenav, MatSidenavContainer, MatSidenavContent} from "@angular/material/sidenav";
import {MatListItem, MatNavList} from "@angular/material/list";
import {TabBarComponent} from "./tab-bar/tab-bar.component";
import {DirectorySidenavComponent} from "./sidenavs/directory-sidenav/directory-sidenav.component";
import {MatCheckbox} from "@angular/material/checkbox";


@Component({
  selector: 'app-navigation',
  standalone: true,
  imports: [MatToolbarModule, MatButtonModule, MatIconModule, MatTabGroup, MatTab, MatTabNav, MatFormFieldModule, MatInputModule, MatTabLink, PathBarComponent, ActionMenuBarComponent, MatSidenav, MatSidenavContent, RouterOutlet, MatNavList, MatListItem, MatSidenavContainer, TabBarComponent, DirectorySidenavComponent, MatCheckbox, FormsModule],
  templateUrl: './navigation.component.html',
  styleUrl: './navigation.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class NavigationComponent {
}

