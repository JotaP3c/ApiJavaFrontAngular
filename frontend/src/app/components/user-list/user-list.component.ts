import { Component, OnInit } from '@angular/core';
import { UserService, User } from '../../services/user.service';
import { MatDialog } from '@angular/material/dialog';
import { UserDialogComponent } from '../user-dialog/user-dialog.component';


@Component
({
  selector: 'app-list-user',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit 
{
  users: User[] = [];

  constructor(private userService: UserService, private dialog: MatDialog) {}

  ngOnInit(): void 
  {
    this.getUsers();
  }

  getUsers(): void 
  {
    this.userService.getUsers().subscribe((data) => 
    {
      this.users = data;
    });
  }

  addUser(): void 
  {
    const dialogRef = this.dialog.open(UserDialogComponent, 
    {
      width: '300px',
      data: { nome: '', email: '' }
    });

    dialogRef.afterClosed().subscribe(result => 
    {
      if (result) 
      {
        this.userService.addUser(result).subscribe(() => this.getUsers());
      }
    });
  }

  editUser(user: User): void 
  {
    const dialogRef = this.dialog.open(UserDialogComponent, 
    {
      width: '300px',
      data: { ...user }
    });

    dialogRef.afterClosed().subscribe(result => 
    {
      if (result) 
      {
        this.userService.updateUser(user.id!, result).subscribe(() => this.getUsers());
      }
    });
  }

  deleteUser(id: number): void {
    this.userService.deleteUser(id).subscribe(() => this.getUsers());
  }
}
