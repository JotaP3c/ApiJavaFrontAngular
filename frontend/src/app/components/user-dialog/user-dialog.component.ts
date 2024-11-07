import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';


@Component
({
  selector: 'app-user-dialog',
  templateUrl: './user-dialog.component.html',
  styleUrls: ['./user-dialog.component.css']
})
export class UserDialogComponent 
{
  constructor 
  
  (
    public dialogRef: MatDialogRef<UserDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: 
    {
      id: any; nome: string; email: string 
    }
  ) 
  
  {}

  onCancel(): void 
  {
    this.dialogRef.close();
  }
}
