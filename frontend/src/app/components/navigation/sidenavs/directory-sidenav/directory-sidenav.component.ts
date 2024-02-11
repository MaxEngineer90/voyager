import {Component} from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {MatSidenavModule} from '@angular/material/sidenav';
import {FormsModule} from "@angular/forms";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {MatIcon} from "@angular/material/icon";
import {
  MatTree,
  MatTreeFlatDataSource,
  MatTreeFlattener,
  MatTreeNode,
  MatTreeNodeDef,
  MatTreeNodePadding,
  MatTreeNodeToggle
} from "@angular/material/tree";
import {ExampleFlatNode, FileNode, TREE_DATA} from "../../../../models/file-node";
import {FlatTreeControl} from "@angular/cdk/tree";

@Component({
  selector: 'app-directory-sidenav',
  standalone: true,
  imports: [MatSidenavModule, MatCheckboxModule, FormsModule, MatButtonModule, MatIcon, MatTreeNode, MatTreeNodeDef, MatTreeNodePadding, MatTreeNodeToggle, MatTree],
  templateUrl: './directory-sidenav.component.html',
  styleUrl: './directory-sidenav.component.scss'
})
export class DirectorySidenavComponent {
  private _transformer = (node: FileNode, level: number) => {
    return {
      expandable: !!node.children && node.children.length > 0,
      name: node.name,
      level: level,
    };
  };

  treeControl = new FlatTreeControl<ExampleFlatNode>(
    node => node.level,
    node => node.expandable,
  );

  treeFlattener = new MatTreeFlattener(
    this._transformer,
    node => node.level,
    node => node.expandable,
    node => node.children,
  );

  dataSource = new MatTreeFlatDataSource(this.treeControl, this.treeFlattener);

  constructor() {
    this.dataSource.data = TREE_DATA;
  }

  hasChild = (_: number, node: ExampleFlatNode) => node.expandable;
}
