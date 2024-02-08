import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {MatToolbar} from "@angular/material/toolbar";
import {MatListItem, MatNavList} from "@angular/material/list";
import {MatIcon} from "@angular/material/icon";
import {NgForOf} from "@angular/common";
import {NestedTreeControl} from "@angular/cdk/tree";
import {FileNode} from "../../models/file-node";
import {
  MatTree,
  MatTreeNestedDataSource,
  MatTreeNode, MatTreeNodeDef,
  MatTreeNodePadding,
  MatTreeNodeToggle
} from "@angular/material/tree";
import {MatIconButton} from "@angular/material/button";
import {NavigationComponent} from "../navigation/navigation.component";


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, MatToolbar, MatNavList, MatListItem, MatIcon, NgForOf, MatTree, MatTreeNode, MatIconButton, MatTreeNodeToggle, MatTreeNodePadding, MatTreeNodeDef, NavigationComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {

}
