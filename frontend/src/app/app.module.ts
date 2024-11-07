//App.module.ts é o pai do projeto, assim como a main.application no java, tudo que for declarado para importar e usar as classes tem que estar aqui

import { NgModule } from '@angular/core';
import { MatTableModule } from '@angular/material/table';
import { MatFormField } from '@angular/material/form-field';
import { UserDialogComponent } from './components/user-dialog/user-dialog.component';
import { UserListComponent } from './components/user-list/user-list.component';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { FormsModule } from '@angular/forms';
import { MatDialogModule } from '@angular/material/dialog';
import { RouterModule } from '@angular/router';
import { UserService } from './services/user.service';
import { routes } from './app.routes';
import { MatFormFieldModule } from '@angular/material/form-field';

@NgModule
({
  declarations: 
  [
    UserListComponent,
    UserDialogComponent,

  ],
  imports:
  [
    MatFormFieldModule,
    MatFormField,
    MatTableModule,
    MatInputModule,
    FormsModule,
    MatDialogModule,
    RouterModule,
    MatButtonModule,
    RouterModule.forRoot(routes),
  ],
  providers: [UserService],
  bootstrap: []
})
export class AppModule {}
