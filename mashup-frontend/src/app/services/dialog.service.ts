import { Injectable } from '@angular/core';
import { MatDialog } from '@angular/material';
import { MatdialogComponent } from '../_components/matdialog/matdialog.component';

@Injectable({
  providedIn: 'root'
})
export class DialogService {

  constructor(private dialog: MatDialog) { }

  openConfirmDialog(msg){
   return this.dialog.open(MatdialogComponent,{
      width: '400px',
      height: '150px',
      panelClass: 'confirm-dialog-container',
      disableClose: true,
      data :{
        message : msg
      }
    });
  }

}
