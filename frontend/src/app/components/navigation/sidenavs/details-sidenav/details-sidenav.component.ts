import {Component} from '@angular/core';
import {MatTreeNode, MatTreeNodeDef, MatTreeNodePadding, MatTreeNodeToggle} from "@angular/material/tree";
import {MatIconButton} from "@angular/material/button";
import {MatIcon} from "@angular/material/icon";

@Component({
  selector: 'app-details-sidenav',
  standalone: true,
  imports: [
    MatIconButton,
    MatTreeNode,
    MatTreeNodePadding,
    MatTreeNodeToggle,
    MatTreeNodeDef,
    MatIcon
  ],
  templateUrl: './details-sidenav.component.html',
  styleUrl: './details-sidenav.component.scss'
})
export class DetailsSidenavComponent {


}
