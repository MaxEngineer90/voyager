import {ChangeDetectionStrategy, Component} from '@angular/core';
import {MatIcon} from "@angular/material/icon";
import {MatTabLink, MatTabNav} from "@angular/material/tabs";

@Component({
  selector: 'app-tab-bar',
  standalone: true,
    imports: [
        MatIcon,
        MatTabLink,
        MatTabNav
    ],
  templateUrl: './tab-bar.component.html',
  styleUrl: './tab-bar.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class TabBarComponent {
  links = ['First'];
  activeLink = this.links[0];

  addLink() {
    this.links.push(`Link ${this.links.length + 1}`);
  }

  removeTab(index: number) {
    this.links.splice(index,1);
  }
}
