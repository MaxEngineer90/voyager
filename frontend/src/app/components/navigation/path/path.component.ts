import {ChangeDetectionStrategy, Component} from '@angular/core';
import {MatIcon} from "@angular/material/icon";
import {MatButton, MatIconButton} from "@angular/material/button";
import {MatFormField, MatInput, MatLabel} from "@angular/material/input";
import {MatOption, MatSelect} from "@angular/material/select";

@Component({
  selector: 'app-path',
  standalone: true,
  imports: [
    MatIcon,
    MatButton,
    MatIconButton,
    MatInput,
    MatFormField,
    MatSelect,
    MatOption,
    MatLabel
  ],
  templateUrl: './path.component.html',
  styleUrl: './path.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class PathComponent {

}
